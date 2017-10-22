package Exersice4DataRepresentation;

import java.util.Arrays;
import java.util.Scanner;

public class ImplementBinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int [] numbers = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberToSearch = Integer.parseInt(console.nextLine());
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int mid = (startIndex + endIndex) / 2;

        System.out.println(findIndex(numbers,numberToSearch,mid,startIndex,endIndex));
    }
    private static int findIndex (int [] numbers,int numberToSearch ,int mid , int startIndex , int endIndex ) {

        if (numbers[mid] > numberToSearch){
            endIndex = mid - 1;
        }
        else if (numbers[mid] < numberToSearch){
            startIndex = mid + 1;
    }
        else if (numbers[mid] == numberToSearch){
            return mid;
        }
       if (startIndex > endIndex) {
            return -1;
       }
        return findIndex(numbers,numberToSearch,(startIndex + endIndex) / 2,startIndex,endIndex);
    }
}
