package Lecture6FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.*;

public class SortOddNumbersLambda {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] numbers = Arrays.stream(console.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> numbersAsList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            numbersAsList.add(numbers[i]);
        }

        numbersAsList.removeIf(x -> x % 2 != 0);
        for (int i = 0; i < numbersAsList.size(); i++) {
            if (i != numbersAsList.size() - 1){
                System.out.print(numbersAsList.get(i) + ", ");
            }
            else{
                System.out.print(numbersAsList.get(i));
            }
        }
        numbersAsList.sort((a,b) -> a.compareTo(b));
        System.out.println();
        for (int i = 0; i < numbersAsList.size(); i++) {
            if (i != numbersAsList.size() - 1){
                System.out.print(numbersAsList.get(i) + ", ");
            }
            else{
                System.out.print(numbersAsList.get(i));
            }
        }

    }
}
