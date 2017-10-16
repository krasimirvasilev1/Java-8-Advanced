package Lecture2;


import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String [] input = console.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int colomns = Integer.parseInt(input[1]);

        Integer [][] demensionArray = new Integer[rows][colomns];

        int sumOfElements = 0;

        for (int row = 0; row < demensionArray.length; row++) {
            String [] elementsOnRow = console.nextLine().split(", ");
            for (int colomn = 0; colomn < demensionArray[row].length; colomn++) {
                demensionArray[row][colomn] = Integer.parseInt(elementsOnRow[colomn]);
            }
        }

            for (Integer[] integers : demensionArray) {
                for (Integer integer : integers) {
                    sumOfElements += integer;

                }
            }

        System.out.println(rows);
        System.out.println(colomns);
        System.out.println(sumOfElements);
            
        }
    }
