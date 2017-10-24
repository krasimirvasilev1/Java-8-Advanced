package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
    
        String[] children = console.nextLine().split("\\s+");
        Integer n = Integer.parseInt(console.nextLine());


        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);

        while (queue.size() > 1) {
            for (int i = 1; i <= n; i++) {
               if (i != n){
                   String firstName = queue.poll();
                   queue.offer(firstName);
               }
               else {
                   System.out.printf("Removed %s%n", queue.poll());

               }
            }
        }

        if (queue.peek() != "") {
            System.out.printf("Last is %s", queue.poll());
        }
    }
}

