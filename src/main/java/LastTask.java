import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LastTask {

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a number :");
	int n = Integer.parseInt(scanner.nextLine());
	System.out.println("Enter " + n + " numbers:");
	int[] array = new int[n];
	for (int i = 0; i < n; i++) {
	    array[i] = Integer.parseInt(scanner.nextLine());
	}
	
	System.out.println("Odd numbers: " + odd(array, n).toString());
	System.out.println("Even numbers: " + even(array, n).toString());
	System.out.println("Maximum: " + max(array));
	System.out.println("Minimum: " + min(array));
	System.out.println("Can be divided on 3 or 9: "
		+ divByThree(array, n).toString());
	System.out.println("Can be divided on 5 and 7: "
		+ divByFiveAndSeven(array, n).toString());
	System.out.println("Three-digit numbers without repetitions: "
		+ threeDigitNumbers(array, n).toString());
	System.out.println("Happy numbers: "
		+ happyNumbers(array, n).toString());
	System.out.println("Equal to halfsum of the adjacent elements: "
		+ halfSum(array, n).toString());
    }

    public static List<Integer> odd(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    if (!(array[i] % 2 == 0))
		arr.add(array[i]);
	}
	return arr;
    }

    public static List<Integer> even(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    if (array[i] % 2 == 0)
		arr.add(array[i]);
	}
	return arr;
    }

    public static int min(int array[]) {
	int minValue = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i] < minValue) {
		minValue = array[i];
	    }
	}
	return minValue;
    }

    public static int max(int array[]) {
	int maxValue = array[0];
	for (int i = 1; i < array.length; i++) {
	    if (array[i] > maxValue) {
		maxValue = array[i];
	    }
	}
	return maxValue;
    }

    public static List<Integer> divByThree(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    if (array[i] % 3 == 0)
		arr.add(array[i]);
	}
	return arr;
    }

    public static List<Integer> divByFiveAndSeven(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    if (array[i] % 5 == 0 && array[i] % 7 == 0)
		arr.add(array[i]);
	}
	return arr;
    }

    public static List<Integer> threeDigitNumbers(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    String str = Integer.toString(array[i]);
	    if (str.length() == 3 && (str.charAt(0) != str.charAt(1))
		    && (str.charAt(1) != str.charAt(2)))

		arr.add(array[i]);
	}
	return arr;
    }

    public static List<Integer> happyNumbers(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();

	for (int i = 0; i < n; i++) {
	    String str = Integer.toString(array[i]);
	    if (str.length() % 2 == 0) {
		int sumRight =0;
		int sumLeft =0;
		for (int j = 0; j < str.length() / 2; j++) {
		    sumRight += str.charAt(j);
		}
		for (int k = str.length() / 2; k < str.length(); k++) {
		    sumLeft += str.charAt(k);
		}
		if (sumRight == sumLeft) {
		    arr.add(array[i]);
		}
	    }

	}
	return arr;
    }

    public static List<Integer> halfSum(int[] array, int n) {
	List<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < n - 2; i++) {
	    if ((array[i] + array[i + 2]) / 2 == array[i + 1])
		arr.add(array[i + 1]);
	}
	return arr;
    }

}

