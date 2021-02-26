import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int[] pairs = new int[n];
        int listSize = 0;
        int count = 0;

        for (int ithElement : ar) {
            int index = 0;

            while (index < n) {
                if (pairs[index] == ithElement) {
                    break;
                }
                
                index++;
            }

            if (index == n) {
                pairs[listSize] = ithElement;
                listSize++;
            } else {
                count++;
                pairs[index] = 0;
            }

        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        int result = sockMerchant(n, ar);

        System.out.println("Results = " + result);

        scanner.close();
    }
}
