package Exersice6FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] input = console.nextLine().split(" ");
        Consumer<String> printStrings = x -> System.out.println(x);

        for (String s : input) {
            printStrings.accept(s);
        }
    }
}
