package Exersice1;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String [] digits = console.nextLine().split("\\s+");
        String [] text = console.nextLine().split("\\s+");

        Integer numberOfElements = Integer.parseInt(text[1]);
        String evenOrOdd = text[2];

        ArrayList <Integer> numsForPrint = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < digits.length; i++) {
            int currentNum = Integer.parseInt(digits[i]);
            if (evenOrOdd.equals("odd")){
                if (counter == numberOfElements){
                    break;
                }
                if (currentNum % 2 == 1){
                    numsForPrint.add(currentNum);
                    counter++;
                }
            }
            else if (evenOrOdd.equals("even")){
                if (counter == numberOfElements){
                    break;
                }
                if (currentNum % 2 == 0){
                    numsForPrint.add(currentNum);
                    counter++;
                }
            }
        }
        for (int element : numsForPrint) {
            System.out.printf("%d ",element);
        }
    }
}
