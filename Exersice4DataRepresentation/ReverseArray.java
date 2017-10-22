package Exersice4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = array.length - 1;
        int indexNewArray = 0;
        int [] newArray = new int [array.length];
        newArray = Recursion(array,newArray,index,indexNewArray);

        for (int i : newArray) {
            System.out.print(i + " ");
        }

    }

    private static int [] Recursion(int[] array,int [] newIndex,  int index , int indexNewArray) {

        if (index < 0){
            return newIndex;
        }
        newIndex [indexNewArray] = array [index];
        return Recursion(array , newIndex, index - 1 , indexNewArray + 1);
    }
}

