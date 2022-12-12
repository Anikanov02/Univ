package Lab1.second;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Garden {
    private boolean[][] state;
    private boolean running;
    private Lock readLock;
    private Lock writeLock;
    private File logFile;

    public Garden(int dim1, int dim2) {
        state = new boolean[dim1][dim2];
        running = true;
        ReadWriteLock lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        logFile = new File("src/main/resources/second/log.txt");

        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                state[i][j] = true;
            }
        }
    }

    public void gardener() {
        while (running) {
            writeLock.lock();
            System.out.println(Thread.currentThread() + "started working");
            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state[i].length; j++) {
                    if (!state[i][j]) {
                        state[i][j] = true;
                        System.out.println(String.format("Gardener watered i=%d j=%d flower", i, j));
                    }
                }
            }
            System.out.println(Thread.currentThread() + "stopped working");
            writeLock.unlock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void nature() {
        while (running) {
            writeLock.lock();
            System.out.println(Thread.currentThread() + "started working");
            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state[i].length; j++) {
                    if (state[i][j]) {
                        boolean fresh = Math.random() > 0.5;
                        if (!fresh) {
                            state[i][j] = false;
                            System.out.println(String.format("Nature faded i=%d j=%d flower", i, j));
                        }
                    }
                }
            }
            System.out.println(Thread.currentThread() + "stopped working");
            writeLock.unlock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void log() {
        while (running) {
            readLock.lock();
            System.out.println(Thread.currentThread() + "started working");
            try (FileOutputStream out = new FileOutputStream(logFile, true)) {
                out.write((Arrays.deepToString(state) + System.lineSeparator()).getBytes());
                System.out.println(Thread.currentThread() + "logged");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread() + "stopped working");
            readLock.unlock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void show() {
        while (running) {
            readLock.lock();
            System.out.println(Thread.currentThread() + "started working");
            System.out.println(Arrays.deepToString(state));
            System.out.println(Thread.currentThread() + "stopped working");
            readLock.unlock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}