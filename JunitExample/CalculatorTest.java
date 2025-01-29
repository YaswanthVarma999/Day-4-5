package com.junitExample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class)  // Test priority
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    // Test Addition with negative and positive numbers
    @Order(1)  // Priority 1
    @ParameterizedTest
    @CsvSource({
        "5, -3, 2",   // Positive + Negative
        "-3, 5, 2"    // Negative + Positive
    })
    void testAddition(int a, int b, int expected) {
        int result = calculator.add(a, b);
        System.out.println("Adding " + a + " and " + b + " gives " + result);
        assertEquals(expected, result, a + " + " + b + " should be " + expected);
    }

    // Test Subtraction with negative and positive numbers
    @Order(2)  // Priority 2
    @ParameterizedTest
    @CsvSource({
        "5, -3, 8",   // Positive - Negative
        "-3, 5, -8"   // Negative - Positive
    })
    void testSubtraction(int a, int b, int expected) {
        int result = calculator.subtract(a, b);
        System.out.println("Subtraction " + a + " and " + b + " gives " + result);
        assertEquals(expected, result, a + " - " + b + " should be " + expected);
    }

    // Test Multiplication with negative and positive numbers
    @Order(3)  // Priority 3
    @ParameterizedTest
    @CsvSource({
        "5, -3, -15",  // Positive * Negative
        "-3, 5, -15"   // Negative * Positive
    })
    void testMultiplication(int a, int b, int expected) {
        int result = calculator.multiply(a, b);
        System.out.println("Multiplying " + a + " and " + b + " gives " + result);
        assertEquals(expected, result, a + " * " + b + " should be " + expected);
    }

    // Test Division with negative and positive numbers
    @Order(4)  // Priority 4
    @ParameterizedTest
    @CsvSource({
        "6, -3, -2.0",  // Positive / Negative
        "-6, 3, -2.0"   // Negative / Positive
    })
    void testDivision(int a, int b, double expected) {
        double result = calculator.divide(a, b);
        System.out.println("Dividing " + a + " and " + b + " gives " + result);
        assertEquals(expected, result, 0.0001);
    }

    // Test Division by Zero
    @Order(5)  // Priority 5
    @ParameterizedTest
    @CsvSource({
        "5, 0",   // Division by zero case
        "-3, 0"   // Negative division by zero
    })
    void testDivisionByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }

    // Test Modulo with negative and positive numbers
    @Order(6)  // Priority 6
    @ParameterizedTest
    @CsvSource({
        "5, -3, 2",   // Positive % Negative
        "-3, 5, -3"   // Negative % Positive
    })
    void testModulo(int a, int b, int expected) {
        int result = calculator.modulo(a, b);
        System.out.println("Modulo " + a + " and " + b + " gives " + result);
        assertEquals(expected, result);
    }

    // Test Modulo by Zero
    @Order(7)  // Priority 7
    @ParameterizedTest
    @CsvSource({
        "5, 0",   // Modulo by zero case
        "-3, 0"   // Negative modulo by zero
    })
    void testModuloByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> calculator.modulo(a, b));
    }
}