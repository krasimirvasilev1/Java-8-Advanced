package Exersice2Matrix;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer number = Integer.parseInt(console.nextLine());

        Integer [][] matrix = new Integer[number][number];

        FillingMatrix(console, number, matrix);

        int primarySum = PrimaryDiagonalSum(number, matrix);
        int secondSum = SecondaryDiagonalSum(number, matrix);

        int result = Math.abs(primarySum - secondSum);

        System.out.println(result);
    }

    private static int SecondaryDiagonalSum(Integer number, Integer[][] matrix) {
        int secondaryDiagonalSum = 0;
        int rowCounter = number - 1;
        for (int i = 0; i < number; i++) {

            secondaryDiagonalSum += matrix[rowCounter][i];
            rowCounter--;
        }
        return secondaryDiagonalSum;
    }

    private static int PrimaryDiagonalSum(Integer number, Integer[][] matrix) {
        int primaryDiagonalSum = 0;
        for (int i = 0; i < number; i++) {
            primaryDiagonalSum += matrix[i][i];

        }
        return primaryDiagonalSum;
    }

    private static void FillingMatrix(Scanner console, Integer number, Integer[][] matrix) {
        for (int i = 0; i < number; i++) {
            String [] numbers = console.nextLine().split("\\s+");
            int counter = 0;
            for (int j = 0; j < number; j++) {
                matrix [i][j] = Integer.parseInt(numbers[counter]);
                counter++;
            }
        }
    }
}
