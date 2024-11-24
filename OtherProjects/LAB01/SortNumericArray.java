import java.util.Arrays;
import java.util.Scanner;

public class SortNumericArray {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] myArray = new int[n];
        for (int i = 0; i < n; i++) {
            myArray[i] = scanner.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(myArray));
        Arrays.sort(myArray);
        System.out.println("Sorted array: " + Arrays.toString(myArray));
        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / myArray.length;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        scanner.close();
    }
}
