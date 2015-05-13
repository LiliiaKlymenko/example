import java.util.Arrays;

public class Sorts {

    public static void main(String[] args) {


    }

    public static void invert(int[] arr) {
        for (int k = arr.length; k > 0 / 2; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }

    public static int[] merge(int[] fst, int snd[]) {
        int n = fst.length + snd.length;
        int[] result = new int[n];
        int fstIndex = 0;
        int sndIndex = 0;
        for (int i = 0; i < n; i++) {
            if (fstIndex == fst.length) {
                result[i] = snd[sndIndex++];
            } else if (sndIndex == snd.length) {
                result[i] = fst[fstIndex++];
            } else {
                if (fst[fstIndex] < snd[sndIndex]) {
                    result[i] = fst[fstIndex++];
                } else {
                    result[i] = snd[sndIndex++];
                }
            }
        }
        return result;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int temp = arr[barrier];
            int k = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[index] < temp) {
                    k = index;
                    temp = arr[index];
                }
            }
            arr[k] = arr[barrier];
            arr[barrier] = temp;
        }
        return arr;
    }

    public static void insertionSort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            if (arr[location] > arr[k]) {
                int tmp = arr[k];
                newElement = Arrays.binarySearch(arr, 0, location, arr[k]);
                if (newElement < 0) {
                    System.arraycopy(arr, newElement, arr, newElement + 1, k
                            - newElement);
                    arr[newElement] = tmp;
                } else {
                    System.arraycopy(arr, newElement, arr, newElement + 1, k
                            - newElement);
                    arr[newElement] = tmp;
                }
            }
        }
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        if (a == null || b == null)
            throw new IllegalArgumentException();
        for (int i = 0; i < a.length; i++) {

            if (a[i] == null || a[0].length != a[i].length)
                throw new IllegalArgumentException();

            for (int j = 0; j < b[0].length; j++) {

                if (b[i] == null || b[0].length != b[i].length)
                    throw new IllegalArgumentException();

                for (int k = 0; k < b.length; k++) {

                    c[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return c;

    }

}
