package com.second;

public class Main {
    public static void main(String[] args) {
        Task task = new Task(100);
        new Thread(task::step1).start();
        new Thread(task::step2).start();
        new Thread(task::step3).start();
    }
}
