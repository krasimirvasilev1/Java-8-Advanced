package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets1 {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String text = console.nextLine();

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < text.length(); index++) {
            char symbol = text.charAt(index);
            if (symbol == '('){
                stack.push(index);
            }
            else if (symbol == ')'){
                int startIndex = stack.pop();
                String sub = text.substring(startIndex, index + 1);
                System.out.println(sub);
            }
        }

    }
}
