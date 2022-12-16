package Lab1.second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        new Salon(1).start();
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.2, 3.4).forEach(s -> executorService.submit(() -> System.out.println()));
    }
}
