package Exersice5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int operationsToDo = Integer.parseInt(console.nextLine());
        for (int i = 0; i < operationsToDo; i++) {
            int [] operations = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (operations[0] == 1){
                stack.push(operations[1]);
            }
            else if (operations[0] == 2){
                stack.pop();
            }
            else if (operations[0] == 3){
                int biggestNumberInTheStack = Integer.MIN_VALUE;
                for (int element : stack) {
                    if (element > biggestNumberInTheStack){
                        biggestNumberInTheStack = element;
                    }
                }
                System.out.println(biggestNumberInTheStack);
            }
        }
    }
}
