package Lecture2;

import java.util.*;

public class ReadSortAndPlayArray {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int lenght = Integer.parseInt(console.nextLine());
        
        String [] stringArray = new String [lenght];

        for (int i = 0; i < stringArray.length; i++) {
            stringArray [i] = console.nextLine();
        }

        Arrays.sort(stringArray);

        for (String s : stringArray) {
            System.out.println(s);
        }
        
    }
}
