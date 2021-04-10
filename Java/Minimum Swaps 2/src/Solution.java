import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int out = 0;

            for (int j = i; j + 1 < arr.length; j++) {
                if(arr[j + 1] == j + 1) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swaps++;
                }
                }

            int a = arr[arr.length - 1];
            int b =  arr.length - 1;
            if(arr[arr.length - 1] != arr.length) {
                int t = arr[arr[arr.length - 1] - 1];
                arr[arr[arr.length - 1] - 1] = arr[arr.length - 1];
                arr[arr.length - 1] = t;
                swaps++;
            }
        }


        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }
}
