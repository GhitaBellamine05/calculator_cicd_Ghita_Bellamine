public class APPMain {
public static void main(String[] args) {
    System.out.println("Calculator Application Started");

    // Create context with TA's implementation
    ContextCalculator context = new ContextCalculator(new TACalculator());

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
        // Implements other operations as you see fit

    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}
