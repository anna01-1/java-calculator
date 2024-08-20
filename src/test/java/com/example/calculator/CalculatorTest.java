package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(5, 4));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    @Test
    public void testPower() {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.power(3, 2));
    }

    @Test
    public void testSqrt() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.sqrt(9));
    }

    @Test
    public void testSqrtNegative() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(-1));
    }

    @Test
    public void testReset() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.reset());
    }
}
