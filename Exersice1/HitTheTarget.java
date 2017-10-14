package Exersice1;

import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int specialNumber = Integer.parseInt(console.nextLine());

        for (int numberOne = 1; numberOne <= 20; numberOne++){
            for (int numberTwo = 1;numberTwo <= 20; numberTwo++){
                if(numberOne + numberTwo == specialNumber){
                    System.out.println(numberOne + " + " + numberTwo + " = " + specialNumber);
                }
                if (numberOne - numberTwo == specialNumber){
                    System.out.println(numberOne + " - "+ numberTwo + " = " + specialNumber);
                }
            }
        }
    }
}
