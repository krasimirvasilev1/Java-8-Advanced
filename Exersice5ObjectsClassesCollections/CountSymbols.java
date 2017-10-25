package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Character> set  = new TreeSet<>();
        String text = console.readLine();
        for (int i = 0; i < text.length(); i++) {
            set.add(text.charAt(i));
        }

        for (Character character : set) {
            char currChar = character;
            int counter = 0;
            for (int i = 0; i < text.length(); i++) {
                if (currChar == text.charAt(i)){
                    counter++;
                }
            }
            System.out.println(currChar+": "+counter+" time/s");
        }
    }
}
