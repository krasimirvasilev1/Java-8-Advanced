package ExamMay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(console.readLine());
        String numberToBinary = Integer.toBinaryString(number);
        StringBuilder builder = new StringBuilder();
        int diff = 19 - numberToBinary.length();

        for (int i = 0; i < diff; i++) {
            builder.append("0");
        }
        builder.append(numberToBinary);

        int indexToStop = Integer.parseInt(console.readLine());
        String numberOnThatIndex = "";
        int counter = 0;
        for (int i = builder.length() - 1; i >= 0; i--) {
            if (counter == indexToStop){
                numberOnThatIndex = String.valueOf(builder.toString().charAt(i));
                builder.deleteCharAt(i);
            }
            counter++;
        }
        int numberOfTimesToRotate = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfTimesToRotate; i++) {

            char currChar = builder.charAt(0);
            for (int j = 1; j < builder.length(); j++) {
                char replaceChar = builder.charAt(j);
                builder.setCharAt(j, currChar);
                currChar = replaceChar;
            }
            builder.setCharAt(0, currChar);

        }

        int positionToBeAdded = builder.length() - 1 - (indexToStop - 1);
        builder.insert(positionToBeAdded,numberOnThatIndex);


        int numberToBePrinted = Integer.parseInt(builder.toString(),2);
        System.out.println(numberToBePrinted);
    }
}
