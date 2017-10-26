package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int smallArrows = 0;
        int mediumArrows = 0;
        int bigArrows = 0;
        int counter = 0;
        while(counter < 4){
            String []input = console.readLine().split("[^>-]");

            for (String s : input) {
                if (s.equals(">----->")){
                    smallArrows++;
                }
                else if (s.equals(">>----->")){
                    mediumArrows++;
                }
                else if (s.equals(">>>----->>")){
                    bigArrows++;
                }
            }

            counter++;
        }

        int concatenate = Integer.parseInt(String.valueOf(smallArrows) + String.valueOf(mediumArrows) + String.valueOf(bigArrows));
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(concatenate));
        StringBuilder reversedBinary = new StringBuilder();
        reversedBinary.append(binary);
        binary.reverse();
        StringBuilder concatenateBinary = new StringBuilder(reversedBinary.toString() + binary.toString());
        int finalValue = Integer.parseInt(concatenateBinary.toString(), 2);

        System.out.println(finalValue);


    }
}
