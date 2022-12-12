package Lab1.second;

public class Main {
    public static void main(String[] args) {
        Garden garden = new Garden(3, 3);
        new Thread(garden::gardener, "gardener").start();
        new Thread(garden::nature, "nature").start();
        new Thread(garden::log, "logger").start();
        new Thread(garden::show, "show").start();
    }
}
