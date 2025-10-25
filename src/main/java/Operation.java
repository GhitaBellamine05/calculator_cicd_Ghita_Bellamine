// src/main/java/Operation.java
public enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE,POWER,SQRT,MODULUS,SIN,COS,TAN;

    public static Operation fromString(String op) {
        return switch (op.toLowerCase()) {
            case "add" -> ADD;
            case "subtract" -> SUBTRACT;
            case "multiply" -> MULTIPLY;
            case "divide" -> DIVIDE;
            case "power" -> POWER;
            case "sqrt" -> SQRT;
            case "modulus" -> MODULUS;
            case "sin" -> SIN;
            case "cos" -> COS;
            case "tan" -> TAN;
            default -> throw new UnsupportedOperationException("Operation not supported: " + op);
        };
    }
}