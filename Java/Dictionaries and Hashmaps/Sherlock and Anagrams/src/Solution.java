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

        for (int i = 1; i < s.length(); i++) {
            Map<String, Integer> list = new HashMap<>();
            String t = s;

            for (int j = 0; j + i <= s.length(); j++) {
                //Sorting the string to reduce time complexity
                char tempArray[] = t.substring(j, j + i).toCharArray();
                Arrays.sort(tempArray);
                String c = new String(tempArray);

                //Keeping track of the number_of_identical_anagrams
                if (list.get(c) == null)
                    list.put(c, 1);
                else
                    list.put(c, list.get(c) + 1);

                //Adding factorial(number_of_identical_anagrams - 1)
                count += list.get(c) - 1;
            }
        }

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
