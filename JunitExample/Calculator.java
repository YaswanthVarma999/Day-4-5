package com.junitExample;
public class Calculator {

    // Method to perform addition
    public int add(int a, int b) {
        return a + b;
    }

    // Method to perform subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to perform multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to perform division
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // Method to perform modulo operation
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot modulo by zero");
        }
        return a % b;
    }
}
