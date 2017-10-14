package Exersice1;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Integer x1 = console.nextInt();
        Integer y1 = console.nextInt();

        Integer x2 = console.nextInt();
        Integer y2 = console.nextInt();

        Integer x3 = console.nextInt();
        Integer y3 = console.nextInt();

        Integer area = Math.abs((x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)) / 2);

        System.out.println(area);
    }
}
