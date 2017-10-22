package Lecture4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int searchingNumber = Integer.parseInt(reader.readLine());

        int endNumber = numbers.length - 1;
        int startNumber = 0;

        System.out.println(Number(numbers,searchingNumber,startNumber,endNumber));

    }

    private static int Number (int [] numbers, int searchingNumber , int startNumber,int endNumber){
        while (endNumber >= startNumber){
            int midNumber = (startNumber + endNumber) / 2;
            if (numbers[midNumber] > searchingNumber){
                endNumber = midNumber - 1;
            }
            else if (numbers[midNumber] < searchingNumber){
                startNumber = midNumber + 1;
            }
            else{
                return  midNumber;
            }
        }
        return -1;
    }
}
