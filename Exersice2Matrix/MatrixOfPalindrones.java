package Exersice2Matrix;

import java.util.Calendar;
import java.util.Scanner;

public class MatrixOfPalindrones {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int coloums = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][coloums];

        char value = 97;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < coloums; j++) {
                int value1 = value + j;
                String s = String.valueOf(value) + (char)value1 + value;
                matrix[i][j] = s;

                value1++;
            }
            value++;
        }

                for (String[] strings : matrix) {
                    for (String string : strings) {
                        System.out.printf("%s ", string);
                    }
                    System.out.println();
                }
            }
        }
