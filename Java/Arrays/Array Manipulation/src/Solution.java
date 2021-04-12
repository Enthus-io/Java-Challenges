import java.io.*;
import java.math.*;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long sum = 0;
        int lBound = 0, rBound = 1, value = 2;
        long[] array = new long[n + 1];

        for (int[] q: queries) {
            array[q[lBound] - 1] += q[value];
            array[q[rBound]] -= q[value];
        }

        for (int i = 0; i < n; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }

        return max;
    }


    public static void main(String[] args) throws IOException {

        File mFile = new File(System.getProperty("user.dir") + "\\src\\" + "case_01.txt");
        Scanner scanner = new Scanner(mFile);

        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        scanner.close();
    }
}
