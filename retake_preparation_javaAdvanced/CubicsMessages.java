package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicsMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> validMessages = new LinkedHashMap<>();

        while (true){
            String inputLine = console.readLine();

            if ("Over!".equals(inputLine)){
                break;
            }

            int numberOfAlphabeticalCharacters = Integer.parseInt(console.readLine());

            Pattern pattern = Pattern.compile("^(?<digitsBefore>[0-9]+)(?<message>[a-zA-Z]{"+numberOfAlphabeticalCharacters+"})(?<digitsAfter>[^a-zA-Z]*)$");
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()){
                validMessages.put(matcher.group("message"),matcher.group());
            }
        }

        for (Map.Entry<String, String> stringStringEntry : validMessages.entrySet()) {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(stringStringEntry.getValue());

            StringBuilder decriptedMessages = new StringBuilder();

            while(matcher.find()){
                int matchIndex = Integer.parseInt(matcher.group());
                if (matchIndex >= 0 && matchIndex < stringStringEntry.getKey().length()){
                    decriptedMessages.append(stringStringEntry.getKey().charAt(matchIndex));
                }
                else{
                    decriptedMessages.append(" ");
                }
            }

            System.out.println(stringStringEntry.getKey() + " == "+ decriptedMessages.toString());
        }
    }
}
