public class APPMain {
public static void main(String[] args) {
    System.out.println("Calculator Application Started");

    // Create context with TA's implementation
    ContextCalculator context = new ContextCalculator(new GhitaCalculator());

    // Show which implementation is being used
    System.out.println("Using Calculator implementation: " + 
        context.getCalculator().getClass().getSimpleName());

    try {
        double a = 10.0;
        double b = 2.0;

        System.out.println("Addition: " + context.executeOperation(Operation.ADD, a, b));
        System.out.println("Subtraction: " + context.executeOperation(Operation.SUBTRACT, a, b));
        System.out.println("Multiplication: " + context.executeOperation(Operation.MULTIPLY, a, b));
        System.out.println("Division: " + context.executeOperation(Operation.DIVIDE, a, b));

        System.out.println("Power: " + context.executeOperation(Operation.POWER, a, b));
        System.out.println("Modulus: " + context.executeOperation(Operation.MODULUS, a, b));
        System.out.println("Square root of a: " + context.executeOperation(Operation.SQRT, a));
        System.out.println("Sin(a): " + context.executeOperation(Operation.SIN, a));
        System.out.println("Cos(a): " + context.executeOperation(Operation.COS, a));
        System.out.println("Tan(a): " + context.executeOperation(Operation.TAN, a));

    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}
