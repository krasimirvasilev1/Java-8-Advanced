package Exersices7StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> names = new ArrayList<>();

        while(true){
            String input = console.nextLine();
            if (input.equals("END")){
                break;
            }

            names.add(input);
        }

        Stream<String []> sortedOutput = names.stream().map(x -> x.split(" ")).filter(x -> x[0].compareTo(x[1]) < 0);

        sortedOutput.forEach(x -> System.out.printf("%s %s%n",x[0],x[1]));
    }
}
