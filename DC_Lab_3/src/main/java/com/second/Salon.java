package com.second;

import java.util.Random;

public class Salon {
    private boolean running;
    private Master master;
    private Client clients;

    public Salon(int capacity) {
        this.running = true;
    }

    public void start() {
        running = true;
        master = new Master();
        clients = new Client();
        new Thread(master).start();
        generateNewClient();
    }

    public void disable() {
        running = false;
    }

    private class Master implements Runnable {
        private boolean busy;
        private String currentClient;

        public Master() {
            busy = false;
        }

        public void acquire(String currentClient) {
            busy = true;
            this.currentClient = currentClient;
        }

        public void release() {
            busy = false;
        }

        @Override
        public void run() {
            while (running) {
                synchronized (this) {
                    while (!busy) {
                        try {
                            master.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Client : " + currentClient);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    release();
                    System.out.println("haircut done for " + currentClient);
                    master.notifyAll();
                }
            }
        }
    }

    private class Client implements Runnable {
        private int clients;

        public Client() {
            clients = 0;
        }

        @Override
        public void run() {
            if (running) {
                synchronized (master) {
                    while (master.busy) {
                        try {
                            master.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    master.acquire(Thread.currentThread().getName());
                    master.notifyAll();
                }
            }
        }

        public void newClient() {
            clients++;
            System.out.println("created Client " + clients);
            new Thread(this, "Client " + clients).start();
        }
    }

    private void generateNewClient() {
        while (running) {
            synchronized (clients) {
                try {
                    Thread.sleep(new Random().nextInt(100, 500));
                    clients.newClient();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
