

public interface Calculator {
    /**
     * Adds two numbers.
     */
    double add(double a, double b);

    /**
     * Subtracts b from a.
     */
    double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     */
    double multiply(double a, double b);

    /**
     * Divides a by b.
     * @throws CalculatorException if b is 0
     */
    double divide(double a, double b) throws Exception;


}