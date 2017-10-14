package Exersice1;

import java.util.Scanner;

public class CalculateExpressions {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double num1 = console.nextDouble();
        double num2 = console.nextDouble();
        double num3 = console.nextDouble();

        double f1 = Math.pow((Math.pow(num1,2) + Math.pow(num2,2)) / (Math.pow(num1,2) - Math.pow(num2,2)), (num1+num2+num3)/Math.sqrt(num3));
        double f2 = Math.pow((Math.pow(num1,2)+Math.pow(num2,2)-Math.pow(num3,3)),num1-num2);

        double averageNumbers = (num1 + num2 + num3) / 3;
        double averageFunctions = (f1 + f2) / 2;

        double diff = Math.abs(averageNumbers - averageFunctions);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",f1,f2,diff);
    }
}
