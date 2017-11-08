package Exersices7StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> namesAndPhones = new ArrayList<>();

        while (true){
            String input = console.readLine();
            if (input.equals("END")){
                break;
            }

            namesAndPhones.add(input);
        }

        Stream<String []> output = namesAndPhones.stream().map(x -> x.split(" ")).filter(x -> FilterNumbers(x));
        output.forEach(x -> System.out.printf("%s %s%n",x[0],x[1]));
    }

    private static boolean FilterNumbers(String[] x) {
        if (x[2].substring(0,2).equals("02") || x[2].substring(0,4).equals("+359")){
            return true;
        }
        else{
            return false;
        }
    }
}
