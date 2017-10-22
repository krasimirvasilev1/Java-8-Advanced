package Exersice4DataRepresentation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Chocolates {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(console.nextLine());
        int [] allElements = Arrays.stream(console.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int numberOfPeople = Integer.parseInt(console.nextLine());
        int [] theSmallestElements = new int[numberOfPeople];

        theSmallestElements = takaTheSmallestNumbers(sortedArray(allElements, 0),0,numberOfPeople - 1,theSmallestElements,Integer.MAX_VALUE);

        System.out.println("Min Difference is "+(biggestElem(Integer.MIN_VALUE ,theSmallestElements) - smallestElem(Integer.MAX_VALUE,theSmallestElements))+".");



    }
    private static int [] sortedArray (int [] unsortedArray , int indexToStartSorting){
        for (int i = indexToStartSorting; i < unsortedArray.length - 1; i++) {
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[i]){
                    int curr = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[i];
                    unsortedArray[i] = curr;
                }
            }
        }
        return unsortedArray;
    }

    private static int [] takaTheSmallestNumbers (int [] sortedArray,int zeroIndex,int difference, int [] theSmallestElem , int smallestDiff){
        if (difference == sortedArray.length){
            return theSmallestElem;
        }

        if (smallestDiff > sortedArray[difference] - sortedArray[zeroIndex]){
            smallestDiff = sortedArray[difference] - sortedArray[zeroIndex];
            for (int i = 0; i < theSmallestElem.length; i++) {
                theSmallestElem[i] = sortedArray[i+zeroIndex];
            }
        }
        return takaTheSmallestNumbers(sortedArray,zeroIndex + 1 , difference+1,theSmallestElem,smallestDiff);
    }

    private static int biggestElem (int smallestElem , int [] theSmallestElements){
        int result = smallestElem;
        for (int i = 0; i < theSmallestElements.length; i++) {
            if (theSmallestElements[i] > result){
                result = theSmallestElements[i];
            }
        }
        return result;
    }

    private static int smallestElem (int biggestElem , int [] theSmallestElements){
        int result = biggestElem;
        for (int i = 0; i < theSmallestElements.length; i++) {
            if (theSmallestElements[i] < result){
                result = theSmallestElements[i];
            }
        }
        return result;
    }
}
