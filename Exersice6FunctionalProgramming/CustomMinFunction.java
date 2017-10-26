package Exersice6FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer [] numbers = Arrays.stream
                (Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new);

        Function<Integer [],Integer> function = ints -> Collections.min(Arrays.asList(ints));

        System.out.println(function.apply(numbers));

    }
}
