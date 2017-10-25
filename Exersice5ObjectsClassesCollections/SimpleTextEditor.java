package Exersice5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(text.toString());
        for (int i = 0; i < number; i++) {
            String [] input = console.nextLine().split(" ");
            int operationNumber = Integer.parseInt(input[0]);

            if (operationNumber == 1){
                String textToAppend = input[1];
                text.append(textToAppend);
                stack.push(text.toString());
            }
            else if (operationNumber == 2){
                int elementsToErase = Integer.parseInt(input[1]);
                if (elementsToErase >= text.length()){
                    text = new StringBuilder();
                    stack.push(text.toString());
                }
                else {
                    text = new StringBuilder(text.substring(0,text.length() - elementsToErase));
                    stack.push(text.toString());
                }
            }
            else if (operationNumber == 3){
                int indexOfChar = Integer.parseInt(input[1]);
                if (indexOfChar - 1 > text.length() - 1){
                    System.out.println("");
                }
                else{
                    System.out.println(text.charAt(indexOfChar - 1));
                }
            }
            else if (operationNumber == 4){
                stack.pop();
                text = new StringBuilder(stack.peek());
            }
        }
    }
}
