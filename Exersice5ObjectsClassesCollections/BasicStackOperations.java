package Exersice5ObjectsClassesCollections;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        String [] elements = console.nextLine().split(" ");
        int numbersToPush = Integer.parseInt(elements[0]);
        int numbersToPop = Integer.parseInt(elements[1]);
        int numbersInQueue = Integer.parseInt(elements[2]);

        int minimumNumber = Integer.MAX_VALUE;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
            stack.push(console.nextInt());
        }

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.contains(numbersInQueue)){
            System.out.println("true");
        }
        else{
            if (stack.size() == 0){
                minimumNumber = 0;
            }
           while(stack.size() > 0){
               if (stack.peek() < minimumNumber){
                   minimumNumber = stack.pop();
               }
               else{
                   stack.pop();
               }
           }
               System.out.println(minimumNumber);
           }
        }
    }

