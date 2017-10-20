package Exersice3StringProcessing;

import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            String startText = "\\u00";
            String uniCode = Integer.toHexString(text.charAt(i));

            newText.append(startText + uniCode);
        }
        System.out.println(newText);
    }
}
