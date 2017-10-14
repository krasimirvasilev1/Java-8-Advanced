package Exersice1;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] twoStrings = console.nextLine().split("\\s+");

        char [] arrayOfChars1 = twoStrings[0].toCharArray();
        char [] arrayOfChars2 = twoStrings[1].toCharArray();

        int minimumLenghtOfTheStrings = Math.min(arrayOfChars1.length,arrayOfChars2.length);

        int sum = 0;
        for (int i = 0; i < minimumLenghtOfTheStrings; i++) {
            sum += (arrayOfChars1[i]*arrayOfChars2[i]);
        }

        if (arrayOfChars1.length > minimumLenghtOfTheStrings){
            for (int i = minimumLenghtOfTheStrings; i < arrayOfChars1.length - 1; i++) {
                sum += (int)arrayOfChars1[i];
            }
        }
        else if (arrayOfChars2.length > minimumLenghtOfTheStrings){
            for (int i = minimumLenghtOfTheStrings; i < arrayOfChars2.length - 1; i++) {
                sum += (int)arrayOfChars2[i];
            }
        }
        System.out.println(sum);
    }
}
