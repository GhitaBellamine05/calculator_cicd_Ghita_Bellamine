public class ContextCalculator {

    private GhitaCalculator calculator;
    
    public ContextCalculator(GhitaCalculator calculator) {
        this.calculator = calculator;
    }

    //getters and setters
    public GhitaCalculator getCalculator() {
        return calculator;
    }
    public void setCalculator(GhitaCalculator calculator) {
        this.calculator = calculator;
    }

    // execute operations with two operands (a, b)
    public double executeOperation(Operation operation, double a, double b) throws Exception {
        return switch (operation) {
            case ADD -> calculator.add(a, b);
            case SUBTRACT -> calculator.subtract(a, b);
            case MULTIPLY -> calculator.multiply(a, b);
            case DIVIDE -> calculator.divide(a, b);
            case POWER -> calculator.power(a, b);
            case MODULUS -> calculator.modulus(a, b);
            default -> throw new UnsupportedOperationException("Operation not supported for two operands: " + operation);
        };
    }
    // execute operations with a single operand (a)
    public double executeOperation(Operation operation, double a) throws Exception {
        return switch (operation) {
            case SQRT -> calculator.sqrt(a);
            case SIN -> calculator.sin(a);
            case COS -> calculator.cos(a);
            case TAN -> calculator.tan(a);
            default -> throw new UnsupportedOperationException("Operation not supported for single operand: " + operation);
        };
    }
}

    

