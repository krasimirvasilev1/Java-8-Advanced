package ExamJuneSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Integer numberOfLines = Integer.parseInt(console.readLine());
        List<String> allLinesOfInput = new LinkedList<>();

        List<String> allMessages = new LinkedList<>();
        ArrayDeque<String> allNames = new ArrayDeque<>();
         for (int i = 0; i < numberOfLines; i++) {
            allLinesOfInput.add(console.readLine());
        }

        String prefixNames = console.readLine();
        String prefixMessages = console.readLine();

        String regexNames = "(?<="+prefixNames+")(?<targetNames>[a-zA-Z]{"+prefixNames.length()+"})(?:[^a-zA-Z]+)";
        String regexMessages = "(?<="+prefixMessages+")(?<targetMessages>[a-zA-Z0-9]{"+prefixMessages.length()+"})(?:[^a-zA-Z0-9]+)";

        Pattern patternNames = Pattern.compile(regexNames);
        Pattern patternMessages = Pattern.compile(regexMessages);
        for (String s : allLinesOfInput) {

            Matcher matcherMessages = patternMessages.matcher(s);
            Matcher matcherNames = patternNames.matcher(s);

            while(matcherMessages.find()){
            allMessages.add(matcherMessages.group("targetMessages"));
            }
            while(matcherNames.find()){
                allNames.add(matcherNames.group("targetNames"));
            }
        }

        int [] indexesToCheck = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int counter = 0;
        String currJedi = "";
        int indexOfFirstJedi = 0;
            for (int i = 0; i < indexesToCheck.length; i++) {
                    if (indexesToCheck[i] - 1 >= 0 && indexesToCheck[i] - 1 <= allMessages.size() - 1) {
                        if (!allNames.isEmpty() && currJedi.equals("")){
                            currJedi = allNames.poll();
                            int index = indexesToCheck[i] - 1;
                            if(counter == 0){
                                indexOfFirstJedi = index;
                            }
                            System.out.println(currJedi+" - "+allMessages.get(index));
                            currJedi = "";
                            counter++;
                        }
                        else if (!allNames.isEmpty() && !currJedi.equals("")){
                            int index = indexesToCheck[i] - 1;
                            if(counter == 0){
                                indexOfFirstJedi = index;
                            }
                            System.out.println(currJedi+" - "+allMessages.get(index));
                            counter++;
                        }
                    }
                    else{
                        if (!currJedi.equals("")){
                            if (!allNames.isEmpty()){
                                String thisJedi = allNames.poll();
                                if (allMessages.size() > indexOfFirstJedi + 1)
                                System.out.println(thisJedi + " - "+indexOfFirstJedi + 1);
                            }
                        }
                        if (!allNames.isEmpty() && currJedi.equals("")){
                            currJedi = allNames.poll();
                        }
                }
            }
        }
    }
