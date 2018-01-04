package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = new LinkedList<>();

        List<String> jedies = new LinkedList<>();
        List<String> messages = new LinkedList<>();

        int numberOfMessages = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfMessages; i++) {
            String text = console.readLine();
            input.add(text);
        }

        String first = console.readLine();
        String second = console.readLine();

        Pattern firstPattern = Pattern.compile(first + "(?<jedieGroup>[a-zA-Z]" + "{" + first.length() + "})");
        Pattern secondPattern = Pattern.compile(second + "(?<messageGroup>[a-zA-Z0-9]" + "{" + second.length() + "})");

        for (String anInput1 : input) {
            Matcher firstMatcher = firstPattern.matcher(anInput1);
            while (firstMatcher.find()) {
                jedies.add(firstMatcher.group("jedieGroup"));
            }
        }

        for (String anInput : input) {
            Matcher secondMatcher = secondPattern.matcher(anInput);
            while (secondMatcher.find()) {
                messages.add(secondMatcher.group("messageGroup"));
            }
        }

        StringBuilder builder = new StringBuilder();
        int[] indexesOfMessages = Arrays.stream(console.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        int counterForMessages = 0;
        boolean noMoreValidMessages = false;
        boolean isThisTheFirstJedi = true;
        int messageAfterTheFirstJediIndex = 0;
        for (int i = 0; i < jedies.size(); i++) {
            if (counterForMessages != indexesOfMessages.length) {
                if (indexesOfMessages[counterForMessages] - 1 < messages.size() && indexesOfMessages[counterForMessages] - 1 >= 0) {
                    if (isThisTheFirstJedi) {
                        isThisTheFirstJedi = false;
                        messageAfterTheFirstJediIndex = indexesOfMessages[counterForMessages];
                    }
                    builder.append(jedies.get(i) + " - " + messages.get(indexesOfMessages[counterForMessages] - 1));
                    builder.append(System.lineSeparator());
                    counterForMessages++;
                } else {
                    if (noMoreValidMessages) {
                        builder.append(jedies.get(i) + " - " + messages.get(indexesOfMessages[messageAfterTheFirstJediIndex]));
                        builder.append(System.lineSeparator());
                    } else {
                        boolean messageAssignToJedi = false;
                        for (int j = counterForMessages; j < indexesOfMessages.length; j++) {
                            if (indexesOfMessages[j] - 1 < messages.size() && indexesOfMessages[j] - 1 >= 0) {
                                builder.append(jedies.get(i) + " - " + messages.get(indexesOfMessages[j] - 1));
                                builder.append(System.lineSeparator());
                                counterForMessages++;
                                messageAssignToJedi = true;
                                break;
                            }
                        }
                        if (!messageAssignToJedi) {
                            noMoreValidMessages = true;
                        }
                    }
                }
            }
        }

        System.out.println(builder.toString());
    }
}
