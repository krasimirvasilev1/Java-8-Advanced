package Exersice1;

import java.util.Arrays;
import java.util.Scanner;

public class sad {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double [] numbers = Arrays.stream(console.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.printf("%.2f ",sum / numbers.length);
    }
}
