package Lab1;

public class Dichotomy extends Lab1 {
    public Dichotomy(double a, double b, double eps) {
        super(a, b, eps);
    }

    @Override
    public double calc() {
        return dichotomy(a, b, eps);
    }

    public double dichotomy(double a, double b, double e) {
        double c=(a+b)/2;
        if (b-a <= eps) return c;

        if (f(a)*f(c) < 0) return dichotomy(a,c,e);
        else if (f(a)*f(c) > 0) return dichotomy(c,b,e);
        else return c;
    }
}
