package com;

public class Dichotomy extends Lab1 {
    public Dichotomy(double a, double b, double eps) {
        super(a, b, eps);
    }

    @Override
    public double calc() {
        double c;
        double newC = 0;
        if (f(a) * f(b) < 0) {
            do {
                c = (a + b) / 2;
                if (f(a) * f(c) < 0) {
                    b = c;
                } else {
                    a = c;
                }
                newC = (a + b) / 2;

            } while (Math.abs(newC - c) >= 2 * eps);
        }
        return newC;
    }
}
