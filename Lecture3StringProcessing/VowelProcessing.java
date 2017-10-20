package Lecture3StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelProcessing {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();

        Pattern pattern = Pattern.compile("[AEIOUYaeiouy]");
        Matcher matcher = pattern.matcher(text);

        int count = 0;

        while(matcher.find()){
            count++;
        }

        System.out.println("Vowels: "+count);
    }
}