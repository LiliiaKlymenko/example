/**
 * Created by Liliia_Klymenko on 12-May-15.
 */

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestCalculator {

    @Test
    public void testCalculator() {
        Calculator calc = new Calculator();
        int n = calc.calculate(4, 2);
        assertEquals(2, n);
    }

    @Test(expected = Exception.class)
    public void testCalculatorWithExcoption() {
        Calculator calc = new Calculator();
        int n = calc.calculate(9, 0);
    }
}
