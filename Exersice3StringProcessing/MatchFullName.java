package Exersice3StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (true){
            String text = console.nextLine();

            if (text.equals("end")){
                break;
            }
            String pattern = "\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b";

            Pattern pattern1 = Pattern.compile(pattern);
            Matcher matcher = pattern1.matcher(text);

            if (matcher.find()){
                System.out.println(text);
            }
        }
    }
}
