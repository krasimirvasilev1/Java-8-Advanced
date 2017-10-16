package Exersice2Matrix;

import java.util.*;

public class SequenceInMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowsAndColoums = console.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndColoums[0]);
        int coloums = Integer.parseInt(rowsAndColoums[1]);

        String[][] matrix = new String[rows][coloums];

        String maximumSequence = "";
        int maximumScore = 0;
        for (int i = 0; i < rows; i++) {
            String[] inputNumbers = console.nextLine().split(" ");
            for (int j = 0; j < coloums; j++) {
                matrix[i][j] = inputNumbers[j];
            }
        }

        for (int i = 0; i < coloums; i++) {
            int counter = 0;
            String previousElement = "";
            for (int j = 0; j < rows; j++) {
                String currentElem = matrix[j][i];
                if (j == 0) {
                    counter++;
                    previousElement = currentElem;
                } else {
                    if (currentElem.equals(previousElement)) {
                        counter++;
                    } else {
                        if (counter >= maximumScore) {
                            maximumScore = counter;
                            maximumSequence = previousElement;
                        }
                        counter = 1;
                        previousElement = currentElem;
                    }
                }
            }
            if (counter >= maximumScore) {
                maximumScore = counter;
                maximumSequence = previousElement;
            }
        }

        for (int i = 1; i <= maximumScore; i++) {
            if (i == maximumScore) {
                System.out.print(maximumSequence);
                break;
            }
            System.out.printf("%s, ", maximumSequence);
        }
    }
    }
