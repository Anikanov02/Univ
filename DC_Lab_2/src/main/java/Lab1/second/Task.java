package Lab1.second;

import java.util.LinkedList;
import java.util.Queue;

public class Task {
    private int hands;
    private int range;
    private int count;
    private boolean running;
    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public Task(int range) {
        this.range = range;
        this.hands = 2;
        this.count = 0;
        running = true;
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void step1() {
        boolean finished = false;
        while (running && !finished) {
            synchronized (queue1) {
                while (queue1.size() >= hands) {
                    try {
                        queue1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Integer item = count++;
                queue1.add(item);
                queue1.notifyAll();
                System.out.println("step 1: add " + item + " to queue1");

                if (item >= range) {
                    finished = true;
                }
            }
        }
    }

    public void step2() {
        while (running) {
            Integer item;
            synchronized (queue1) {
                while (queue1.isEmpty()) {
                    try {
                        queue1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                item = queue1.poll();
                queue1.notifyAll();
                System.out.println("Step 2: retrieve " + item + " from queue1");
            }

            synchronized (queue2) {
                while (queue2.size() >= hands) {
                    try {
                        queue2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                queue2.add(item);
                queue2.notifyAll();
                System.out.println("Step 2: add " + item + " to queue2");
            }
        }
    }

    public void step3() {
        while (running) {
            synchronized (queue2) {
                while (queue2.isEmpty()) {
                    try {
                        queue2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Integer item = queue2.poll();
                queue2.notifyAll();
                System.out.println("Step 3: retrieve " + item + " from queue2");
            }
        }
    }

    public void disable() {
        running = false;
    }
}
