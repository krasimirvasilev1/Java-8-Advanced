package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();

        int counterForOpenBrackets = 0;
        int counterForClosingBrackets = 0;

        ArrayDeque <String> stack = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            String newElementsForStack = "";
            if (symbol != '('){
                continue;
            }
            for (int j = i; j < text.length(); j++){
                char symbol1 = text.charAt(j);
                if (symbol1 == '('){
                    counterForOpenBrackets++;
                }
                else if (symbol1 == ')'){
                    counterForClosingBrackets++;
                }
                newElementsForStack += symbol1;

                if (counterForOpenBrackets == counterForClosingBrackets){
                    stack.push(newElementsForStack);
                    break;
                }
            }
        }

        for (String s : stack) {
            System.out.println(stack.pop());
        }
    }
}
