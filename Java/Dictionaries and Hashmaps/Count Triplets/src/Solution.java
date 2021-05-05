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
        Map<Long, Integer> hashList = new HashMap<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            long ith = arr.get(i);
            long jth = ith * r;
            long kth = jth * r;


            if (hashList.get(ith) == null)

                hashList.put(ith, 1);
            else
                hashList.put(ith, hashList.get(ith) + 1);

            if(hashList.containsKey(ith / r)){
                hashList.remove(ith / r);
            }
            if(hashList.containsKey(ith / r / r)){
                hashList.remove(ith / r / r);
            }

            if(hashList.containsKey(ith * r) && hashList.containsKey(ith * r * r)){
                count += hashList.get(ith * r) * hashList.get(ith * r * r);
            }


        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\" + "case_14.txt"));

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
