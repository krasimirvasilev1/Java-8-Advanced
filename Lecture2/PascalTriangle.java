package Lecture2;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int height = Integer.parseInt(console.nextLine());

        long [][] pascalTriangle = new long[height][];

        for (int i = 0; i < height ; i++) {
            pascalTriangle[i] = new long[i + 1];
        }

        for (int row = 0; row < height; row++) {
            pascalTriangle[row][0] = 1;
            pascalTriangle[row][pascalTriangle[row].length - 1] = 1;
            for (int col = 1; col < pascalTriangle[row].length - 1; col++) {
                pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1] + pascalTriangle[row - 1][col];
            }
        }

        PrintValues(pascalTriangle);
    }

    private static void PrintValues(long[][] pascalTriangle) {
        for (long[] ints : pascalTriangle) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
