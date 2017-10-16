package Exersice2Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int [] array = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i]  > array[i + 1]){
                    int curr = array[i];
                    array [i] = array [i + 1];
                    array [i + 1] = curr;
                    i = -1;
                }
            }
        for (int i : array) {
            System.out.print(i + " ");
        }
        }
    }

