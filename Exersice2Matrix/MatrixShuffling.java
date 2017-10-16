package Exersice2Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int columns = input[1];

        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            String[] elements = console.nextLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = elements[j];
            }
        }

        while (true) {
            String[] operations = console.nextLine().split("\\s+");
            boolean containsOrNot = Arrays.asList(operations).contains("swap");

            if (operations[0].equals("END")) {
                break;
            }
            if (!containsOrNot || operations.length < 5 || operations.length > 5) {
                System.out.println("Invalid input!");
            }
            else {
                int firstElemRow = Integer.parseInt(operations[1]);
                int firstElemCol = Integer.parseInt(operations[2]);
                int secondElemRow = Integer.parseInt(operations[3]);
                int secondElemCol = Integer.parseInt(operations[4]);

                if (firstElemRow > rows - 1 || firstElemRow < 0
                        || firstElemCol > columns - 1 || firstElemCol < 0
                        || secondElemRow > rows - 1 || secondElemRow < 0
                        || secondElemCol > columns - 1 || secondElemCol < 0) {

                    System.out.println("Invalid input!");
                } else {
                    String elementForSwap = matrix[firstElemRow][firstElemCol];
                    matrix[firstElemRow][firstElemCol] = matrix[secondElemRow][secondElemCol];
                    matrix[secondElemRow][secondElemCol] = elementForSwap;

                    for (String[] strings : matrix) {
                        for (String string : strings) {
                            System.out.printf("%s ",string);
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
