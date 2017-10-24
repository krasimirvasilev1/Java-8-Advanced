package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String[] children = console.nextLine().split("\\s+");
        Integer n = Integer.parseInt(console.nextLine());
        int counter = 1;

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String firstName = queue.poll();
                queue.offer(firstName);
            }

                    if (isPrime(counter)){
                        System.out.println("Prime " + queue.peek());

                    }
                    else {
                        System.out.printf("Removed %s%n", queue.poll());
                    }

                    counter++;
                }

        if (queue.peek() != "") {
            System.out.printf("Last is %s", queue.poll());
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0){
                return false;
            }
        }

        return true;
    }
}
