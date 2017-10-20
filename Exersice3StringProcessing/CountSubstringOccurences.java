package Exersice3StringProcessing;

import java.util.Scanner;

public class CountSubstringOccurences {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine().toLowerCase();
        String searchingPart = console.nextLine().toLowerCase();

        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i + searchingPart.length() - 1 > text.length() - 1){
                break;
            }
            String substring = text.substring(i,i+searchingPart.length());

            if (substring.equals(searchingPart)){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
