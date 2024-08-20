package com.example.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {

    // 用于执行计算
    public BigDecimal evaluate(String expression) throws Exception {
        String[] tokens = expression.split(" ");
        if (tokens.length != 3) {
            throw new Exception("Invalid expression");
        }

        BigDecimal num1 = new BigDecimal(tokens[0]);
        String operator = tokens[1];
        BigDecimal num2 = new BigDecimal(tokens[2]);

        switch (operator) {
            case "+":
                return num1.add(num2);
            case "-":
                return num1.subtract(num2);
            case "*":
                return num1.multiply(num2);
            case "/":
                if (num2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new Exception("Division by zero");
                }
                return num1.divide(num2, MathContext.DECIMAL128);
            default:
                throw new Exception("Invalid operator");
        }
    }
}
