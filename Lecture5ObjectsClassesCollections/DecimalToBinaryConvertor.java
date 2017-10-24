package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConvertor {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        while (number != 0){

            int addition = number % 2;
            stack.push(addition);

            number = number / 2;
        }

        while (!stack.isEmpty()){
            System.out.printf("%d",stack.pop());
        }
    }
}
