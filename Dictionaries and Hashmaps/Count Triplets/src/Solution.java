import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    //     Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        // Time complexity is O(n)
        long count = 0;
        Map<Long, Long> ij = new HashMap<>();
        Map<Long, Long> jk = new HashMap<>();

        for (int index = arr.size() - 1; index >= 0; index--) {
            long current = arr.get(index);
            long next = current * r;

            if (jk.containsKey(next)) // Found j -> k
                count = count + jk.get(next);

            if (ij.containsKey(next)) // Found i -> j
                jk.put(current, (jk.containsKey(current) ? jk.get(current) : 0) + ij.get(next));

            ij.put(current, (ij.containsKey(current) ? ij.get(current) : 0) + 1L);
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
