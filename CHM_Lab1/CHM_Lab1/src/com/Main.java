package com;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dichotomy x = " + new Dichotomy(1.0, 2.0, 0.0001).calc());
        System.out.println("Relaxation x = " + new Relaxation(1.0, 2.0, 0.0001).calc());
        System.out.println("Newton = " + new Newton(1.0, 2.0, 0.0001).calc());
    }
}
