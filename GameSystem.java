import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class GameSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

       
        if (n <= 0) {
            System.out.println("Invalid number of players!");
            return;
        }

        sc.nextLine(); 

        Player[] players = new Player[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Player " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter score: ");
            int score = sc.nextInt();
            sc.nextLine(); 

            players[i] = new Player(name, score);
        }

        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (players[j].score < players[j + 1].score) {
                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }

        
        System.out.println("\n--- Game Scoreboard ---");
        System.out.println("Rank\tName\tScore");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + players[i].name + "\t" + players[i].score);
        }

        
        System.out.println("\nTop Player: " + players[0].name);

        sc.close();
    }
}