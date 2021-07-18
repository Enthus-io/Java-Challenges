import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineTable = new HashMap<String, Integer>(magazine.length * 2);
        boolean allFound = true;

        for (String m: magazine) {
            if(magazineTable.get(m) == null)
                magazineTable.put(m, 1);
            else
                magazineTable.put(m, magazineTable.get(m) + 1);
        }

        for (String n: note) {
            if(magazineTable.containsKey(n)) {
                magazineTable.put(n, magazineTable.get(n) - 1);

                if(magazineTable.get(n) == 0)
                    magazineTable.remove(n);
            }
            else {
                allFound = false;
                break;
            }
        }

        if(allFound)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        File mFile = new File(System.getProperty("user.dir") + "\\src\\" + "case_02.txt");
        Scanner scanner = new Scanner(mFile);
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
