package Exersices7StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();

        while(true){
            String input = console.readLine();
            if (input.equals("END")){
                break;
            }
            names.add(input);
        }

        Stream<String []> sortedNames = names.stream().map(x -> x.split(" ")).sorted((x,y) -> SortedFunction(x,y));
        sortedNames.forEach(x -> System.out.printf("%s %s%n",x[0],x[1]));
    }

    private static int SortedFunction(String[] x, String[] y) {
        int firstCompare = x[1].compareTo(y[1]);
        if (firstCompare != 0){
            return firstCompare;
        }
        else{
            int secondCompare = y[0].compareTo(x[0]);
            return secondCompare;
        }
    }
}
