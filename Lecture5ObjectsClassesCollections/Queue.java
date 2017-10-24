package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        ArrayDeque <Integer> deque = new ArrayDeque<>();

        deque.push(1);
        deque.offer(1);
        deque.push(2);
        deque.offer(2);

        deque.pop();
        deque.poll();
        deque.pop();

        deque.push(5);
        deque.offer(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
       //System.out.println(deque.peek());

    }
}
