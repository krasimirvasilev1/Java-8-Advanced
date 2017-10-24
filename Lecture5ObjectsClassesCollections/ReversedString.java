package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversedString {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String newString = console.nextLine();

        ArrayDeque <Character> stack = new ArrayDeque<>();

        for (int i = 0; i < newString.length(); i++) {

            char character = newString.charAt(i);
            stack.push(character);
        }

        for (Character character : stack) {
            System.out.printf("%s",character);
        }
    }
}
