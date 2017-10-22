package Exersice4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindTheMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int [] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length;j++){
                if (numbers[i] < numbers[j]){
                    int curr = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = curr;
                }
            }
        }
        int missingNum = missingNumber(numbers,1,number);
        System.out.println(missingNum);
    }

    private static int missingNumber (int [] allNumbers, int counter , int number){
        if (counter == number - 1){
            return counter + 1;
        }

        if (counter != allNumbers[counter - 1]){
            return counter;
        }
        return missingNumber(allNumbers,counter + 1 , number);
    }
}
