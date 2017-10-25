package Exersice5ObjectsClassesCollections;

import java.util.HashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        HashMap<String,Integer> minnerTask = new HashMap<>();

        String resource = "";
        int counter = 1;
        while (!input.equals("stop")){
            if (counter % 2 == 1){
                resource = input;
            }
            else {
                if (minnerTask.containsKey(resource)){
                    for (String s : minnerTask.keySet()) {
                        if (s.equals(resource)){
                            int newValue = minnerTask.get(resource) + Integer.parseInt(input);
                            minnerTask.put(resource,newValue);
                        }
                    }
                }
                else{
                    minnerTask.put(resource,Integer.parseInt(input));
                }
            }

            input = console.nextLine();
            counter++;
        }

        for (String s : minnerTask.keySet()) {
            System.out.println(s + " -> " + minnerTask.get(s));

        }
    }
}
