public class GhitaCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("Division by zero");
        }
        return a / b;
    }
    // New mathematical operations
    // power
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Square root
    public double sqrt(double a) throws Exception {
        if (a < 0) throw new Exception("Cannot compute square root of negative number");
        return Math.sqrt(a);
    }

    // Modulus: remainder of a / b
    public double modulus(double a, double b) throws Exception {
        if (b == 0) throw new Exception("Division by zero in modulus");
        return a % b;
    }

    // Sine, Cosine, Tangent (angle in radians)
    public double sin(double angle) {
        return Math.sin(angle);
    }

    public double cos(double angle) {
        return Math.cos(angle);
    }

    public double tan(double angle) {
        return Math.tan(angle);
    }
}
