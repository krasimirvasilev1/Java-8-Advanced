package Exersice2Matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PlusRemove {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String rotationNumber = console.nextLine();
        String substringTheDigit = rotationNumber.substring(7,rotationNumber.length() - 1);
        int numberForRotation = Integer.parseInt(substringTheDigit);

        int rows = 0;
        int columns = Integer.MIN_VALUE;
        List<String> allInputValues = new LinkedList<>();

        while(true){
            String input = console.nextLine();

            if (input.equals("END")){
                break;
            }

            rows++;
            if (input.length() > columns){
                columns = input.length();
            }

            allInputValues.add(input);
        }

        Character [][] matrix = new Character[rows][columns];

        for (int i = 0; i < allInputValues.size(); i++) {
            matrix[i] = new Character[allInputValues.get(i).length()];
            for (int j = 0; j < allInputValues.get(i).length(); j++) {
                matrix[i][j] = allInputValues.get(i).charAt(j);
            }
        }

        int numberOfTimesToRotate = numberForRotation / 90;
        int index = numberOfTimesToRotate % 4;

        switch (index){
            case 0:
                for (Character[] strings : matrix) {
                    for (Character character : strings) {
                        if (character != null)
                        System.out.print(character);
                    }
                    System.out.println();
                }
                break;
            case 1:
                for (int i = 0; i < columns; i++) {
                    String print =  "";
                    for (int j = rows - 1; j >= 0; j--) {
                        if (i > matrix[j].length - 1){
                            print += " ";
                            continue;
                        }
                        print += (Character.toString(matrix[j][i]));
                        }
                    System.out.println(print);
                    }
                    break;
            case 2:
                for (int i = rows - 1; i >= 0; i--) {
                    String print =  "";
                    for (int j = columns - 1; j >= 0; j--) {
                        if (j > matrix[i].length - 1){
                            print += " ";
                            continue;
                        }
                        print += (Character.toString(matrix[i][j]));
                    }
                    System.out.println(print);
                }
                break;

            case 3:
                for (int i = columns - 1; i >= 0; i--) {
                    String print =  "";
                    for (int j = 0; j < rows; j++) {
                        if (i > matrix[j].length - 1){
                            print += " ";
                            continue;
                        }
                        print += (Character.toString(matrix[j][i]));
                    }
                    System.out.println(print);
                }
                break;
        }
        }
    }