package ExamActualSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String regEx = "(?<mark>[,_])(?<letters>[a-zA-Z]+)(?<number>[0-9])";
        Pattern pattern = Pattern.compile(regEx);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        while (true) {
            StringBuilder input = new StringBuilder(console.readLine());
            input = decryptInputWithOldValues(input, map);
            if (input.toString().equals("Ascend")) {
                break;
            }
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String mark = matcher.group("mark");
                String letters = matcher.group("letters");
                String number = matcher.group("number");

                StringBuilder textToReplace = new StringBuilder();

                if (mark.equals(",")) {
                    for (int i = 0; i < letters.length(); i++) {
                        int asciiNumber = (int) letters.charAt(i) + Integer.parseInt(number);
                        textToReplace.append((char) asciiNumber);
                    }
                } else {
                    for (int i = 0; i < letters.length(); i++) {
                        int asciiNumber = (int) letters.charAt(i) - Integer.parseInt(number);
                        textToReplace.append((char) asciiNumber);
                    }
                }
                map.put(matcher.group(), textToReplace.toString());
                input = new StringBuilder(input.toString().replaceAll(matcher.group(), textToReplace.toString()));
            }
            System.out.println(input.toString());
        }
    }
    private static StringBuilder decryptInputWithOldValues(StringBuilder input, LinkedHashMap<String, String> map) {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            input = new StringBuilder(input.toString().replaceAll(stringStringEntry.getKey(),stringStringEntry.getValue()));
        }
        return input;
    }
}