package com.first;

public class Task {
    private final Pot pot;
    private boolean running;

    public Task(int bees, int potCapacity) {
        this.pot = new Pot(potCapacity);
        this.running = true;

        for (int i = 0; i < bees; i++) {
            new Thread(this::bee, "Bee " + i).start();
        }

        new Thread(this::bear, "Bear").start();
    }

    public void disable() {
        running = false;
    }

    public void bee() {
        while (running) {
            synchronized (pot) {
                while (pot.current >= pot.capacity) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                pot.fill();
                pot.notifyAll();
                System.out.println(Thread.currentThread() + " filled pot, current honey: " + pot.current);
            }
        }
    }

    public void bear() {
        while (running) {
            synchronized (pot) {
                while (pot.current < pot.capacity) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                pot.empty();
                pot.notifyAll();
                System.out.println(Thread.currentThread() + " emptied pot, current honey: " + pot.current);
            }
        }
    }

    private static final class Pot {
        private final int capacity;
        private int current;

        public Pot(int capacity) {
            this.capacity = capacity;
            current = 0;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getCurrent() {
            return current;
        }

        public void fill() {
            if (current < capacity) {
                current++;
            } else {
                throw new RuntimeException("current > capacity");
            }
        }

        public void empty() {
            current = 0;
        }
    }
}
