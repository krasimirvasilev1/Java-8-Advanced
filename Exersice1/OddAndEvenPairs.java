package Exersice1;

import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String [] numbers = console.nextLine().split(" ");

        for (int i = 0; i < numbers.length - 1; i+=2) {

            if (numbers.length % 2 == 1){
                System.out.println("invalid length");
                break;
            }

            boolean firstEven = false;
            boolean secondEven = false;

            if (Integer.parseInt(numbers[i]) % 2 == 0){
                firstEven = true;
            }
            if (Integer.parseInt(numbers[i + 1]) % 2 == 0){
                secondEven = true;
            }

            if (firstEven != secondEven){
                System.out.printf("%s, %s -> different %n",numbers[i],numbers[i + 1]);
            }
            else if (firstEven && secondEven){
                System.out.printf("%s, %s -> both are even %n",numbers[i],numbers[i + 1]);
            }
            else if (!firstEven && !secondEven){
                System.out.printf("%s, %s -> both are odd %n",numbers[i],numbers[i + 1]);
            }
        }
    }
}
