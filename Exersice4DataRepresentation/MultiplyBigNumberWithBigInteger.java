package Exersice4DataRepresentation;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumberWithBigInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BigInteger numberOne = new BigInteger(console.nextLine());
        BigInteger numberTwo = new BigInteger(console.nextLine());

        System.out.println(numberOne.multiply(numberTwo));


    }
}