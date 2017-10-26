package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int divideNumber = Integer.parseInt(console.readLine());

        List<Integer> allNumbersNotIncluded = new ArrayList<Integer>();

        Predicate<Integer> check = x -> x % divideNumber != 0;

        for (int i = 0; i < numbers.length; i++) {
            if (check.test(numbers[i])){
                allNumbersNotIncluded.add(numbers[i]);
            }
        }

        Function<List<Integer>,List<Integer>> reversedList = integers -> {
            for (int i = 0; i < integers.size() / 2 ;i++) {
                int curr = integers.get(i);
                integers.set(i , integers.get(integers.size() - i - 1));
                integers.set(integers.size() - i - 1 , curr);
            }
            return integers;
        };
        allNumbersNotIncluded = reversedList.apply(allNumbersNotIncluded);
        for (Integer integer : allNumbersNotIncluded) {
            System.out.print(integer + " ");
        }
    }
}
