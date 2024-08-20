package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    // 测试加法
    @Test
    public void testAddition() throws Exception {
        assertEquals(new BigDecimal("8"), calculator.evaluate("3 + 5"));
    }

    // 测试减法
    @Test
    public void testSubtraction() throws Exception {
        assertEquals(new BigDecimal("4"), calculator.evaluate("9 - 5"));
    }

    // 测试乘法
    @Test
    public void testMultiplication() throws Exception {
        assertEquals(new BigDecimal("20"), calculator.evaluate("4 * 5"));
    }

    // 测试除法
    @Test
    public void testDivision() throws Exception {
        assertEquals(new BigDecimal("3"), calculator.evaluate("9 / 3"));
    }

    // 测试除以零
    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("1 / 0");
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    // 测试无效表达式
    @Test
    public void testInvalidExpression() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("3 + + 5");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }

    // 测试无效操作符
    @Test
    public void testInvalidOperator() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("3 ^ 5");
        });
        assertEquals("Invalid operator", exception.getMessage());
    }

    // 测试浮点数加法
    @Test
    public void testFloatingPointAddition() throws Exception {
        assertEquals(new BigDecimal("5.5"), calculator.evaluate("2.5 + 3.0"));
    }

    // 测试浮点数减法
    @Test
    public void testFloatingPointSubtraction() throws Exception {
        assertEquals(new BigDecimal("1.5"), calculator.evaluate("5.5 - 4.0"));
    }

    // 测试浮点数乘法
    @Test
    public void testFloatingPointMultiplication() throws Exception {
        assertEquals(new BigDecimal("7.5"), calculator.evaluate("2.5 * 3.0"));
    }

    // 测试浮点数除法
    @Test
    public void testFloatingPointDivision() throws Exception {
        assertEquals(new BigDecimal("2.0"), calculator.evaluate("6.0 / 3.0"));
    }

    // 测试无效表达式格式
    @Test
    public void testInvalidExpressionFormat() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("3 + ");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }

    // 测试多余的空格
    @Test
    public void testExtraSpaces() throws Exception {
        assertEquals(new BigDecimal("10"), calculator.evaluate("  4   +   6  "));
    }

    // 测试不同的数字分隔符
    @Test
    public void testDifferentDecimalSeparator() throws Exception {
        assertEquals(new BigDecimal("5.75"), calculator.evaluate("2.5 + 3.25"));
    }
}
