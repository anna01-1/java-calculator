import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(new BigDecimal("8"), calculator.evaluate("3 + 5"));
    }

    @Test
    public void testSubtraction() {
        assertEquals(new BigDecimal("4"), calculator.evaluate("9 - 5"));
    }

    @Test
    public void testMultiplication() {
        assertEquals(new BigDecimal("20"), calculator.evaluate("4 * 5"));
    }

    @Test
    public void testDivision() {
        assertEquals(new BigDecimal("3"), calculator.evaluate("9 / 3"));
    }

    @Test
    public void testPower() {
        assertEquals(new BigDecimal("8"), calculator.evaluate("2 ^ 3"));
    }

    @Test
    public void testSquareRoot() {
        assertEquals(new BigDecimal("4"), calculator.evaluate("sqrt 16"));
    }

    @Test
    public void testLogarithm() {
        assertEquals(new BigDecimal("2.302585092994046"), calculator.evaluate("log 10").setScale(15, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testSine() {
        assertEquals(new BigDecimal("0.5"), calculator.evaluate("sin 30").setScale(1, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testCosine() {
        assertEquals(new BigDecimal("0.5"), calculator.evaluate("cos 60").setScale(1, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("1 / 0");
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    public void testLogarithmOfNegativeNumber() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("log -1");
        });
        assertEquals("Logarithm of non-positive number", exception.getMessage());
    }

    @Test
    public void testInvalidExpression() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluate("3 + + 5");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }

    @Test
    public void testHistory() {
        calculator.evaluate("3 + 5");
        calculator.evaluate("10 - 3");
        assertEquals(new BigDecimal("7"), calculator.getHistory().peek());
    }
}
