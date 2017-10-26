package Exersice6FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonour {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] names = console.nextLine().split(" ");
        List<String> namesAsList = Arrays.asList(names);

        Consumer<String> addATitle = x -> System.out.println("Sir " + x);

        for (String s : namesAsList) {
            addATitle.accept(s);
        }
    }
}
