package Lecture4DataRepresentation;

import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long a  = Long.parseLong(console.nextLine());

        System.out.println(FactorialRecursion(a));
    }
    private static long FactorialRecursion(long number){
        if (number == 0){
            return 1;
        }
        return number * FactorialRecursion(number - 1);
    }
}
