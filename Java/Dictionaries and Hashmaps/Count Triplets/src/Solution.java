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
            long i = arr.get(index);
            long j = i * r;
            long k = j * r;


            if(ij.get(i) == null){
                ij.put(i, 1L);

            }
            else{
                ij.put(i, ij.get(i) + 1);
            }

            if(ij.get(j) != null){
                System.out.println("found i->j");

                if(jk.get(j) == null){
                    jk.put(j, 1L);

                }
                else{
                    jk.put(j, jk.get(j) + 1);
                }



                if(jk.get(k) != null){
                    System.out.println("found i->j->k");
                    count = count + jk.get(k) * ij.get(k);
                }

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
