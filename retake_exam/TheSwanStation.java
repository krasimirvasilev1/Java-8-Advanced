package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(console.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        ArrayDeque<Integer> secondNumbers = new ArrayDeque<>();

        int[] secondNumbersArray = Arrays.stream(console.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        List<String> output = new ArrayList<>();
        for (int i = 0; i < secondNumbersArray.length; i++) {
            secondNumbers.addLast(secondNumbersArray[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            while(true){
                int currNumber = secondNumbers.removeFirst();
                if (currNumber % numbers[i] == 0){
                    output.add(String.valueOf(currNumber));
                    break;
                }

                currNumber++;
                secondNumbers.addLast(currNumber);
            }
        }

        System.out.println(String.join(", ",output));
    }
}
