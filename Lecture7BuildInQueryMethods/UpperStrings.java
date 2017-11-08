package Lecture7BuildInQueryMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UpperStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> text = Arrays.stream(console.nextLine().split(" ")).collect(Collectors.toList());
        text.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.print(x + " "));
    }
}
