// src/test/java/GhitaCalculatorTest.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ghita Calculator Tests")
class GhitaTest {

    private final GhitaCalculator calculator = new GhitaCalculator();

    // ----- Original operations -----
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

    // The additional operations
    @Test
    @DisplayName("power operation")
    void testPower() {
        assertEquals(8.0, calculator.power(2.0, 3.0), 0.0001);
    }

    @Test
    @DisplayName("modulus operation")
    void testModulus() {
        assertDoesNotThrow(() -> {
            assertEquals(1.0, calculator.modulus(10.0, 3.0), 0.0001);
        });
    }

    @Test
    @DisplayName("sqrt operation")
    void testSqrt() {
        assertDoesNotThrow(() -> {
            assertEquals(4.0, calculator.sqrt(16.0), 0.0001);
        });
    }

    @Test
    @DisplayName("sqrt negative throws Exception")
    void testSqrtNegative() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.sqrt(-4.0);
        });
        assertEquals("Cannot compute square root of negative number", exception.getMessage());
    }

    @Test
    @DisplayName("sin/cos/tan operations")
    void testTrigFunctions() {
        assertEquals(1.0, calculator.sin(Math.PI / 2), 1e-9);
        assertEquals(0.0, calculator.cos(Math.PI / 2), 1e-9);
        assertEquals(1.0, calculator.tan(Math.PI / 4), 1e-9);
    }
}
