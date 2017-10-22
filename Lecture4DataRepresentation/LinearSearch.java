package Lecture4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberForSearch = Integer.parseInt(reader.readLine());

        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numberForSearch){
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}
