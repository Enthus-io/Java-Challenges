import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String found = "NO";
        Map<Character, Character> list = new HashMap<Character, Character>(s1.length());

        for (Character c : s1.toCharArray()) {
            list.put(c, c);
        }

        for (Character c : s2.toCharArray()) {
            if (list.containsKey(c)) {
                found = "YES";
                break;
            }
        }

        return found;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File mFile = new File(System.getProperty("user.dir") + "\\src\\" + "case_00.txt");
        Scanner scanner = new Scanner(mFile);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }

        scanner.close();
    }
}
