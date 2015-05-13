
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[]{1, 554, 23, 555689, 1557, 22, 3, 6874, 10003,
                20, 1234};

	/*
     * for (int i = 0; i < array.length; i++) { array[i] = (int)
	 * (Math.random() * 5000 - 50); }
	 */
        System.out.print("Array: ");
        System.out.println(Arrays.toString(array) + "\n");
        System.out.println("1.");
        System.out.println(maxLength(array));
        System.out.println(minLength(array));

        int[] temp = array;
        System.arraycopy(array, 0, temp, 0, array.length);
        System.out.println("\n\n2.");
        lengthSort1(temp);
        // System.out.println(Arrays.toString(temp));

        System.out.println("\n\n3.");
        lessThanAverage(array);
        moreThanAverage(array);

        System.out.println("\n\n4. (For Three-digit and more numbers )");
        System.out.println(minimumDifferentNumbers(array));

        System.out.println("\n\n5. ");
        onlyEven(array);

        System.out.println("\n\n6.");
        System.out.println("Number " + ascendingNums(array)
                + " including ascending");

        System.out.println("\n\n7.");
        System.out.println("Number " + onlyDifferentNumbers(array)
                + " consist of only different numbers");

        System.out.println("\n\n8.");
        System.out.println("Enter the end number: ");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(Arrays.deepToString(endNumber(num)));

        System.out.println("\n\n9.");
        System.out.println("Enter the dimension of the matrix: ");
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int[][] temp1 = matrix(n, m);
        int[][] temp2 = temp1;
        System.out.println(Arrays.deepToString(temp2));

        System.out.println("\n\n9.1");
        System.out.println("Sorted matrix: ");
        System.out.println(Arrays.deepToString(sortMatrix(temp2)));

        int[][] temp3 = matrix(n, m);
        System.out.println("\n\n9.2");
        System.out.println("Enter the number of shift: ");
        System.out.println("Enter the direction (right, left, top, bottom): ");
        int shift = Integer.parseInt(scanner.nextLine());
        String direction = scanner.nextLine();
        System.out.println("Source matrix: ");
        System.out.println(Arrays.deepToString(temp3));
        System.out.println("Resulting matrix: ");
        System.out.println(Arrays.deepToString(shift(temp3, shift, direction)));


        System.out.println("\n\n9.3");
        System.out.println(Arrays.deepToString(temp2));
        System.out.println("Max sequence: ");
        System.out.println(sequence(temp2));


        System.out.println("\n\n9.4");
        sum(temp2);


        System.out.println("\n\n9.5");
        System.out.println("Enter the angle (90, 180, 270): ");
        int angle = Integer.parseInt(scanner.nextLine());
        System.out.println(Arrays.deepToString(rotate(matrix(5, 5), angle)));


        System.out.println("\n\n9.6");
        System.out.println("Minus avarage: ");
        System.out.println(Arrays.deepToString(minusAvarage(temp2)));


        System.out.println("\n\n9.7");
        System.out.println("Matrix: ");
        System.out.println(Arrays.deepToString(temp2));
        System.out.println("Sealed matrix: ");
        System.out.println(Arrays.deepToString(sealed(temp2)));


        System.out.println("\n\n9.8");
        System.out
                .println(Arrays.deepToString(sort_NullToTheEnd(matrix(5, 5))));

    }

    /*
     * ----- 1. Найти самое короткое и самое длинное число. Вывести найденные
     * числа и их длину.
     */
    public static String maxLength(int[] array) {
        int number = array[0];
        int maxLength = Integer.toString(array[0]).length();
        for (int i : array) {
            String str = Integer.toString(i);
            if (str.length() > maxLength) {
                maxLength = Integer.toString(i).length();
                number = i;
            }
        }
        return "Max length: " + maxLength + ", example: " + number;
    }

    public static String minLength(int[] array) {
        int number = array[0];
        int minLength = Integer.toString(array[0]).length();
        for (int i : array) {
            String str = Integer.toString(i);
            if (str.length() < minLength) {
                minLength = Integer.toString(i).length();
                number = i;
            }
        }
        return "Min length: " + minLength + ", example: " + number;
    }

    /*
     * ----- 2. Упорядочить и вывести числа в порядке возрастания (убывания)
     * значений их длины.
     */
    public static void lengthSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Integer.toString(array[j]).length() < Integer.toString(
                        array[j + 1]).length()) {
                    int temp = array[i];
                    array[i] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    public static void lengthSort1(int[] array) {

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i : array) {
            map.put(Integer.toString(i).length(), i);
        }
        System.out.println("Array sorted by number length:");
        System.out.print("Ascending: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

        Map<Integer, Integer> newMap = new TreeMap(Collections.reverseOrder());
        newMap.putAll(map);
        System.out.print("\nDescending: ");
        for (Map.Entry<Integer, Integer> entry : newMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }

    /*
     * ----- 3. Вывести на консоль те числа, длина которых меньше (больше)
     * средней, а также длину.
     */
    public static double averageLength(int[] array) {
        double sumLength = 0.;
        for (int i : array) {
            sumLength += Integer.toString(i).length();
        }
        return (double) sumLength / array.length;

    }

    public static void moreThanAverage(int[] array) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        double averageLength = averageLength(array);
        for (int i : array) {
            if (Integer.toString(i).length() > averageLength) {
                map.put(Integer.toString(i).length(), i);
            }
        }

        System.out.println("Length greater than the average: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Number " + entry.getValue() + " with length "
                    + entry.getKey());
        }
    }

    public static void lessThanAverage(int[] array) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        double averageLength = averageLength(array);
        for (int i : array) {
            if (Integer.toString(i).length() < averageLength) {
                map.put(Integer.toString(i).length(), i);
            }
        }

        System.out.println("Length smaller than the average: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Number " + entry.getValue() + " with length "
                    + entry.getKey());
        }

    }

    public static int repit(String str) {
        int k = 1;
        char[] char1 = str.toCharArray();
        Arrays.sort(char1);
        for (int j = 0; j < str.length() - 1; j++) {
            if (char1[j] == char1[j + 1])
                k += 1;
        }
        return k;

    }

    /*
     * ----- 4. Найти число, в котором число различных цифр минимально. Если
     * таких чисел несколько, найти первое из них.
     */
    public static int minimumDifferentNumbers(int[] array) {
        Map<Integer, Integer> k = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length - 1; i++) {
            int rep = repit(Integer.toString(array[i]));
            int rep2 = repit(Integer.toString(array[i + 1]));
            if (rep > rep2) {
                k.put(repit(Integer.toString(array[i])), array[i]);
            } else {
                k.put(repit(Integer.toString(array[i + 1])), array[i + 1]);
            }

        }


        return Collections.max(k.keySet());
    }

    /*
     * ----- 5. Найти количество чисел, содержащих только четные цифры, а среди
     * них количество чисел с равным числом четных и нечетных цифр.
     */
    public static int onlyEven(int[] array) {
        int count = 0;
        int countOdd = 0;
        int countEven = 0;
        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> arrEven = new ArrayList<Integer>();
        for (int i : array) {
            if (isEven(Integer.toString(i))) {
                count++;
                arr.add(i);
            }
        }
        for (int j : arr) {
            if (Integer.toString(j).length() % 2 == 0) {
                countEven++;
            } else
                countOdd++;
        }

        /*System.out.println("Count of numbers with only even nums: " + count);
        System.out.println("Among them: " + countEven
                + " with even count of length and " + countOdd
                + " with odd count of length and ");*/
        return count;
    }

    /*
     * ----- 6. Найти число, цифры в котором идут в строгом порядке возрастания.
     * Если таких чисел несколько, найти первое из них.
     */
    public static String ascendingNums(int[] array) {
        for (int i = 0; i < array.length; i++) {
            String str = Integer.toString(array[i]);
            if (str.length() > 1) {
                if (isAscending(str)) {
                    return str;
                }
            }

        }
        return null;
    }

    public static boolean isAscending(String str) {
        char[] charArray = str.toCharArray();
        char[] charArray1 = str.toCharArray();
        Arrays.sort(charArray);
        if (Arrays.toString(charArray1).equals(Arrays.toString(charArray))) {
            return true;
        } else
            return false;

    }

    public static boolean isEven(String str) {
        char[] charArray = str.toCharArray();
        int countOfEvenChar = 0;
        for (int i : charArray) {
            if (i % 2 == 0) {
                countOfEvenChar++;
            }
        }
        if (countOfEvenChar == str.length())
            return true;
        else
            return false;
    }

    /*
     * ----- 7. Найти число, состоящее только из различных цифр. Если таких
     * чисел несколько, найти первое из них.
     */
    public static int onlyDifferentNumbers(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int rep = repit(Integer.toString(array[i]));
            int length = Integer.toString(array[i]).length();
            if (length > 1 && rep == 1) {
                return array[i];
            }
        }
        return 0;
    }

    /*
     * ----- 8. Вывести числа от 1 до k в виде матрицы N x N слева направо и
     * сверху вниз.
     */
    public static int[][] endNumber(int end) {
        double e = Math.sqrt(end);
        int[][] array = new int[(int) e][(int) e];
        if (e % 1 == 0) {
            int k = 1;
            for (int i = 0; i < e; i++) {
                for (int j = 0; j < e; j++) {
                    array[i][j] = k;
                    k += 1;
                }
            }
            return array;
        } else
            System.out.println("Impossible to build a matrix NxN");
        return null;
    }

    /*
     * -----9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения
     * элемен- тов матрицы в интервале значений от -n до n с помощью датчика
     * случайных чи- сел.
     */
    public static int[][] matrix(int n, int m) {
        Random random = new Random();
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = (random.nextInt(n * 2) - n);
            }

        }
        return array;
    }

    /*
     * ----- 9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания
     * значений.
     */
    public static int[][] sortMatrix(int[][] array) {
        int[] list = new int[array.length * array.length];
        for (int i = 0, k = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list[k++] = array[i][j];
            }
        }
        Arrays.sort(list);
        // System.out.println("sorted list: " + Arrays.toString(list));
        int k = 0;
        for (int i = 0, a = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = list[a++];
            }
        }

        return array;
    }

    /*
     * ----- 9.2. Выполнить циклический сдвиг заданной матрицы на k позиций
     * вправо (влево, вверх, вниз).
     */
    public static int[][] shift(int[][] array, int shift, String direction) {

        switch (direction) {
            case "left":
                int amount = 0;
                while (amount != shift) {
                    for (int i = 0; i < array.length; i++) {
                        int firstElement = array[i][0];
                        for (int j = 1; j < array[i].length; j++) {
                            array[i][j - 1] = array[i][j];
                        }
                        array[i][array[i].length - 1] = firstElement;
                    }
                    amount++;
                }
                break;

            case "right":
                amount = 0;
                while (amount != shift) {
                    for (int i = 0; i < array.length; i++) {
                        int lastElement = array[i][array[i].length - 1];
                        for (int j = array[i].length - 1; j > 0; j--) {
                            array[i][j] = array[i][j - 1];
                        }
                        array[i][0] = lastElement;
                    }

                    amount++;
                }

                break;

            case "top":
                amount = 0;
                while (amount != shift) {
                    for (int i = 0; i < array.length; i++) {
                        int firstElement = array[0][i];
                        for (int j = 1; j < array[i].length; j++) {
                            array[j - 1][i] = array[j][i];
                        }
                        array[array[i].length - 1][i] = firstElement;
                    }
                    amount++;
                }

                break;

            case "bottom":
                amount = 0;
                while (amount != shift) {
                    for (int i = 0; i < array.length; i++) {
                        int firstElement = array[0][i];
                        for (int j = 1; j < array[i].length; j++) {
                            array[j - 1][i] = array[j][i];
                        }
                        array[array[i].length - 1][i] = firstElement;
                    }
                    amount++;
                }

                break;
        }
        return array;

    }

    /*
     * ----- 9.3. Найти и вывести наибольшее число возрастающих (убывающих)
     * элементов матрицы, идущих подряд.
     */
    public static int sequence(int[][] array) {

        List<Integer> list = new ArrayList<Integer>();
        List<Integer> countList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!(array[i][j] == 0)) {
                    list.add(array[i][j]);
                }
            }
        }

        int first, second;
        for (int i = 0; i < list.size() - 1; i++) {
            int count = 0;
            first = list.get(i);
            second = list.get(i + 1);
            while (first == second + 1) {
                first = second;
                second = list.get(i + 1);
                count++;
                i++;
            }
            countList.add(count);

        }

        int firstM, secondM;

        for (int i = 1; i < list.size(); i++) {
            int count = 0;
            first = list.get(i);
            second = list.get(i - 1);
            while (first == second - 1) {
                first = second;
                second = list.get(i - 1);
                count++;
                i++;
            }
            countList.add(count);

        }

        return Collections.max(countList);
    }

    public static boolean ifSequence(int first, int second, int count) {

        if (first == second + 1) {
            count++;
        }
        return true;
    }

    /*
     * ----- 9.4. Найти сумму элементов матрицы, расположенных между первым и
     * вторым положительными элементами каждой строки.
     */
    public static List<Integer> sum(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] > 0 && array[i][j + 1] < 0) {
                    while (array[i][j + 1] < 0) {
                        sum += array[i][j + 1];
                        j++;
                    }
                    System.out.println("Sum:" + (i + 1) + " - " + sum + " ");
                    list.add(sum);
                    break;
                }
            }

        }
        return list;
    }

    /*
     * ----- 9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой
     * стрелки.
     */
    public static int[][] rotate(int[][] array, int angle) {
        int[][] temp = null;
        switch (angle) {
            case 90:
                temp = new int[array.length][array[0].length];
                for (int i = 0, i2 = 0; i < array.length; i++, i2++) {
                    for (int j = array[i].length - 1, j2 = 0; j >= 0; j--, j2++) {
                        temp[j2][i2] = array[i][j];
                    }
                }
                break;
            case 180:
                temp = new int[array.length][array[0].length];
                for (int i = array.length - 1, i2 = 0; i >= 0; i--, i2++) {
                    for (int j = array[i].length - 1, j2 = 0; j >= 0; j--, j2++) {
                        temp[i2][j2] = array[i][j];
                    }
                }
                break;
            case 270:
                temp = new int[array.length][array[0].length];
                for (int i = array.length - 1, i2 = 0; i >= 0; i--, i2++) {
                    for (int j = array[i].length - 1, j2 = 0; j >= 0; j--, j2++) {
                        temp[j2][i2] = array[j][i];
                    }
                }
                break;
        }

        return temp;
    }

    /*
     * ----- 9.6 Построить матрицу, вычитая из элементов каждой строки матрицы
     * ее среднее арифметическое.
     */
    public static int[][] minusAvarage(int[][] array) {
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            avg = 0;
            for (int j = 0; j < array[i].length; j++) {
                avg += array[i][j];
            }
            avg /= array.length;
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] -= Math.floor(avg);
            }
        }
        return array;
    }

    /*
     * ----- 9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные
     * нулями.
     */

    public static int[][] sealed(int[][] array) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!(array[i][j] == 0)) {
                    list.add(array[i][j]);
                }
            }
        }

        int k = 0;
        int e = (int) Math.sqrt(list.size());
        int[][] sealedArray = new int[e][e];
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < e; j++) {
                sealedArray[i][j] = list.get(k);
                k++;
            }
        }

        return sealedArray;
    }

    /*
     * ----- 9.8. Преобразовать строки матрицы таким образом, чтобы элементы,
     * равные нулю, располагались после всех остальных.
     */

    public static int[] nullToTheEnd(int[] array) {

        // int[] nums = { 0, 1, 2, 3, 0, 4, 12, 0, 5, 8 };
        for (int i = 0; i < array.length; i++)
            if (array[i] == 0) {
                int tmp = array[i];
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                array[array.length - 1] = tmp;
            }
        return array;

    }

    public static int[][] sort_NullToTheEnd(int[][] array) {

        for (int[] i : array) {
            nullToTheEnd(i);
        }
        return array;
    }

}
