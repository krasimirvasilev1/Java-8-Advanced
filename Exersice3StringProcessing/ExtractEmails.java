package Exersice3StringProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();
        List<String> emails = new ArrayList<>();
        String pattern = "^(([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|\\,|\\.|\\-|\\_)+@([a-z]|[A-Z])([a-z]|[A-Z]|\\-)+\\.([a-z]|[A-Z])([a-z]|[A-Z]|\\-)+(\\.*[a-z]|[A-Z]*[a-z]|[A-Z]|\\-)*)";
        while(!text.equals("end")){

            String [] arrayOfWords = text.split("[, \\s+]");

            for (int i = 0; i < arrayOfWords.length; i++) {

                if (Pattern.matches(pattern,arrayOfWords[i])){
                    emails.add(arrayOfWords[i]);
                }
            }
            
            text = console.nextLine();
        }

        for (String email : emails) {
            System.out.println(email);
        }
    }
}