import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int b[] = new int[a.length];

        for (int i = 0, j = 0; i < a.length; i++, j++) {
            if (j + d >= a.length)
                j = 0 - d;

            b[i] = a[j + d];

        }

        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i : result) {
            System.out.print(i + " ");

        }

        scanner.close();
    }
}
