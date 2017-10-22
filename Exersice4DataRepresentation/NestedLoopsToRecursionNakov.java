package Exersice4DataRepresentation;
import java.util.Scanner;


public class NestedLoopsToRecursionNakov {
    private static int numberOfLoops;
    private static int numberOfIterations;
    private static int[] loops;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("N = ");
        numberOfLoops = input.nextInt();

        System.out.print("K = ");
        numberOfIterations = input.nextInt();

        input.close();

        loops = new int[numberOfLoops];

        nestedLoops(0);
    }

    private static void nestedLoops(int currentLoop) {
        if (currentLoop == numberOfLoops) {
            printLoops();
            return;
        }

        for (int counter=1;counter<=numberOfIterations;counter++) {
            loops[currentLoop] = counter;
            nestedLoops(currentLoop + 1);
        }
    }

    private static void printLoops() {
        for (int i = 0; i < numberOfLoops; i++) {
            System.out.printf("%d ", loops[i]);
        }
        System.out.println();
    }
}