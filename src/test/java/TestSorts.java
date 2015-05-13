import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Liliia_Klymenko on 13-May-15.
 */

@RunWith(Parameterized.class)
public class TestSorts {

    private final int[] actualArray;
    private final int[] expectedArray;

    public TestSorts(int[] actualArray, int[] expectedArray) {
        this.actualArray = actualArray;
        this.expectedArray = expectedArray;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 3, 2}, new int[]{1, 2, 3}},
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{1, 1, 1}, new int[]{1, 1, 1}},
                {new int[]{1}, new int[]{1}},
                {new int[]{}, new int[]{}},
        });
    }

    @Test
    public void testBubbleSort() {
        Sorts.bubbleSort(actualArray);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void testSelectionSort() {
        Sorts.selectionSort(actualArray);
        assertThat(actualArray, is(expectedArray));
    }

    @Test
    public void testInsertionSort() {
        Sorts.insertionSort(actualArray);
        assertThat(actualArray, is(expectedArray));
    }


}