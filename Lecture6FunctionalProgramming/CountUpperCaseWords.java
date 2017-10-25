package Lecture6FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String [] text = console.nextLine().split(" ");

        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> allUpperCaseLetters = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            if (checkerUpperCase.test(text[i])){
                allUpperCaseLetters.add(text[i]);
            }
        }

        System.out.println(allUpperCaseLetters.size());
        for (String allUpperCaseLetter : allUpperCaseLetters) {
            System.out.println(allUpperCaseLetter);

        }
    }
}
