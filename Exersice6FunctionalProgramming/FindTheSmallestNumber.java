package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(console.readLine().split("\\s+")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

        Function<List<Integer>,Integer> smallestNumber = x -> Collections.min(x);

        for (int i = list.size() - 1; i >= 0 ; i--) {
            if(list.get(i) == smallestNumber.apply(list)){
                System.out.println(i);
                break;
            }
        }
    }
}
