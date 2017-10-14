package Exersice1;

import java.util.Scanner;

public class FormatingNumber {
    public static void main(String[] args) {

        Scanner console = new Scanner (System.in);

        int num1 = console.nextInt();
        double num2 = console.nextDouble();
        double num3 = console.nextDouble();

        System.out.printf("|%s        |0%s0|%.2f|%.3f|",Integer.toHexString(num1),Integer.toBinaryString(num1),num2,num3);
    }
}
