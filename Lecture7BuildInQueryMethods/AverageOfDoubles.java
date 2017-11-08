package Lecture7BuildInQueryMethods;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class AverageOfDoubles {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

            List <String> doubleNumbers = Arrays.stream(text.split(" ")).collect(Collectors.toList());

            OptionalDouble averageOfDoubles = doubleNumbers.stream().filter(n -> !n.isEmpty()).mapToDouble(Double::valueOf).average();

            if (averageOfDoubles.isPresent()){
                System.out.printf("%.2f",averageOfDoubles.getAsDouble());
            }
            else{
                System.out.println("No match");
            }
        }
}
