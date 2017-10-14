package Exersice1;

import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer numberOfPLayers = Integer.parseInt(console.nextLine());

        String winnerName = "";
        int winnersScore = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfPLayers; i++) {

            char [] name = console.nextLine().toCharArray();
            int initialScore = Integer.parseInt(console.nextLine());

            for (int j = 0; j < name.length; j++) {
                if (name[j] % 2 == 0){
                    initialScore += name[j];
                }
                else {
                    initialScore -= name[j];
                }
            }

            if (initialScore > winnersScore){
                winnersScore = initialScore;
                winnerName = new String(name);
            }
        }

        System.out.println("The winner is " + winnerName+ " - " + winnersScore + " points");
    }
}
