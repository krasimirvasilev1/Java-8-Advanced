package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class CubicArtilery {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<LinkedList<Integer>> bunkers = new LinkedList<>();
        LinkedList<String> bunkersNames = new LinkedList<>();
        int maximumCapacityOfBunker = Integer.parseInt(console.readLine());


        ArrayDeque<List<Integer>> bunkersCheck = new ArrayDeque<>();
        while(true){
            String input = console.readLine();

            if ("Bunker Revision".equals(input)){
                break;
            }

            String[] specifiedInputPerLine = input.split("\\s+");
            for (int i = 0; i < specifiedInputPerLine.length; i++) {
                boolean itIsABunker = checkIfItIsABunker(specifiedInputPerLine[i]);
                if (itIsABunker){
                    bunkersNames.addLast(specifiedInputPerLine[i]);
                    bunkers.addLast(new LinkedList<>());
                }
                else {
                    while (true) {
                        if (bunkers.size() > 1) {
                            LinkedList<Integer> allWeaponsInBunker = bunkers.removeFirst();
                            String bunkerName = bunkersNames.removeFirst();
                            if (chechCurrBunkerFreeCapacity(allWeaponsInBunker) + Integer.parseInt(specifiedInputPerLine[i]) <= maximumCapacityOfBunker) {
                                allWeaponsInBunker.add(Integer.parseInt(specifiedInputPerLine[i]));
                                bunkers.addFirst(allWeaponsInBunker);
                                bunkersNames.addFirst(bunkerName);
                                break;
                            } else {
                                printTheBunker(bunkerName, allWeaponsInBunker);
                            }
                        } else {
                            if (!bunkers.isEmpty()) {
                                checkIfTheBunkerCanMakeSomeFreeSpace(Integer.parseInt(specifiedInputPerLine[i]), bunkers.get(0), maximumCapacityOfBunker);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printTheBunker(String bunkerName, LinkedList<Integer> bunkers) {
        StringBuilder builder = new StringBuilder();
        builder.append(bunkerName + " -> ");
        if (bunkers.isEmpty()){
            builder.append("Empty");
            System.out.println(builder.toString());
        }
        else {
            for (Integer bunkerWeapons : bunkers) {
                builder.append(bunkerWeapons + ", ");
            }
            System.out.println(builder.toString().substring(0,builder.length() - 2));
        }
    }

    private static boolean checkIfItIsABunker(String wordFromTheLine){
        for (int i = 0; i < wordFromTheLine.length(); i++) {
            if (Character.isDigit(wordFromTheLine.charAt(i))){
                return false;
            }
        }

        return true;
    }

    private static int chechCurrBunkerFreeCapacity(List<Integer> currBunker){
        int currCapacity = 0;
        for (int i = 0; i < currBunker.size(); i++) {
            currCapacity += currBunker.get(i);
        }

        return currCapacity;
    }

    private static void checkIfTheBunkerCanMakeSomeFreeSpace(int elementToAdd ,LinkedList<Integer> currBunker , int maximumCapacityOfBunker) {
        if (elementToAdd <= maximumCapacityOfBunker) {
            while (true) {
                if (elementToAdd + chechCurrBunkerFreeCapacity(currBunker) <= maximumCapacityOfBunker) {
                    currBunker.add(elementToAdd);
                    break;
                } else {
                    currBunker.removeFirst();
                }
            }
        }
    }
}
