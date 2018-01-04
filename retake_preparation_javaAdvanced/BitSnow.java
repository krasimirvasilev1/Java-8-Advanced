package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = Arrays.stream(console.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int count = numbers.length;
        for (int i = 0; i < count; i++) {
            for (int j = numbers.length - 1; j > 0 ; j--) {
                int numberOne = numbers[j];
                numbers[j] = numberOne | numbers[j - 1];
                numbers[j - 1] = numberOne & numbers[j - 1];
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            builder.append(number + ", ");
        }

        System.out.println(builder.toString().substring(0,builder.length() - 2));
    }
}
