import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Liliia_Klymenko on 12-May-15.
 */
public class TestLastTask {

    int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void testOdd() {
        List<Integer> testOddNumbers;
        List<Integer> oddNumbers = new ArrayList<>(Arrays.asList(1,3,5,7,9));
        testOddNumbers = LastTask.odd(array, 10);
        assertEquals(testOddNumbers, oddNumbers);
    }

    @Test
    public void testEven() {
        List<Integer> testEvenNumbers;
        List<Integer> evenNumbers = new ArrayList<>(Arrays.asList(0,2,4,6,8));
        testEvenNumbers = LastTask.even(array, 10);
        assertEquals(testEvenNumbers, evenNumbers);
    }

    @Test
    public void testMin() {
        int min = LastTask.min(array);
        assertEquals(min, 0);
    }

    @Test
    public void testMax() {
        int min = LastTask.max(array);
        assertEquals(min, 9);
    }
}
