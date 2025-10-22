// src/main/java/Operation.java
public enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public static Operation fromString(String op) {
        return switch (op.toLowerCase()) {
            case "add" -> ADD;
            case "subtract" -> SUBTRACT;
            case "multiply" -> MULTIPLY;
            case "divide" -> DIVIDE;
            default -> throw new UnsupportedOperationException("Operation not supported: " + op);
        };
    }
}