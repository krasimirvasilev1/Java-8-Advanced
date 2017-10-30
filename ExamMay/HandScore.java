package ExamMay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> cards = Arrays.stream(console.readLine().split(" ")).collect(Collectors.toList());

        int allSum = 0;
        String previousType = "";
        int currSumToBeAdded = 0;
        int countOfConsecutiveSameEl = 1;
        for (int i = 0; i < cards.size(); i++) {
            String currValueString = String.valueOf(cards.get(i).charAt(0));
            String currTypeString = String.valueOf(cards.get(i).charAt(1));

            int currValue = 0;
            String currType = String.valueOf(cards.get(i).charAt(1));
            switch (currValueString) {
                case "1":
                    currValue = 10;
                    currType = String.valueOf(cards.get(i).charAt(2));
                    break;
                case "J":
                    currValue = 12;
                    break;
                case "Q":
                    currValue = 13;
                    break;
                case "K":
                    currValue = 14;
                    break;
                case "A":
                    currValue = 15;
                    break;
                default:
                    currValue = Integer.parseInt(currValueString);
                    break;
            }
            if (currType.equals(previousType)) {
                countOfConsecutiveSameEl++;
                currSumToBeAdded += currValue;
            } else {
                if (countOfConsecutiveSameEl > 1) {
                    allSum += currSumToBeAdded * countOfConsecutiveSameEl;
                    countOfConsecutiveSameEl = 1;
                    currSumToBeAdded = currValue;
                    previousType = currType;
                } else {
                    previousType = currType;
                    allSum += currSumToBeAdded;
                    currSumToBeAdded = currValue;
                }

            }
        }
        if (countOfConsecutiveSameEl > 1){
            System.out.println(allSum + currSumToBeAdded * countOfConsecutiveSameEl);
        }
        else{
            System.out.println(allSum + currSumToBeAdded);
        }

    }
}
