package Exersice3StringProcessing;

import java.util.HashSet;
import java.util.Scanner;

public class MagicExchangableWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        HashSet <Character> firstSet = new HashSet<>();
        HashSet <Character> secondSet = new HashSet<>();

        String [] words = console.nextLine().split(" ");

        for (int i = 0; i < words[0].length() ; i++) {
            firstSet.add(words[0].charAt(i));
        }

        for (int i = 0; i < words[1].length(); i++) {
            secondSet.add(words[1].charAt(i));
        }

        if (firstSet.size() == secondSet.size()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }



    }
}
