package ExamJune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicsMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^(?<allmatch>\\d+(?<match>[a-zA-Z]+)([^a-zA-Z]+)?)$";
        String allDigits = "\\d";
        String currText = "";
        String currSentence = "";
        List<String> allValidWords = new LinkedList<>();
        List<String> allValidSentences = new LinkedList<>();
        while (true) {
            String input = console.readLine();
            if (input.equals("Over!")){
                break;
            }

            if (isADigit(input)){
                if (Integer.parseInt(input) == currText.length()){
                    allValidWords.add(currText);
                    allValidSentences.add(currSentence);
                }
            }
            else{
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()){
                currText = matcher.group("match");
                currSentence = matcher.group("allmatch");
                }
                else{
                    currText = "";
                    currSentence = "";
                }
            }
        }

        for (int i = 0; i < allValidWords.size(); i++) {
            Pattern pattern = Pattern.compile(allDigits);
            Matcher matcher = pattern.matcher(allValidSentences.get(i));
            System.out.print(allValidWords.get(i) + " == ");
            while(matcher.find()){
                int number = Integer.parseInt(matcher.group());
                if (number >= 0 && number < allValidWords.get(i).length()){
                    System.out.print(allValidWords.get(i).charAt(number));
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isADigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
