package Lecture2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] properties = console.nextLine().split(", ");
        int rows = Integer.parseInt(properties[0]);
        int coloums = Integer.parseInt(properties[1]);

        int [][] matrix = new int[rows][coloums];

        int [][] biggestMatrixSum = new int[2][2];

        for (int row = 0; row < rows; row++) {
            String [] elementsOnRow = console.nextLine().split(", ");
            for (int colomn = 0; colomn < coloums; colomn++) {
                matrix[row][colomn] = Integer.parseInt(elementsOnRow[colomn]);
            }
        }


        int sumOfTheBiggestElem = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int coloum = 0; coloum < coloums - 1 ; coloum++) {
                int currentSum = 0;
                if (rows <= 1){
                    currentSum += matrix[row][coloum];
                    currentSum += matrix [row][coloum + 1];
                }
                else {
                    currentSum += matrix[row][coloum];
                    currentSum += matrix [row + 1][coloum];
                    currentSum += matrix [row][coloum + 1];
                    currentSum += matrix [row + 1][coloum + 1];
                }

                if (currentSum > sumOfTheBiggestElem && rows > 1){
                    sumOfTheBiggestElem = currentSum;
                    biggestMatrixSum [0][0] = matrix [row][coloum];
                    biggestMatrixSum [0][1] = matrix [row][coloum + 1];
                    biggestMatrixSum [1][0] = matrix [row + 1][coloum];
                    biggestMatrixSum [1][1] = matrix [row + 1][coloum + 1];
                }
                else if (currentSum > sumOfTheBiggestElem && rows <= 1){
                    sumOfTheBiggestElem = currentSum;
                    biggestMatrixSum [0][0] = matrix [row][coloum];
                    biggestMatrixSum [0][1] = matrix [row][coloum + 1];
                }
            }
        }

        int sumOfTheBiggest2x2 = 0;
        for (int[] ints : biggestMatrixSum) {
            for (int anInt : ints) {
                System.out.printf("%d ",anInt);
                sumOfTheBiggest2x2 += anInt;
            }
            System.out.println();
        }
        System.out.println(sumOfTheBiggest2x2);
    }
}
