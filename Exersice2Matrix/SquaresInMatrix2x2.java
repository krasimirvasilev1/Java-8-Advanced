package Exersice2Matrix;

import java.util.Scanner;

public class SquaresInMatrix2x2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] rowsAndColoums = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndColoums[0]);
        int coloums = Integer.parseInt(rowsAndColoums[1]);

        String [][] matrix = new String[rows][coloums];
        String curr = "";
        int counter = 0;

        int numberOfEqualSquares = 0;

        for (int i = 0; i < rows; i++) {
            String [] chars = console.nextLine().split("\\s+");
            counter = 0;
            for (int j = 0; j < coloums; j++) {
                matrix[i][j] = chars[counter];
                counter++;
            }
        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < coloums - 1; j++) {
                curr = matrix [i][j];
                if (curr.equals(matrix [i + 1][j]) && curr.equals(matrix [i][j+1]) && curr.equals(matrix [i + 1][j+1])){
                    numberOfEqualSquares++;
                }
            }
            
        }

        System.out.println(numberOfEqualSquares);
    }
}
