package ExamActualSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(console.readLine());
        String bitSequence = number.toString(2);
        StringBuilder text = new StringBuilder(bitSequence);

        int difference = 64 - text.length();
        StringBuilder textWithLeadingZeros = new StringBuilder();
        for (int i = 0; i < difference; i++) {
            textWithLeadingZeros.append(0);
        }
        textWithLeadingZeros.append(text);

        for (int i = 0; i < textWithLeadingZeros.length() - 2; i++) {
            String sequence = textWithLeadingZeros.charAt(i) + ""+textWithLeadingZeros.charAt(i + 1) + textWithLeadingZeros.charAt(i + 2);
            if (sequence.equals("000")){
                textWithLeadingZeros.replace(i ,i + 3,"111");
                i+=2;
            }
            else if (sequence.equals("111")){
                textWithLeadingZeros.replace(i ,i + 3,"000");
                i+=2;
            }
        }

        BigInteger output = new BigInteger(textWithLeadingZeros.toString(), 2);
        System.out.println(output);
    }
}
