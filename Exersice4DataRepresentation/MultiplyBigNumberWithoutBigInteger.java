package Exersice4DataRepresentation;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumberWithoutBigInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String number = console.nextLine();
        Integer numberToMultiply = Integer.parseInt(console.nextLine());

        String result = "";
        int remainder = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int fromStringToInt = Integer.parseInt(Character.toString(number.charAt(i)));
            int operationForTheIteration = (numberToMultiply * fromStringToInt) + remainder;
            if (operationForTheIteration <= 9){
                result += operationForTheIteration;
                remainder = 0;
            }
            else if (operationForTheIteration % 10 == 0){
                remainder = operationForTheIteration / 10;
                result += 0;
            }
            else if (operationForTheIteration % 10 != 0){
                int remainderValueForTheIter = operationForTheIteration % 10;
                result += remainderValueForTheIter;
                remainder = (operationForTheIteration - remainderValueForTheIter) / 10;
            }
        }
        if (remainder != 0){
            result += remainder;
        }

        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }
}
