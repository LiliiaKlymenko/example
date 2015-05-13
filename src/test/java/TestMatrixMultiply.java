import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Liliia_Klymenko on 13-May-15.
 */
public class TestMatrixMultiply {

    int[][] array1 = {{1, 2, -2, 0}, {-3, 4, 7, 2}, {6, 0, 3, 1}};
    int[][] array2 = {{-1, 3}, {0, 9}, {1, -11}, {4, -5}};
    int[][] expectedResultArray = {{-3, 43}, {18, -60}, {1, -20}};


    @Test
    public void testMatrixMultiply() {
        int[][] actualResultArray = Sorts.multiplyMatrix(array1, array2);
        assertTrue(Arrays.deepEquals(expectedResultArray, actualResultArray));
    }
}
