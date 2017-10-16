package Lecture2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer people = Integer.parseInt(console.nextLine());

        List <Integer> sort = new ArrayList<>();

        for (int i = 0; i < people; i++) {
            String person = console.nextLine();
            int sum = 0;

            for (int j = 0; j < person.length(); j++) {
                if (person.charAt(j) == 'e' || person.charAt(j) == 'a' || person.charAt(j) == 'i'
                        || person.charAt(j) == 'o' || person.charAt(j) == 'u'){
                    sum += person.charAt(j) * person.length();
                }
                else {
                    sum += person.charAt(j) / person.length();
                }
            }

            sort.add(sum);
        }
        Collections.sort(sort);

        for (Integer integer : sort) {
            System.out.println(integer);
        }
    }
}
