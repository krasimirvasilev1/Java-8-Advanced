package Lecture6FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double [] prices = Arrays.stream(console.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        Function<Double,Double> pricesWithVat = x -> x * 1.20;

        System.out.println("Prices with VAT:");
        for (Double aDouble : prices) {
            System.out.println(String.format("%1$.2f",pricesWithVat.apply(aDouble)).replace('.',','));

        }
    }
}
