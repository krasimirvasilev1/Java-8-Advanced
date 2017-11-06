package ExamActualSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EarthQuake {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int numberOfQuakes = Integer.parseInt(console.readLine());
        ArrayDeque<ArrayList<String>> allQuakes = new ArrayDeque<>();

        List<String> output = new ArrayList<>();
        for (int i = 0; i < numberOfQuakes; i++) {
            ArrayList<String> newInput = new ArrayList<>(Arrays.asList(console.readLine().split(" ")));
            allQuakes.offer(newInput);
        }

        while (!allQuakes.isEmpty()) {
            ArrayList<String> currSequence = allQuakes.poll();
            ArrayList<String> listToBeAddedLast = new ArrayList<>();

            if (currSequence.size() == 1) {
                output.add(currSequence.get(0));
                continue;
            }
            else {
                int wave = Integer.parseInt(currSequence.get(0));
                for (int i = 1; i < currSequence.size(); i++) {
                    if(wave < Integer.parseInt(currSequence.get(i))){
                        listToBeAddedLast = new ArrayList<>(currSequence.subList(i,currSequence.size()));
                        allQuakes.offer(listToBeAddedLast);
                        break;
                    }
                }
                output.add(String.valueOf(wave));
            }
        }

        System.out.println(output.size());
        String listAsString = String.join(" ",output);
        System.out.println(listAsString);
    }
}
