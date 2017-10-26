package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
         int number = Integer.parseInt(console.readLine());
        String [] text = console.readLine().split(" ");

        Predicate <String> check = x -> x.length() <= number;

        for (String s : text) {
            if (check.test(s)){
                System.out.println(s);
            }
        }
    }
}
