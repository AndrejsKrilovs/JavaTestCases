import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        int sizeCmp = o2.getScore() - o1.getScore();
        return sizeCmp != 0 ? sizeCmp : o1.getName().compareTo(o2.getName());
    }
}

class Player{
    private final String name;
    private final int score;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class JavaComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.getName(), value.getScore());
        }
    }
}