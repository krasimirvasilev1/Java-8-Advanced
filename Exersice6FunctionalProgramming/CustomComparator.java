package Exersice6FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] numbers = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> checkIfItsEven = x -> x % 2 == 0;
        Arrays.sort(numbers);
        List<Integer> sortedNumbers = new ArrayList<>();
        Function <int[],List<Integer>> sortedEvenNumbersFirst = x -> {
            List<Integer> listForTheOperation = new ArrayList<>();
            for (int i = 0; i < x.length; i++) {
                if(checkIfItsEven.test(x[i])){
                    listForTheOperation.add(x[i]);
                }
            }
            for (int i = 0; i < x.length; i++) {
                if (!checkIfItsEven.test(x[i])){
                    listForTheOperation.add(x[i]);
                }
            }
            return listForTheOperation;
        };

        sortedNumbers = sortedEvenNumbersFirst.apply(numbers);
        for (Integer sortedNumber : sortedNumbers) {
            System.out.print(sortedNumber + " ");
        }
    }
}
