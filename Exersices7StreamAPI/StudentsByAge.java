package Exersices7StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> allPeople = new ArrayList<>();
        while(true){
            String input = console.readLine();
            if (input.equals("END")){
                break;
            }

            allPeople.add(input);
        }
        Stream<String []> filter = allPeople.stream().map(x -> x.split(" ")).filter(x -> isInTheRange(x[2]));
        filter.forEach(x -> System.out.printf("%s %s %s%n",x[0],x[1],x[2]));
    }

    private static boolean isInTheRange(String age) {
        return Integer.parseInt(age) >= 18 && Integer.parseInt(age) <= 24;
    }
}
