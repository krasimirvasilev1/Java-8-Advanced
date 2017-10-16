package Exersice2Matrix;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner console= new Scanner (System.in);

        String [] input = console.nextLine().split(", ");

        int numberOfRowsAndColoums = Integer.parseInt(input[0]);
        char caseAOrB = input[1].charAt(0);

        Integer [][] matrix = new Integer[numberOfRowsAndColoums][numberOfRowsAndColoums];

        switch (caseAOrB){
            case 'A':
            int counter = 1;
            for (int coloum = 0; coloum < matrix.length; coloum++) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix [row][coloum] = counter;
                    counter++;
                }
            }
            break;
            case 'B':
                int counterB = 1;
                for (int coloum = 0; coloum < matrix.length; coloum++) {
                    if (coloum % 2 == 0)for (int row = 0; row < matrix.length; row++) {
                        matrix [row][coloum] = counterB;
                        counterB++;
                    }
                    else {
                        for (int row = matrix.length - 1; row >= 0 ; row--) {
                            matrix [row][coloum] = counterB;
                            counterB++;
                        }
                    }
                }
                break;
        }

        for (Integer[] integers : matrix) {
            for (Integer integer : integers) {
                System.out.printf("%d ",integer);
            }
            System.out.println();
        }
    }
}
