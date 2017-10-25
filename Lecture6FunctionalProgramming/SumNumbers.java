package Lecture6FunctionalProgramming;

        import java.util.Arrays;
        import java.util.Scanner;
        import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String [] numbers = console.nextLine().split(", ");

        Function<String,Integer> sumNumbers = x -> Integer.parseInt(x);
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += sumNumbers.apply(numbers[i]);
        }

        System.out.println("Count = "+numbers.length);
        System.out.println("Sum = "+sum);
    }
}
