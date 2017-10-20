package Exersice3StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String specialWord = console.nextLine();
        String text = console.nextLine();

        String regex = "[A-Za-z0-9]*[A-Za-z\\s0-9]*\\s+"+"("+specialWord+")"+"\\s+[^!.?]*[!.?]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

            while (matcher.find()){
                System.out.println(matcher.group());
        }
    }
}
