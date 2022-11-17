import sun.misc.Signal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class ComputationManager {
    private AsynchronousServerSocketChannel server;
    private static final int PORT = 4004;

    private int functionsAmount;
    private List<Integer> args;

    private boolean cancel = false;
    private List<Process> processes;
    private boolean result = true;


    public ComputationManager(int functionsAmount, List<Integer> args) throws IOException {
        server = AsynchronousServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost", PORT));
        this.functionsAmount = functionsAmount;
        this.args = args;
        this.processes = new ArrayList<>();
    }

    private List<AsynchronousSocketChannel> prepareCalculationClients(String fileWithProcess)
            throws IOException, ExecutionException, InterruptedException {
        for (int i = 0; i < functionsAmount; i++) {
            runProcess(fileWithProcess);
        }
        List<AsynchronousSocketChannel> clients = connectClients();
        passArguments(clients);
        return clients;
    }

    private void runProcess(String fileWithProcess) throws IOException {
        Process process = Runtime.getRuntime().exec(
                "java -cp " + "out\\artifacts\\calc_processes\\calculation_processes.jar "
                        + fileWithProcess + " " + PORT);
        processes.add(process);
    }

    private List<AsynchronousSocketChannel> connectClients() throws ExecutionException, InterruptedException {
        List<AsynchronousSocketChannel> clients = new ArrayList<>(functionsAmount);
        for (int i = 0; i < functionsAmount; i++) {
            Future<AsynchronousSocketChannel> client = server.accept();
            clients.add(client.get());
        }
        return clients;
    }

    private void passArguments(List<AsynchronousSocketChannel> clients) throws ExecutionException, InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        for (int i = 0; i < functionsAmount; i++) {
            buffer.putInt(args.get(i));
            buffer.rewind();
            Future<Integer> writeFuture = clients.get(i).write(buffer);
            writeFuture.get();
            buffer.clear();
        }
    }

    private List<Future<Integer>> initializeResultFutures(List<AsynchronousSocketChannel> clients,
                                                          ByteBuffer buffer) {
        List<Future<Integer>> futures = new ArrayList<>(clients.size());
        for (AsynchronousSocketChannel client : clients) {
            futures.add(client.read(buffer));
        }
        return futures;
    }

    private ResultInfo getResult(Future<Integer> resultFuture, ByteBuffer buffer)
            throws ExecutionException, InterruptedException {
        resultFuture.get();
        buffer.rewind();
        return new ResultInfo(buffer);
    }

    private static class ResultInfo {
        boolean result;
        char functionType;
        long calculationTime;

        ResultInfo(ByteBuffer buffer) {
            buffer.rewind();
            this.result = buffer.getInt() == 1;
            this.calculationTime = buffer.getLong();
            this.functionType = buffer.getChar();
        }
    }

    private int checkFuturesForResult(List<Future<Integer>> futures, ByteBuffer buffer)
            throws ExecutionException, InterruptedException {
        for (Future<Integer> resultFuture : futures) {
            if (resultFuture.isDone()) {
                ResultInfo currResult = getResult(resultFuture, buffer);
                buffer.clear();

                if (!currResult.result) {
                    result = false;
                    for (Process process : processes) {
                        process.destroy();
                    }
                    return 0;
                } else {
                    futures.remove(resultFuture);
                    return 1;
                }
            }
        }
        return -1;
    }

    private void printResult(List<Future<Integer>> resultFuturesF,
                             List<Future<Integer>> resultFuturesG,
                             ByteBuffer resultBuffer)
            throws ExecutionException, InterruptedException {
        if (cancel && result) {
            int checkResult = checkFuturesForResult(resultFuturesF, resultBuffer);
            if (checkResult != 0) {
                checkResult = checkFuturesForResult(resultFuturesG, resultBuffer);
                if (checkResult != 0) {
                    System.out.println("Computation was cancelled.");
                    System.out.println(resultFuturesF.size() + " F functions were not calculated.");
                    System.out.println(resultFuturesG.size() + " G functions were not calculated.");
                    return;
                }
            }
        }

        System.out.println("Your result of computation: " + result + ".");
    }

    public void run() throws IOException, ExecutionException, InterruptedException {
        List<AsynchronousSocketChannel> FClients = prepareCalculationClients("FProcess");
        List<AsynchronousSocketChannel> GClients = prepareCalculationClients("GProcess");

        ByteBuffer resultBuffer = ByteBuffer.allocate(Integer.BYTES + Long.BYTES + Character.BYTES);
        List<Future<Integer>> resultFuturesF = initializeResultFutures(FClients, resultBuffer);
        List<Future<Integer>> resultFuturesG = initializeResultFutures(GClients, resultBuffer);

        ScheduledExecutorService promptExecutor = Executors.newScheduledThreadPool(0);
        AtomicBoolean specialKeyPressed = new AtomicBoolean(false);
        AtomicBoolean resultCalculated = new AtomicBoolean(false);
        AtomicBoolean promptRunning = new AtomicBoolean(false);

        Signal.handle(new Signal("INT"),
                signal -> {synchronized(specialKeyPressed) {specialKeyPressed.set(true);}});

        TimerTask prompt = new TimerTask() {
            @Override
            public void run() {
                long endTime = System.currentTimeMillis() + 2000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (resultCalculated) {
                        if (resultCalculated.get()) {
                            promptExecutor.shutdownNow();
                            return;
                        }
                    }
                    synchronized (specialKeyPressed) {
                        if (specialKeyPressed.get()) {
                            break;
                        }
                    }
                }

                String answer = "";
                synchronized (promptRunning) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Do you want to continue? (a - continue, b - continue without prompt, c - stop)");
                    answer = "";
                    try {
                        answer = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (resultCalculated.get()) {
                    promptExecutor.shutdownNow();
                    return;
                }
                if (answer.equals("a") && !resultCalculated.get()) {
                    specialKeyPressed.set(false);
                    promptExecutor.schedule(this, 0L, TimeUnit.MILLISECONDS);
                } else if (answer.equals("b")) {
                    promptExecutor.shutdownNow();
                } else {
                    cancel = true;
                    promptExecutor.shutdownNow();
                }
            }
        };

        promptExecutor.schedule(prompt, 0L, TimeUnit.MILLISECONDS);
        while (!resultFuturesF.isEmpty() || !resultFuturesG.isEmpty()) {
            if (cancel) {
                break;
            }

            int checkResult = checkFuturesForResult(resultFuturesF, resultBuffer);
            if (checkResult == 0) {
                break;
            }

            checkResult = checkFuturesForResult(resultFuturesG, resultBuffer);
            if (checkResult == 0) {
                break;
            }
        }
        synchronized (resultCalculated) {
            resultCalculated.set(true);
        }
        promptExecutor.shutdown();

        synchronized (promptRunning) {}
        printResult(resultFuturesF, resultFuturesG, resultBuffer);
    }
}
