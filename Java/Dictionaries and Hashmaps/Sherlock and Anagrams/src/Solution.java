import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;


        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File mFile = new File(System.getProperty("user.dir") + "\\src\\" + "case_01.txt");
        Scanner scanner = new Scanner(mFile);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
