package Exersice6FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FindEvenOddNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] smallestBiggest = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int smallestNumber = smallestBiggest[0];
        int biggestNumber = smallestBiggest[1];

        String command = console.nextLine();

        for (int i = smallestNumber; i <= biggestNumber ; i++) {
            if (command.equals("odd")) {
                Predicate<Integer> solution = x -> x % 2 != 0;

                isEvenOrOdd(solution,i);

            }
            else {
                Predicate<Integer> solution = x -> x % 2 == 0;

                isEvenOrOdd(solution,i);
            }
        }
    }
    private static void isEvenOrOdd (Predicate<Integer> solution , int i){
        if (solution.test(i)){
            System.out.print(i + " ");
        }
    }
}

