package Lecture5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String [] symbols = console.nextLine().split("\\s+");

        ArrayDeque <String> calculatorData = new ArrayDeque<>();

        for (String symbol : symbols) {
            calculatorData.push(symbol);
        }

        while(calculatorData.size() > 1){

            int leftNumber = Integer.valueOf(calculatorData.pop());
            String symbol = calculatorData.pop();
            int rightNumber = Integer.valueOf(calculatorData.pop());

            int sum = 0;

            if (symbol.equals("+")){
                sum = leftNumber + rightNumber;
            }
            else {
                sum = leftNumber - rightNumber;
            }

            calculatorData.push(String.valueOf(sum));
        }

        System.out.println(calculatorData.pop());
    }
}
