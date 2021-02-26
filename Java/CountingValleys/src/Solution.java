import java.io.*;
import java.util.*;

class Result {


    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleys = 0;
        int elevation = 0;

        for(char c: path.toCharArray()){

            if(c == 'D'){
                elevation--;
            }
            else if (c == 'U'){
                elevation++;

                if(elevation == 0)
                    valleys++;
            }
        }

        return valleys;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int steps = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String path = scanner.nextLine();
        int result = Result.countingValleys(steps, path);

        System.out.println(result);

        scanner.close();
    }
}
