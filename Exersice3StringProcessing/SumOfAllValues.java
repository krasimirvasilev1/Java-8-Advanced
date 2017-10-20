package Exersice3StringProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String keyStrings = console.nextLine();
        StringBuilder textString = new StringBuilder(console.nextLine());
        String startsWith = "";
        String endsWith = "";

        double sumOfAllValues = 0;
        boolean foundedKeys = false;
        Pattern patternKeys = Pattern.compile("^(?<startKey>[A-Za-z_]+)([0-9].*[0-9])(?<endKey>[A-Za-z_]+)$");
        Matcher matcherKeys = patternKeys.matcher(keyStrings);

        if (matcherKeys.find()){
            startsWith = matcherKeys.group("startKey");
            endsWith = matcherKeys.group("endKey");
            foundedKeys = true;
        }
        else{
            System.out.println("<p>A key is missing</p>");
        }

            Pattern pattern = Pattern.compile("(?<=(" + startsWith + "))(?<target>[0-9]+\\.?[0-9]+)(?=(" + endsWith + "))");
            Matcher matcher = pattern.matcher(textString);

            while (matcher.find()) {
                sumOfAllValues += Double.parseDouble(matcher.group("target"));
            }


        if (sumOfAllValues == 0 && foundedKeys){
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
        else if (sumOfAllValues != 0 && foundedKeys){
            if (sumOfAllValues % (int)sumOfAllValues == 0){
                System.out.println("<p>The total value is: <em>"+(int)sumOfAllValues+"</em></p>");
            }
            else{
                System.out.printf("<p>The total value is: <em>"+"%.2f"+"</em></p>",sumOfAllValues);
            }

        }
        }
    }
