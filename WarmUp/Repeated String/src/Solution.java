import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long x = (long) (n / s.length());
        long remainder = (long) (n % s.length());
        long numberOfAs = 0;
        long tailAs = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a') {
                numberOfAs++;

                if (i < remainder) {
                    tailAs++;
                }
            }
        }


        return x * numberOfAs + tailAs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}
