package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] operations = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int [] numbers = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            queue.offer(number);
        }

        for (int i = 0; i < operations[1]; i++) {
            queue.poll();
        }

        if (queue.contains(operations[2])){
            System.out.println("true");
        }
        else {
            int smallestNumber = Integer.MAX_VALUE;
            if (queue.size() == 0){
                System.out.println(0);
            }
            else {
                for (Integer integer : queue) {
                    if (integer < smallestNumber) {
                        smallestNumber = integer;
                    }
                }
                System.out.println(smallestNumber);
            }
        }

    }
}
