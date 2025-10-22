// src/test/java/TACalculatorTest.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TA Calculator Tests")
class TACalculatorTest {

    private final Calculator calculator = new TACalculator();

    @ParameterizedTest(name = "add({0}, {1}) = {2}")
    @CsvSource({
        "2.0, 3.0, 5.0",
        "0.0, 0.0, 0.0",
        "-1.0, 1.0, 0.0",
        "10.5, -2.5, 8.0",
        "-5.0, -3.0, -8.0"
    })
    void testAdd(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), 0.0001);
    }

    @ParameterizedTest(name = "subtract({0}, {1}) = {2}")
    @CsvSource({
        "5.0, 3.0, 2.0",
        "0.0, 0.0, 0.0",
        "1.0, -1.0, 2.0",
        "-2.5, 3.5, -6.0",
        "-5.0, -3.0, -2.0"
    })
    void testSubtract(double a, double b, double expected) {
        assertEquals(expected, calculator.subtract(a, b), 0.0001);
    }

    @ParameterizedTest(name = "multiply({0}, {1}) = {2}")
    @CsvSource({
        "2.0, 3.0, 6.0",
        "0.0, 100.0, 0.0",
        "-2.0, 3.0, -6.0",
        "-2.0, -3.0, 6.0",
        "1.5, 2.0, 3.0"
    })
    void testMultiply(double a, double b, double expected) {
        assertEquals(expected, calculator.multiply(a, b), 0.0001);
    }

    @ParameterizedTest(name = "divide({0}, {1}) = {2}")
    @CsvSource({
        "6.0, 3.0, 2.0",
        "0.0, 5.0, 0.0",
        "-6.0, 3.0, -2.0",
        "-6.0, -3.0, 2.0",
        "7.5, 2.5, 3.0"
    })
    void testDivide(double a, double b, double expected) {
        assertDoesNotThrow(() -> {
            assertEquals(expected, calculator.divide(a, b), 0.0001);
        });
    }

    @Test
    @DisplayName("divide by zero throws Exception")
    void testDivideByZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.divide(1.0, 0.0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    @DisplayName("divide by negative zero throws Exception")
    void testDivideByNegativeZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.divide(1.0, -0.0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    @DisplayName("handles large numbers")
    void testLargeNumbers() {
        double large = 1e10;
        assertEquals(2e10, calculator.add(large, large), 1e5);
        assertEquals(1e20, calculator.multiply(large, large), 1e10);
    }

    @Test
    @DisplayName("handles very small numbers")
    void testSmallNumbers() {
        double small = 1e-10;
        assertEquals(2e-10, calculator.add(small, small), 1e-15);
        assertEquals(0.0, calculator.subtract(small, small), 1e-15);
    }
}