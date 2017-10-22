package Lecture4DataRepresentation;

import java.util.Collections;
import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        drawingFigures(number);
    }
    private static void drawingFigures (int number) {
        if (number == 0){
            return;
        }

        System.out.println(String.join("",Collections.nCopies(number,"*")));

         drawingFigures(number - 1);

        System.out.println(String.join("",Collections.nCopies(number,"#")));
    }
}
