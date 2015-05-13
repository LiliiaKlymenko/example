import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Liliia_Klymenko on 12-May-15.
 */
public class TestLastTask {

    final int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    final int[] array2 = {0, 112, 222, 3232, 4619, 5, 625, 777, 801, 91};
    final int ARRAY_LENGHT = 10;
    final int MIN_ELEMENT = 0;
    final int MAX_ELEMENT = 9;

    @Test
    public void testOdd() {
        List<Integer> actualList;
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9));
        actualList = LastTask.odd(array, ARRAY_LENGHT);
        assertThat(expectedList, is(actualList));
    }

    @Test
    public void testEven() {
        List<Integer> actualList;
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(0, 2, 4, 6, 8));
        actualList = LastTask.even(array, ARRAY_LENGHT);
        assertThat(expectedList, is(actualList));
    }

    @Test
    public void testMin() {
        int min = LastTask.min(array);
        assertEquals(MIN_ELEMENT, min);
    }

    @Test
    public void testMax() {
        int min = LastTask.max(array);
        assertEquals(MAX_ELEMENT, min);
    }

    @Test
    public void testDivByThree() {
        List<Integer> actualList = LastTask.divByThree(array, ARRAY_LENGHT);
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(0, 3, 6, 9));
        assertThat(expectedList, is(actualList));
    }

    @Test
    public void testThreeDigitNumbers() {
        List<Integer> actualList = LastTask.threeDigitNumbers(array2, ARRAY_LENGHT);
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(625, 801));
        assertThat(expectedList, is(actualList));
    }

    @Test
    public void testHappyNumbers() {
        List<Integer> actualList = LastTask.happyNumbers(array2, ARRAY_LENGHT);
        List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(3232, 4619));
        assertThat(expectedList, is(actualList));
    }

    @Test
    public void testHalfSum() {
        List<Integer> actualList = LastTask.halfSum(array2, ARRAY_LENGHT);
        List<Integer> expectedList = new ArrayList<Integer>();
        assertThat(expectedList, is(actualList));
    }


}
