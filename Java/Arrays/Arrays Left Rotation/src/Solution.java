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
        int[] t = a.clone();

        for (int i = 0; i < a.length; i++) {
            int ix = i - d;

            if(i - d < 0) {
                a[a.length + i - d] = t[i];
            }else{
                a[a.length - i - 1] = t[a.length - 1];
            }

        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

//        String[] nd = scanner.nextLine().split(" ");

//        int n = Integer.parseInt(nd[0]);

//        int d = Integer.parseInt(nd[1]);
        int d = 10;

//        int[] a = new int[n];
        int[] a = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};

//        String[] aItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int aItem = Integer.parseInt(aItems[i]);
//            a[i] = aItem;
//        }

        int[] result = rotLeft(a, d);

        scanner.close();
    }
}
