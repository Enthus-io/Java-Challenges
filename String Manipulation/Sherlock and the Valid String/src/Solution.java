import java.io.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here

        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\" + "case_00.txt"));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
