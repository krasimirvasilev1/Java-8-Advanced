package Exersice3StringProcessing;

import javax.print.DocFlavor;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String [] input = console.nextLine().split("\\s+");

        String  alphabet = " abcdefghijklmnopqrstuvwxyz";

        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            StringBuilder newString = new StringBuilder(input[i].toLowerCase());

            char first = input[i].charAt(0);
            char last = input[i].charAt(input[i].length() - 1);
            double number = Integer.parseInt(input[i].substring(1,input[i].length() - 1));

            boolean lowerOrNotFirst = first == newString.charAt(0);
            boolean lowerOrNotLast = last == newString.charAt(input[i].length() - 1);

            int indexOfTheFirstLetter = alphabet.indexOf(newString.charAt(0));
            int indexOfTheSecondLetter = alphabet.indexOf(newString.charAt(input[i].length() - 1));

            if (lowerOrNotFirst){
                sum += number * indexOfTheFirstLetter;
            }
            else{
                sum += number / indexOfTheFirstLetter;
            }

            if (lowerOrNotLast){
                sum += indexOfTheSecondLetter;
            }
            else{
                sum -= indexOfTheSecondLetter;
            }

        }
        System.out.printf("%.2f",sum);
    }
}
