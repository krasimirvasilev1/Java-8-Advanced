package Lecture1;

import java.util.Scanner;

public class ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] operationNumbers = console.nextLine().split("\\s+");
        int number = Integer.parseInt(operationNumbers[0]);
        int index = Integer.parseInt(operationNumbers[1]);

        String binaryNumber = Integer.toBinaryString(number);

        int counter = 0;
        for (int i = binaryNumber.length() - 1; i >= 0 ; i--) {
            if (counter == index){
                System.out.println(binaryNumber.charAt(i));
            }
            counter++;
        }
    }
}
