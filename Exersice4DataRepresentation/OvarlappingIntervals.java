package Exersice4DataRepresentation;

import java.util.Arrays;
import java.util.Scanner;

public class OvarlappingIntervals {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        String [] arrayOfIntervals = new String [number];
        arrayOfIntervals = fillingTheArray(console, number, arrayOfIntervals);

        System.out.println(checkForOverLap(arrayOfIntervals,number,0,false));


    }

    private static String [] fillingTheArray(Scanner console, int number, String[] arrayOfIntervals) {
        for (int i = 0; i < number; i++) {
            int [] intervals = Arrays.stream(console.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            if (intervals[0] > intervals[1]){
                int curr = intervals[0];
                intervals[0] = intervals[1];
                intervals[1] = curr;
            }
            arrayOfIntervals[i] = String.join(",",Arrays.toString(intervals).replace("[","").replace("]",""));
        }
        return arrayOfIntervals;
    }

    private static boolean checkForOverLap (String [] arrayOfIntervals , int number , int counter, boolean falseOrNot){
        if (counter == number){
            return falseOrNot;
        }

        int [] digitsForCheck = Arrays.stream(arrayOfIntervals[counter].split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < number; i++) {
            if (i == counter){
                continue;
            }
            int [] currentDigits = Arrays.stream(arrayOfIntervals[i].split(", ")).mapToInt(Integer::parseInt).toArray();
            if (currentDigits[0] == digitsForCheck[0] || currentDigits[0] == digitsForCheck [1]
                    || currentDigits[1] == digitsForCheck[0] || currentDigits[1] == digitsForCheck[1]){
                falseOrNot = true;
            }
            else if (currentDigits[0] < digitsForCheck[0] && currentDigits[1] > digitsForCheck[0] && currentDigits [1] < digitsForCheck [1]){
                falseOrNot = true;
            }
            else if (currentDigits[0] > digitsForCheck[0] && currentDigits[0] < digitsForCheck[1] && currentDigits[1] > digitsForCheck[1]){
                falseOrNot = true;
            }
        }
        return checkForOverLap(arrayOfIntervals,number,counter + 1,falseOrNot);
    }
}
