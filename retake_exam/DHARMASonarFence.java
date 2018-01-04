package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class DHARMASonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(console.readLine());
        BigInteger three = new BigInteger("3");
        BigInteger zero = new BigInteger("0");

        for (int i = 0; i <= 30 ; i++) {
            BigInteger twoDigits = number.shiftRight(30- i).and(three);
            if (twoDigits.equals(three) || twoDigits.equals(zero)){
                number = number.xor(three.shiftLeft(30 - i));
                i++;
            }
        }
        System.out.println(number);
    }
}

