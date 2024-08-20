package com.example;

public class Calculator {

    // 加法
    public double add(double a, double b) {
        return a + b;
    }

    // 减法
    public double subtract(double a, double b) {
        return a - b;
    }

    // 乘法
    public double multiply(double a, double b) {
        return a * b;
    }

    // 除法
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // 幂运算
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // 平方根
    public double sqrt(double value) {
        if (value < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(value);
    }

    // 归零
    public double reset() {
        return 0;
    }
}
