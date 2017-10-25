package Exersice5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<long[]> stack = new ArrayDeque<>();
        ArrayDeque<long[]> stackForIteration = new ArrayDeque<>();

        int numbers = Integer.parseInt(console.nextLine());
        int smallestIndex = Integer.MAX_VALUE;

        for (int i = 0; i < numbers; i++) {
            long[] inputToStack = Arrays.stream(console.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            stack.offer(inputToStack);
        }
            for (int i = 0; i < numbers; i++) {
                long[] currentIndex = stack.poll();
                long amountOfFuelGives = currentIndex[0];
                long distanceToTheOtherPump = currentIndex[1];
                stack.offer(currentIndex);
                stackForIteration = stack.clone();
                if (amountOfFuelGives < distanceToTheOtherPump) {
                    continue;
                }
                amountOfFuelGives -= distanceToTheOtherPump;
                for (int j = 1; j < numbers; j++) {
                    long[] nextIndex = stackForIteration.poll();
                    long amountOfFuelGives2 = nextIndex[0];
                    long distanceToTheOtherPump2 = nextIndex[1];

                    amountOfFuelGives += amountOfFuelGives2;
                    if (amountOfFuelGives < distanceToTheOtherPump2) {
                        break;
                    }
                    amountOfFuelGives -= distanceToTheOtherPump2;
                    stackForIteration.offer(nextIndex);
                    if (j == numbers - 1) {
                        if (smallestIndex > i) {
                            smallestIndex = i;
                            break;
                        }
                    }
                }
                if (smallestIndex == i){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
