package Lecture7BuildInQueryMethods;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinEvenElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        OptionalDouble intStream = Arrays.stream(console.nextLine().split(" ")).filter(x -> !x.isEmpty()).mapToDouble(Double::valueOf).filter(x -> x % 2 == 0).min();

        if (intStream.isPresent()){
            System.out.printf("%.2f",intStream.getAsDouble());
        }
        else{
            System.out.println("No match");
        }
    }
}
