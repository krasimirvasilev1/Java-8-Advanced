package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stones = new ArrayDeque<>();
        LinkedList<Integer> gold = new LinkedList<>();

        String [] numbers = console.readLine().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            stones.add(Integer.parseInt(numbers[i]));
        }

        while(true){
            String input = console.readLine();
            if (input.equals("Revision")){
                break;
            }
            String [] commands = input.split(" ");
            String firstCommand = commands[0];
            String secondComands = commands[1];
            String thirdCommand = commands[2];

            if (firstCommand.equals("Apply") && secondComands.equals("acid")){
                int numberOfStonesAffected = Integer.parseInt(thirdCommand);
                for (int i = 0; i < numberOfStonesAffected; i++) {
                    if (stones.isEmpty()) {
                        break;
                    }
                    int currStone = stones.poll();
                    if (currStone <= 0) {
                        gold.add(currStone);
                    }
                    else {
                        currStone -= 1;
                        if (currStone <= 0){
                            gold.add(currStone);
                        }
                        else{
                            stones.add(currStone);
                        }

                    }
                }
            }
            else if (firstCommand.equals("Air") && secondComands.equals("leak")){
                if (!gold.isEmpty()){
                    int valueOfTheStone = Integer.parseInt(thirdCommand);
                    gold.removeLast();
                    stones.add(valueOfTheStone);
                }
            }
        }
        for (Integer stone : stones) {
            System.out.print(stone + " ");
        }
        System.out.println();
        System.out.println(gold.size());

    }
}
