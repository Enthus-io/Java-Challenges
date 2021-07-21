import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        int com = 0;

        if (a.score > b.score)
            com = -1;
        else if (a.score < b.score)
            com = 1;
        else if (a.score == b.score)
            com = a.name.compareTo(b.name);

        return com;
    }
}


public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\src\\" + "case_02.txt"));
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }

    }
}