package Exersice2Matrix;

import java.util.List;
import java.util.Scanner;

public class TerroristWin {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String text = console.nextLine();

        String newText = "";
        int newTextCurrentIndex = 0;
        int firstIndex = 0;
        boolean firstLine = false;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '|' && !firstLine){
                firstIndex = i + 1;
                firstLine = true;
            }
            else if (text.charAt(i) == '|' && firstLine){
                String substringedText = text.substring(firstIndex,i);

                int sumOfTheBomb = 0;
                for (int j = 0; j < substringedText.length(); j++) {
                    sumOfTheBomb += substringedText.charAt(j);
                }

                sumOfTheBomb = sumOfTheBomb % 10;

                for (int j = newTextCurrentIndex; j < i + 1 + sumOfTheBomb ; j++) {
                    if (firstIndex - sumOfTheBomb < 0 || i + 1 + sumOfTheBomb > text.length() - 1){
                        continue;
                    }
                    if (j >= firstIndex - sumOfTheBomb - 1 && j <= i + 1 + sumOfTheBomb){
                        newTextCurrentIndex++;
                        newText += '.';
                    }
                    else{
                        newTextCurrentIndex++;
                        newText += text.charAt(j);
                    }
                }
                firstIndex = 0;
                firstLine = false;
            }
        }

        if (newText.length() == text.length()){
            System.out.println(newText);
        }
        else{
            System.out.println(newText + text.substring(newText.length(),text.length()));
        }


    }
}
