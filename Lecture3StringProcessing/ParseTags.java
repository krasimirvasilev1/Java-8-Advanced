package Lecture3StringProcessing;

import java.util.Scanner;

public class ParseTags {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();
        String open = "<upcase>";
        String closed = "</upcase>";

        while(text.contains(open)){
            int startingIndex = text.indexOf(open);
            int lastIndex = text.indexOf(closed);

            String textToReplace = text.substring(startingIndex + open.length(),lastIndex);
            String upperCaseText = textToReplace.toUpperCase();

            text = text.replaceFirst(textToReplace , upperCaseText);
            text = text.replaceFirst(open , "");
            text = text.replaceFirst(closed, "");
        }

        System.out.println(text);
    }
}
