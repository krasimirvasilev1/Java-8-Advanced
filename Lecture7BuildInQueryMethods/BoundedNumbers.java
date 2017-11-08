package Lecture7BuildInQueryMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = console.readLine().split(" ");
        String[] allNumbers = console.readLine().split(" ");

        Stream<String> numbersInTheBounds = Arrays.stream(allNumbers).filter(x -> isInTheBounds(numbers, x));
        numbersInTheBounds.forEach(x -> System.out.print(x + " "));
    }

    private static boolean isInTheBounds(String[] numbers, String currNumber) {
        int lowestBound = 0;
        int biggestBount = 0;
        if (Integer.parseInt(numbers[1]) > Integer.parseInt(numbers[0])){
            biggestBount = Integer.parseInt(numbers[1]);
            lowestBound = Integer.parseInt(numbers[0]);
        }
        else{
            biggestBount = Integer.parseInt(numbers[0]);
            lowestBound = Integer.parseInt(numbers[1]);
        }

        boolean isInTheBounds = false;
        for (int i = lowestBound; i < biggestBount; i++) {
            if (Integer.parseInt(currNumber) >= lowestBound && biggestBount >= Integer.parseInt(currNumber)) {
                isInTheBounds = true;
                break;
            }
        }
        if (!isInTheBounds) {
            return false;
        }
        else{
            return true;
        }
    }
}
