package com;

public class Relaxation extends Lab1 {
    public Relaxation(double a, double b, double eps) {
        super(a, b, eps);
    }

    @Override
    public double calc() {
        double m1 = 2, M1 = 6, tau = -2 / (m1 + M1), x1 = a, x = Double.MAX_VALUE;
        int i = 0;
        while (Math.abs(x - x1) >= eps) {
            x = x1;
            x1 = x + tau * f(x);
            i++;
        }
        return x;
    }
}
