package ExamJune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(console.readLine());
        StringBuilder allText = new StringBuilder();
        while(true){
            String input = console.readLine();
            if ("Bunker Revision".equals(input)){
                break;
            }
            allText.append(input+" ");
        }

        String [] allCommands = allText.toString().split(" ");
        List<String> allOtherBunkers = new LinkedList<>();
        List<String> allNumbersPerBunker = new LinkedList<>();

        String currBunker = "";
        int capacityOfBunker = 0;
        for (int i = 0; i < allCommands.length; i++) {

            if (isCharacter(allCommands[i]) && currBunker.equals("")){
                currBunker = allCommands[i];
            }
            else if (isCharacter(allCommands[i]) && !currBunker.equals("")){
                allOtherBunkers.add(allCommands[i]);
            }

            if (!isCharacter(allCommands[i]) && !currBunker.equals("")){
                int currNumber = Integer.parseInt(allCommands[i]);
                if (currNumber > capacity){
                    continue;
                }
                else if (currNumber > (capacity - capacityOfBunker)){
                    if (allOtherBunkers.isEmpty()){
                        LinkedList<String> allNumbersPerBunkerCopy = new LinkedList<>(allNumbersPerBunker);
                        while(!allNumbersPerBunkerCopy.isEmpty()){
                            allNumbersPerBunkerCopy.removeFirst();
                            int rest = capacity;
                            for (String integer : allNumbersPerBunkerCopy) {
                                rest-=Integer.parseInt(integer);
                            }
                            if (rest >= currNumber){
                                allNumbersPerBunkerCopy.addLast(String.valueOf(currNumber));
                                allNumbersPerBunker = allNumbersPerBunkerCopy;
                                break;
                            }
                        }
                        System.out.println(currBunker+" -> "+String.join(", ",allNumbersPerBunker));
                        allNumbersPerBunker.clear();
                        currBunker = "";
                        capacityOfBunker = 0;
                    }
                    else {
                        System.out.println(currBunker+" -> "+String.join(", ",allNumbersPerBunker));
                        currBunker = allOtherBunkers.get(0);
                        allOtherBunkers.remove(0);
                        capacityOfBunker = currNumber;
                        allNumbersPerBunker.clear();
                        allNumbersPerBunker.add(String.valueOf(currNumber));
                    }
                }
                else{
                    capacityOfBunker += currNumber;
                    allNumbersPerBunker.add(String.valueOf(currNumber));
                }
            }
        }
        if (capacityOfBunker == 0 && !currBunker.equals("")){
            System.out.println(currBunker + " -> Empty");
        }
    }

    private static boolean isCharacter(String allCommand) {
        boolean isLetter = false;

                if (Character.isLetter(allCommand.charAt(0))){
                   isLetter =  true;
                }
        return isLetter;
    }
}
