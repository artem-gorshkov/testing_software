package itmo.gorhskov.tpo;


public class Calculator {

    static double sin(double x) {
        double result = 0;
        int sign = 1;
        double xx = x * x;
        double power = x;
        double fact = 1.0;
        for (int i = 1; i < 100; i += 2) {
            fact /= i;
            result += sign * power * fact;
            fact /= (i + 1);
            sign = -sign;
            power *= xx;
        }
        return Math.round(result * 10E2) / 10E2;
    }
}
