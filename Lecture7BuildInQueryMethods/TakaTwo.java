package Lecture7BuildInQueryMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakaTwo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

        numbers.stream().filter(x -> 10 <= x && x <= 20).distinct().limit(2).forEach(x -> System.out.print(x + " "));
    }
}
