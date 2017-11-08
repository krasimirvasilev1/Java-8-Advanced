package Exersices7StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilterStudents {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> students = new ArrayList<>();

        while(true){
            String input = console.nextLine();
            if (input.equals("END")){
                break;
            }

            students.add(input);
        }

        Stream<String []> studentsMails = students.stream().map(x -> x.split("@")).filter(x -> x[1].equals("gmail.com")).map(x -> x[0].split(" "));
        studentsMails.forEach(x -> System.out.printf("%s %s%n",x[0],x[1]));
    }
}
