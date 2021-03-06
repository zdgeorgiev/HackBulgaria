package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator c;

    @Before
    public void initialize() {
        c = new Calculator();
    }

    @Test
    public void testInvalidHandle() {
        c.setExpression("5 + (( 1+2) *4) -3 ");
        assertEquals("5+((1+2)*4)-3", c.getExpression());
    }

    @Test
    public void testRPN1() {
        c.setExpression("5+((1+2)*4)-3");
        assertEquals("5 1 2 + 4 * + 3 -", c.getExpressionToRPN());
    }

    @Test
    public void testRPN2() {
        c.setExpression("3+4*2/(1-5)");
        assertEquals("3 4 2 * 1 5 - / +", c.getExpressionToRPN());
    }

    @Test
    public void testRPN3() {
        c.setExpression("(1*(2+(3/4)))");
        assertEquals("1 2 3 4 / + *", c.getExpressionToRPN());
    }

    @Test
    public void testRPN4() {
        c.setExpression("3+4*2/(1-5)^2^3");
        assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", c.getExpressionToRPN());
    }

    @Test
    public void testRPN5() {
        c.setExpression("(10*(21+(3213/54)))");
        assertEquals("10 21 3213 54 / + *", c.getExpressionToRPN());
    }

    @Test
    public void testPriority() {
        c.setExpression("5*4/5");
        assertEquals(4.0f, c.calc(), 0.1);
    }

    @Test
    public void testNestedExpression() {
        c.setExpression("5+((1+2)*4)-3");
        assertEquals(14.0f, c.calc(), 0.1);
    }

    @Test
    public void testSimpleAddition() {
        c.setExpression("5+3+1");
        assertEquals(9.0f, c.calc(), 0.1);
    }

    @Test
    public void testAnotherCase() {
        c.setExpression("4*(4+5)");
        assertEquals(36.0f, c.calc(), 0.1);
    }

    @Test
    public void testFactorial() {
        c.setExpression("4!");
        assertEquals(24.0f, c.calc(), 0.1);
    }

    @Test
    public void testPower() {
        c.setExpression("3^2");
        assertEquals(9.0f, c.calc(), 0.1);
    }

    @Test
    public void testPowerHard() {
        c.setExpression("(2*3+1*3)!");
        assertEquals(362880.0f, c.calc(), 0.1);
    }

    @Test
    public void testFloatDevision() {
        c.setExpression("2/3");
        assertEquals(0.666666667f, c.calc(), 0.1);
    }

    @Test
    public void testHardest() {
        c.setExpression("2^3!+5*((3+2!)^2)");
        assertEquals(189.0f, c.calc(), 0.1);
    }
}