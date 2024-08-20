import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.lang.Math;

public class Calculator {
    
    private Stack<BigDecimal> history = new Stack<>();
    private BigDecimal result = BigDecimal.ZERO;
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Simple Calculator with advanced features. Type 'exit' to quit.");
        
        while (true) {
            System.out.print("Enter an expression: ");
            input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                BigDecimal result = calc.evaluate(input);
                calc.history.push(result);
                System.out.println("Result: " + result);
                System.out.println("History: " + calc.history);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    public BigDecimal evaluate(String expression) throws Exception {
        try {
            // Tokenize and parse the expression
            String[] tokens = expression.split(" ");
            Stack<BigDecimal> values = new Stack<>();
            Stack<String> operators = new Stack<>();
            
            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    values.push(new BigDecimal(token));
                } else if (token.equals("(")) {
                    operators.push(token);
                } else if (token.equals(")")) {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.pop();
                } else if (isOperator(token)) {
                    while (!operators.isEmpty() && precedence(token) <= precedence(operators.peek())) {
                        values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(token);
                } else {
                    throw new IllegalArgumentException("Unknown token: " + token);
                }
            }
            
            while (!operators.isEmpty()) {
                values.push(applyOp(operators.pop(), values.pop(), values.pop()));
            }
            
            return values.pop();
        } catch (EmptyStackException | NumberFormatException e) {
            throw new Exception("Invalid expression");
        }
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")
               || token.equals("^") || token.equals("sqrt") || token.equals("log") || token.equals("sin") || token.equals("cos");
    }
    
    private int precedence(String op) {
        switch (op) {
            case "+": case "-":
                return 1;
            case "*": case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }
    
    private BigDecimal applyOp(String op, BigDecimal b, BigDecimal a) throws Exception {
        switch (op) {
            case "+":
                return a.add(b);
            case "-":
                return a.subtract(b);
            case "*":
                return a.multiply(b);
            case "/":
                if (b.equals(BigDecimal.ZERO)) throw new ArithmeticException("Division by zero");
                return a.divide(b, MathContext.DECIMAL128);
            case "^":
                return new BigDecimal(Math.pow(a.doubleValue(), b.doubleValue()));
            case "sqrt":
                return new BigDecimal(Math.sqrt(a.doubleValue()));
            case "log":
                if (a.doubleValue() <= 0) throw new ArithmeticException("Logarithm of non-positive number");
                return new BigDecimal(Math.log(a.doubleValue()));
            case "sin":
                return new BigDecimal(Math.sin(Math.toRadians(a.doubleValue())));
            case "cos":
                return new BigDecimal(Math.cos(Math.toRadians(a.doubleValue())));
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
