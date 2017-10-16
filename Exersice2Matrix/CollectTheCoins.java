package Exersice2Matrix;

import java.util.Scanner;

public class CollectTheCoins {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Character [][] matrix = new Character[4][];

        int coinsCollected = 0;
        int wallsHitted = 0;

        for (int i = 0; i < matrix.length; i++) {
            String input = console.nextLine();
            matrix[i] = new Character[input.length()];
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
            }
        }

        String commands = console.nextLine();
        int row = 0;
        int column = 0;

        for (int i = 0; i < commands.length(); i++) {
            char currentCommand = commands.charAt(i);
            Character currentPosition = matrix[row][column];

            if (currentCommand == 'V'){
                row++;
                if (row > matrix.length - 1 || column > matrix[row].length){
                    row--;
                    wallsHitted++;
                }
                else{
                    if (currentPosition == '$'){
                        coinsCollected++;
                    }
                }
            }
            else if (currentCommand == '>'){
                column++;
                if (column > matrix[row].length - 1){
                    column--;
                    wallsHitted++;
                }
                else{
                    if (currentPosition == '$'){
                        coinsCollected++;
                    }
                }
            }
            else if (currentCommand == '<'){
                column--;
                if (column < 0){
                    column++;
                    wallsHitted++;
                }
                else{
                    if (currentPosition == '$'){
                        coinsCollected++;
                    }
                }
            }
            else if (currentCommand == '^'){
                row--;
                if (row < 0 || column > matrix[row].length){
                    row++;
                    wallsHitted++;
                }
                else{
                    if (currentPosition == '$'){
                        coinsCollected++;
                    }
                }
            }
        }

        System.out.println("Coins = "+coinsCollected);
        System.out.println("Walls = "+wallsHitted);
    }
}
