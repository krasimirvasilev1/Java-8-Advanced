package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int maximumNumberInTheRange = Integer.parseInt(console.readLine());
        int [] digitToCheckTheDivision = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> printNumbers = new ArrayList<>();

        boolean coverAllRequirements = false;
        for (int i = 1; i <= maximumNumberInTheRange ; i++) {
            for (int j = 0; j < digitToCheckTheDivision.length; j++) {
                int currNumber = digitToCheckTheDivision[j];
                Predicate<Integer> bolleanToAccept = x -> x % currNumber == 0;
                if (bolleanToAccept.test(i)){
                    coverAllRequirements = true;
                }
                else {
                    coverAllRequirements = false;
                    break;
                }
            }
            if (coverAllRequirements){
                printNumbers.add(i);
            }
        }

        for (Integer printNumber : printNumbers) {
            System.out.print(printNumber + " ");
        }
    }
}
