package Lecture2;

import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double base = console.nextDouble();
        double height = console.nextDouble();

        System.out.printf("Area = %.2f",CalculateArea(base,height));
    }

    private static double CalculateArea(double base, double height) {
        return (base * height) / 2;

    }
}
