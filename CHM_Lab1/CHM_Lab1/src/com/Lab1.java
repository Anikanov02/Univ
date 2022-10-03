package com;

public abstract class Lab1 {
    protected double a;
    protected double b;
    protected double eps;

    public Lab1(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    protected double f(double x) {
        return Math.pow(x, 2) - 4;
    }

    protected double der(double x) {
        return 2 * x;
    }

    protected double derSqr(double x) {
        return 2;
    }

    public abstract double calc();
}
