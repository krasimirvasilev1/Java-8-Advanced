package Exersice3StringProcessing;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] banWords = console.nextLine().split(", ");
        String text = console.nextLine();

        StringBuilder newText = new StringBuilder(text);
        for (int i = 0; i < banWords.length; i++) {
            Pattern pattern = Pattern.compile(banWords[i]);
            Matcher matcher = pattern.matcher(newText);

            while(matcher.find()){
                int startingIndex = newText.indexOf(banWords[i]);
                String textToReplace = new String(new char[banWords[i].length()]).replace('\0','*');
                newText.replace(startingIndex,startingIndex + banWords[i].length(),textToReplace);
            }
        }

        System.out.println(newText);
    }
}
