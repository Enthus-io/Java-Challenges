import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] sums = new int[4][4];
        int max = -2147483648;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {


                sums[i][j] += arr[i][j];
                sums[i][j] += arr[i][j + 1];
                sums[i][j] += arr[i][j + 2];

                sums[i][j] += arr[i + 1][j + 1];

                sums[i][j] += arr[i + 2][j];
                sums[i][j] += arr[i + 2][j + 1];
                sums[i][j] += arr[i + 2][j + 2];

                if(sums[i][j] > max)
                    max = sums[i][j];
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        scanner.close();
    }
}
