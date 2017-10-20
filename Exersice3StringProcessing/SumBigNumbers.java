package Exersice3StringProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BigInteger numberOne = new BigInteger(console.nextLine());
        BigInteger numberTwo = new BigInteger(console.nextLine());

        BigInteger sum = numberOne.add(numberTwo);

        System.out.println(sum);
    }
}
