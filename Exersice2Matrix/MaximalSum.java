package Exersice2Matrix;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] numbers = console.nextLine().split("\\s+");

        int rows = Integer.parseInt(numbers[0]);
        int coloums = Integer.parseInt(numbers[1]);

        Integer [][] matrix = new Integer[rows][coloums];

        int biggestSum = Integer.MIN_VALUE;

        Integer [][] biggest3x3Matrix = new Integer[3][3];
        for (int i = 0; i < rows; i++) {
            String [] inputNumbers = console.nextLine().split(" ");
            for (int j = 0; j < coloums; j++) {
            matrix[i][j] = Integer.parseInt(inputNumbers[j]);
            }
        }

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < coloums - 2; j++) {
                int currentSumOfElem = matrix [i][j] + matrix [i][j + 1] + matrix [i][j + 2]
                        +   matrix [i + 1][j] + matrix [i + 1][j + 1] + matrix [i + 1][j + 2]
                        +   matrix [i + 2][j] + matrix [i + 2][j + 1] + matrix [i + 2][j + 2];

                if (currentSumOfElem > biggestSum){
                    biggest3x3Matrix [0][0] = matrix [i][j];
                    biggest3x3Matrix [0][1] = matrix [i][j + 1];
                    biggest3x3Matrix [0][2] = matrix [i][j + 2];
                    biggest3x3Matrix [1][0] = matrix [i + 1][j];
                    biggest3x3Matrix [1][1] = matrix [i + 1][j + 1];
                    biggest3x3Matrix [1][2] = matrix [i + 1][j + 2];
                    biggest3x3Matrix [2][0] = matrix [i + 2][j];
                    biggest3x3Matrix [2][1] = matrix [i + 2][j + 1];
                    biggest3x3Matrix [2][2] = matrix [i + 2][j + 2];
                    biggestSum = currentSumOfElem;
                }
            }
        }

        System.out.println("Sum = " + biggestSum);
        for (Integer[] x3Matrix : biggest3x3Matrix) {
            for (Integer integer : x3Matrix) {
                System.out.printf("%d ",integer);
            }
            System.out.println();
        }
    }
}
