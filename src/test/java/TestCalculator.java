/**
 * Created by Liliia_Klymenko on 12-May-15.
 */

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestCalculator {

    @Test
    public void testCalculator() {
        Calculator calc = new Calculator();
        int n = calc.calculate(4, 2);
        assertThat(n, is(2));
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatorWithExcoption() {
        Calculator calc = new Calculator();
        int n = calc.calculate(9, 0);
    }
}
