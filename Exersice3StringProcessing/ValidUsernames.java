package Exersice3StringProcessing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        String [] usernames = console.nextLine().split("[ \\\\/()]");

        List <String> validUsernames = new ArrayList<>();
        ArrayDeque <String> currentUsernames = new ArrayDeque<>();

        int biggestSum = 0;

        int lengthOfPrevious = 0;
        int counter = 0;
        Pattern pattern = Pattern.compile("\\b([A-Za-z][A-z\\d_]{2,24})");
        for (int i = 0; i < usernames.length; i++) {
            Matcher matcher = pattern.matcher(usernames[i]);

            if (matcher.find()){
                if (matcher.group().equals("")){
                    break;
                }
                int currentLength = matcher.group().length() + lengthOfPrevious;
                currentUsernames.add(matcher.group());
                if (currentLength > biggestSum && counter > 0){
                    validUsernames.clear();
                    validUsernames.addAll(currentUsernames);
                    biggestSum = currentLength;
                    lengthOfPrevious = matcher.group().length();
                    currentUsernames.poll();
                }
                else {
                    if (counter == 0){
                        lengthOfPrevious = matcher.group().length();
                        counter = 1;
                    }
                    else{
                        lengthOfPrevious = matcher.group().length();
                        currentUsernames.poll();
                    }
                }
            }
        }

        for (String validUsername : validUsernames) {
            System.out.println(validUsername);
        }
    }
}
