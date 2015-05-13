/**
 * Created by Liliia_Klymenko on 12-May-15.
 */
public class Calculator {
    public int calculate(int a, int b) {
        if (b == 0) throw new ArithmeticException();
        return a / b;
    }
}
