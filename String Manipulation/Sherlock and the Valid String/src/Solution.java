import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        int common[] = new int[27];
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int commonFreq = 0;
        int deletionsNeeded = 0;

        for (char c : s.toCharArray()) {
            common[c - 'a'] += 1;
        }

        for (Integer i: common) {
            if(i != 0){
                if (!freq.containsKey(i))
                    freq.put(i, 1);
                else
                    freq.put(i, freq.get(i) + 1);

                if(!freq.containsKey(commonFreq))
                    commonFreq = i;

                if (freq.get(i) > commonFreq)
                    commonFreq = i;
            }
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            Integer currentFreq = entry.getKey();
            Integer repeats = entry.getValue();

            if(currentFreq != commonFreq)
                deletionsNeeded += repeats * 1;
        }

        return (deletionsNeeded < 2) ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\" + "input03.txt"));
        String s = bufferedReader.readLine();
        String result = Result.isValid(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
