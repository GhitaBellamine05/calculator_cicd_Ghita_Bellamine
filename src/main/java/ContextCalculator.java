public class ContextCalculator {

    private Calculator calculator;
    
    public ContextCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    //getters and setters
    public Calculator getCalculator() {
        return calculator;
    }
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    // Execute operation
    public double executeOperation(Operation operation, double a, double b) throws Exception {
        return switch (operation) {
            case ADD -> calculator.add(a, b);
            case SUBTRACT -> calculator.subtract(a, b);
            case MULTIPLY -> calculator.multiply(a, b);
            case DIVIDE -> calculator.divide(a, b);
        };
    }
    
}
