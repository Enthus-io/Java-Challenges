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

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        // Time complexity is O(n)
        long count = 0;
        Map<Long, Integer> hashList = new HashMap<Long, Integer>();

        // Identify multiple entries
        for (long i : arr) {
            if(hashList.get(i) == null)
                hashList.put(i, 1);
            else
                hashList.put(i, hashList.get(i) + 1);
        }

        // Count geometric progressions for every ith element in arr
        for (long i : arr) {
            long j = i * r;
            long k = i * r * r;

            if(hashList.containsKey(j) && hashList.containsKey(k)) {
                count += Math.pow(2, hashList.get(j) - 1) * Math.pow(2, hashList.get(k) - 1);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\" + "case_02.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();
    }
}
