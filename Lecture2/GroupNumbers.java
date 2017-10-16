package Lecture2;

import java.util.Scanner;

public class GroupNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Integer [][] numbers = new Integer [3][];
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;

        String [] stringOfNumbers = console.nextLine().split(", ");

        for (int i = 0; i < stringOfNumbers.length; i++) {
            int currentNumber = Integer.parseInt(stringOfNumbers[i]);
            if (currentNumber % 3 == 0){
                counter0++;
            }
            else if (currentNumber % 3 == 1){
                counter1++;
            }
            else if (currentNumber % 3 == 2){
                counter2++;
            }
        }


    }
}
