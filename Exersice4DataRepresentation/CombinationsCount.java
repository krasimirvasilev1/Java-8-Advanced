package Exersice4DataRepresentation;

import java.math.BigInteger;
import java.util.Scanner;

public class CombinationsCount {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(console.nextLine());
        BigInteger secondNumber = new BigInteger(console.nextLine());

        BigInteger factorialOfTheDevision = factorialOfTheDevision(firstNumber.subtract(secondNumber));
        BigInteger firstNumberFactorial = factorialOfFirstNumber(firstNumber);
        BigInteger secondNumberFactorial = factorialOfTheSecondNumber(secondNumber);

        System.out.println(result(firstNumberFactorial,secondNumberFactorial,factorialOfTheDevision));
    }
    private static BigInteger factorialOfFirstNumber(BigInteger firstNumber){
        if (firstNumber.equals(new BigInteger("0"))){
            return new BigInteger("1");
        }
        return firstNumber.multiply(factorialOfFirstNumber(firstNumber.subtract(new BigInteger("1"))));
    }

    private static BigInteger factorialOfTheDevision(BigInteger devisionNumber){
        if (devisionNumber.equals(new BigInteger("0"))){
            return new BigInteger("1");
        }
        return devisionNumber.multiply(factorialOfFirstNumber(devisionNumber.subtract(new BigInteger("1"))));
    }

    private static BigInteger factorialOfTheSecondNumber(BigInteger devisionNumber){
        if (devisionNumber.equals(new BigInteger("0"))){
            return new BigInteger("1");
        }
        return devisionNumber.multiply(factorialOfTheSecondNumber(devisionNumber.subtract(new BigInteger("1"))));
    }

    private static BigInteger result (BigInteger factorialOne , BigInteger factorialTwo , BigInteger factorialThree){

            return factorialOne.divide((factorialThree).multiply(factorialTwo));
    }



}
