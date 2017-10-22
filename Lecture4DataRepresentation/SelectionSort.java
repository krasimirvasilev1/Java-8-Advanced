package Lecture4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = Arrays.stream(console.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            int index = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[min]){
                    min = j;
                }
            }
            numbers = swapElelemt(min,index,numbers);
        }

        for (int number : numbers) {
            System.out.print(number + " ");

        }
    }

    private static int [] swapElelemt (int min,int index , int [] numbersArray){
        int curr = numbersArray[min];
        numbersArray[min] = numbersArray[index];
        numbersArray[index] = curr;

        return numbersArray;
    }
}
