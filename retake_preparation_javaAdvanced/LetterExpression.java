package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input = console.readLine();
        List<Character> symbols = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        String currNumber = "";
        String sequenceOfLetters = "";
        int output = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))){
                if (!sequenceOfLetters.isEmpty()){
                    if (sequenceOfLetters.length() % 2 == 0){
                        symbols.add('+');
                    }
                    else {
                        symbols.add('-');
                    }
                    sequenceOfLetters = "";
                }
                currNumber += input.charAt(i);
            }
            else{
                if (sequenceOfLetters.isEmpty()){
                    numbers.add(Integer.parseInt(currNumber));
                    currNumber = "";
                }
                sequenceOfLetters += input.charAt(i);
            }
        }

        if (!currNumber.isEmpty()){
            numbers.add(Integer.parseInt(currNumber));
        }
        output = numbers.get(0);

        if (numbers.size() != 1){
            for (int i = 1; i < numbers.size(); i++) {
                if (symbols.get(i - 1).equals('+')){
                    output += numbers.get(i);
                }
                else{
                    output -= numbers.get(i);
                }
            }
        }

        System.out.println(output);
    }
}
