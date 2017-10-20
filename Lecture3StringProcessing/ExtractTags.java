package Lecture3StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while(true){
            String input = console.nextLine();

            if (input.equals("END")){
                break;
            }

            Pattern openingTag = Pattern.compile("[<]");
            Pattern closingTag = Pattern.compile("[>]");

            Matcher openingMatcher = openingTag.matcher(input);
            Matcher closingMatcher = closingTag.matcher(input);

            StringBuilder newInput = new StringBuilder(input);
            while(openingMatcher.find() && closingMatcher.find()){
                int startingIndex = newInput.toString().indexOf('<');
                int endingIndex = newInput.toString().indexOf('>');

                String substring = newInput.substring(startingIndex ,endingIndex + 1);
                System.out.println(substring);
                newInput.delete(startingIndex,endingIndex + 1);
            }
        }

    }
}
