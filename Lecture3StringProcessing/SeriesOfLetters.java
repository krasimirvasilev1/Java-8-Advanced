package Lecture3StringProcessing;

import java.util.Scanner;

public class SeriesOfLetters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();
        boolean onlySingleChars = false;
        while (!onlySingleChars){

            int counter = 0;
            String previousChar = " ";
            String consiquenceOfChars = "";
            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                if (i == 0){
                    previousChar = Character.toString(currentChar);
                    counter++;
                    consiquenceOfChars = previousChar;
                }
                else if (Character.toString(currentChar).equals(previousChar)){
                    counter++;
                    consiquenceOfChars += previousChar;
                }
                else if(counter > 1 && !Character.toString(currentChar).equals(previousChar)){
                    text = text.replaceFirst(consiquenceOfChars ,previousChar);
                    break;
                }
                else {
                    counter = 0;
                    previousChar = Character.toString(currentChar);
                    counter++;
                    consiquenceOfChars = previousChar;
                }
                if (i == text.length() - 1){
                    if (counter > 1){
                        text = text.replaceFirst(consiquenceOfChars ,previousChar);
                    }
                    onlySingleChars = true;
                }
            }
        }

        System.out.println(text);
    }
}
