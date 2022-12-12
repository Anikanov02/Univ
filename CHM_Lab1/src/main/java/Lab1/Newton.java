package Lab1;

public class Newton extends Lab1 {
    public Newton(double a, double b, double eps) {
        super(a, b, eps);
    }

    @Override
    public double calc() {
        double x = a;

        if (!(f(x) * derSqr(x) > 0)) {
            x = b;
            if (!(f(x) * derSqr(x) > 0)) {
                System.out.println("Не сходится");
            }
        }

        double h = f(x) / der(x);
        while (Math.abs(h) >= eps) {
            h = f(x) / der(x);

            // x(i+1) = x(i) - f(x) / f'(x)
            x = x - h;
        }
        return x;
    }
}
