package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] input = console.readLine().split(", ");
        String[][] matrix = new String[input.length][12];

        for (int i = 0; i < input.length; i++) {
            StringBuilder builder = new StringBuilder();
            String fromNumberToBinary = Integer.toBinaryString(Integer.parseInt(input[i]));
            int diff = 12 - fromNumberToBinary.length();
            for (int j = 0; j < diff; j++) {
                builder.append("0");
            }
            builder.append(fromNumberToBinary);

            for (int j = 0; j < 12; j++) {
                matrix[i][j] = String.valueOf(builder.charAt(j));
            }
        }

        int counter = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i].equals("1")) {
                    matrix[j][i] = "0";
                    counter++;
                }
            }
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (counter == 0) {
                    break;
                }
                matrix[j][i] = "1";
                counter--;
            }
        }

        StringBuilder builder = new StringBuilder();
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                builder.append(matrix[i][j]);
            }
            int number = Integer.parseInt(builder.toString(), 2);
            numbers.add(String.valueOf(number));
            builder = new StringBuilder();

        }

        String output = String.join(", ", numbers);
        System.out.println(output);


    }

}
