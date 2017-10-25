package Exersice5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Character> elements = new ArrayDeque<>();
        String text = console.nextLine();

        boolean balanced = true;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '{' || text.charAt(i) == '[' || text.charAt(i) == '('){
                elements.push(text.charAt(i));
            }
            else{
                if (elements.isEmpty()){
                    balanced = false;
                    break;
                }
                if (text.charAt(i) == ')'){
                    if (elements.peek() == '('){
                        elements.pop();
                    }
                    else {
                        balanced = false;
                        break;
                    }
                }
                else if (text.charAt(i) == ']'){
                    if (elements.peek() == '['){
                        elements.pop();
                    }
                    else {
                        balanced = false;
                        break;
                    }
                }
                else if (text.charAt(i) == '}'){
                    if (elements.peek() == '{'){
                        elements.pop();
                    }
                    else {
                        balanced = false;
                        break;
                    }
                }
            }
        }
        if (balanced && elements.size() == 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
