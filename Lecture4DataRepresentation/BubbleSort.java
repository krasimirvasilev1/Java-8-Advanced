package Lecture4DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

                int [] array = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

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