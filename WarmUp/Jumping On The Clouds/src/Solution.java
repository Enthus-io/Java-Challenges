import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;

        for (int i = 0; i < c.length; i++) {
            if(i + 2 < c.length && c[i + 2] != 1){
                i++;
                jumps++;
            }else if(i + 1 < c.length){
                jumps++;
            }

        }

        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        int result = jumpingOnClouds(c);

        System.out.println("Results = " + result);

        scanner.close();
    }
}
