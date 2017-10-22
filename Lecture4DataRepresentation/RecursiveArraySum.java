package Lecture4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Recursion(array,0));
    }
    private static int Recursion (int [] array, int index){
        if (index == array.length - 1){
            return array[index];
        }

        return array[index] + Recursion(array, index + 1);
    }
}
