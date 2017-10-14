package Exersice1;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {

        Scanner console = new Scanner (System.in);

        int blurAmount = Integer.parseInt(console.nextLine());

        String [] rowsAndColoums = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndColoums[0]);
        int coloums = Integer.parseInt(rowsAndColoums[1]);
        int [][] matrix = new int[rows][coloums];

        for (int i = 0; i < rows; i++) {

            String [] elements = console.nextLine().split(" ");

            int counterElem = 0;
            for (int j = 0; j < coloums; j++) {
                matrix [i][j] = Integer.parseInt(elements[counterElem]);
                counterElem++;
            }
        }

        String [] blurPosition = console.nextLine().split("\\s+");
        int blurRow = Integer.parseInt(blurPosition[0]);
        int blurCol = Integer.parseInt(blurPosition[1]);

        for (int i = blurRow - 1; i <= blurRow + 1 ; i++) {
            if (i < 0){
                continue;
            }
            if (i > rows - 1){
                continue;
            }
            for (int j = blurCol - 1; j <= blurCol + 1; j++) {
                if (j < 0){
                    continue;
                }
                if (j > coloums - 1){
                    continue;
                }
                matrix[i][j] += blurAmount;
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();

        }

    }
}
