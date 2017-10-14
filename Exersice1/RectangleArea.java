package Exersice1;

import java.math.BigDecimal;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        BigDecimal a = console.nextBigDecimal();
        BigDecimal b = console.nextBigDecimal();

        BigDecimal sum = a.multiply(b);

        System.out.printf("%.2f",sum);
    }
}
