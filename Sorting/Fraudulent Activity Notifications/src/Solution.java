import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        double median = 0.0;
        List<Integer> sortedList = new Vector<Integer>();
        int sorted[] = new int[300];
        Integer previous = expenditure.get(0);
        Integer next = 0;
        Integer counter = 0;

        for (int i = 0; i < d; i++) {
            sorted[expenditure.get(i)] += 1;
        }

        for (int i = d; i < expenditure.size(); i++) {
            previous = expenditure.get(i - d);
            next = expenditure.get(i);

            median = getMedian(sorted, d);

            if (next >= median * 2.0)
                counter++;

            sorted[next] += 1;
            sorted[previous] -= 1;
        }

        return counter;
    }

    private static double getMedian(int sorted[], int d) {
        double median = 0;
        int count = 0;

        if ((d & 1) == 0) {
            for (int j = 0; j < sorted.length; j++) {
                count += sorted[j];
                if (median == 0 && count >= d / 2) {
                    median = j;
                }
                if (count >= d / 2 + 1) {
                    median = (median + j) / 2.0;
                    break;
                }
            }
        }

        else {
            for (int j = 0; j < sorted.length; j++) {
                count += sorted[j];
                if (count > d / 2) {
                    median = j;
                    break;
                }
            }
        }

        return median;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\" + "input01.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        System.out.println(result);

        bufferedReader.close();
    }
}
