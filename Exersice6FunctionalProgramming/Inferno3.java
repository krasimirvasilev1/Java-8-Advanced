package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Inferno3 {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> gemsPower = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        List<String> commands = new ArrayList<>();

        LinkedHashSet <Integer> numbersToRemove = new LinkedHashSet<>();
        List<Integer> gemsToBePrinted = new ArrayList<>();
        while(true){
            String input = console.readLine();
            if (input.equals("Forge")){
                break;
            }

            String [] task = input.split(";");
            String excludeOrReverse = task[0];
            String doSomethingWithSum = task[1];
            int sumToCheck = Integer.parseInt(task[2]);

            if (excludeOrReverse.equals("Exclude")){
                commands.add(input);
            }
            else if (excludeOrReverse.equals("Reverse")){
                for (String command : commands) {
                  String [] arrayOfCommand = command.split(";");
                  String doSomethingWithSumCommand = arrayOfCommand[1];
                  int sumToCheckCommand = Integer.parseInt(arrayOfCommand[2]);

                  if (doSomethingWithSum.equals(doSomethingWithSumCommand) && sumToCheck == sumToCheckCommand){
                      commands.remove(command);
                      break;
                  }
                }
            }
        }

        for (String command : commands) {
            String[] arrayOfCommand = command.split(";");
            String doSomethingWithSumCommand = arrayOfCommand[1];
            long sumToCheckCommand = Long.parseLong(arrayOfCommand[2]);
            for (int i = 0; i < gemsPower.size(); i++) {
                long sum =0;
                if (doSomethingWithSumCommand.equals("Sum Left")) {
                    if (i == 0 && sumToCheckCommand == gemsPower.get(i)) {
                        numbersToRemove.add(i);
                    }
                    else if (i != 0){
                        sum += gemsPower.get(i) + gemsPower.get(i - 1);
                        if (sum == sumToCheckCommand){
                            numbersToRemove.add(i);
                        }
                    }
                }
                else if (doSomethingWithSumCommand.equals("Sum Right")){
                    if (i == gemsPower.size() - 1 && sumToCheckCommand == gemsPower.get(i)) {
                        numbersToRemove.add(i);
                    }
                    else if (i != gemsPower.size() - 1){
                        sum += gemsPower.get(i) + gemsPower.get(i + 1);
                        if (sum == sumToCheckCommand){
                            numbersToRemove.add(i);
                        }
                    }
                }
                else if (doSomethingWithSumCommand.equals("Sum Left Right")){
                    if (i == 0 && gemsPower.size() == 1 &&gemsPower.get(i) == sumToCheckCommand){
                        numbersToRemove.add(i);
                    }
                    else if (i == 0){
                        sum += gemsPower.get(i) + gemsPower.get(i + 1);
                        if (sum == sumToCheckCommand){
                            numbersToRemove.add(i);
                        }
                    }
                    else if (i == gemsPower.size() - 1){
                        sum += gemsPower.get(i) + gemsPower.get(i - 1);
                        if (sum == sumToCheckCommand){
                            numbersToRemove.add(i);
                        }
                    }
                    else {
                        sum += gemsPower.get(i) + gemsPower.get(i - 1) + gemsPower.get(i + 1);
                        if (sum == sumToCheckCommand){
                            numbersToRemove.add(i);
                        }
                    }
                }
            }
        }

                for (int i = 0; i < gemsPower.size(); i++) {
                    boolean weDontNeedThis = false;
                    for (int integer : numbersToRemove) {
                    if (integer == i){
                        weDontNeedThis = true;
                        break;
                    }
                }
                if (!weDontNeedThis){
                    gemsToBePrinted.add(gemsPower.get(i));
                }
            }

        for (Integer integer : gemsToBePrinted) {
            System.out.print(integer + " ");
        }
        }

        }
