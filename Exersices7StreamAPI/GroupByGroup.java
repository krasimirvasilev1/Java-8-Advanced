package Exersices7StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,List<String>> sortedOutput = new LinkedHashMap<>();
        List<String> allNames = new ArrayList<>();
        while(true){
            String input = console.readLine();

            if (input.equals("END")){
                break;
            }

            String[] nameAndGroup = input.split(" ");
            String name = nameAndGroup[0]+" "+nameAndGroup[1];
            String group = nameAndGroup[2];

            Person person = new Person();
            person.name = name;
            person.group = group;

            allNames.add(group);
            if (sortedOutput.containsKey(person.group)){
                sortedOutput.get(person.group).add(person.name);
            }
            else{
                sortedOutput.put(person.group,new LinkedList<>());
                sortedOutput.get(person.group).add(person.name);
            }
        }

        Stream<Map.Entry<String,List<String>>> sortedGroups = sortedOutput.entrySet().stream().sorted(Comparator.comparingInt(x -> Integer.parseInt(x.getKey())));
        sortedGroups.forEach(x -> {
            System.out.print(x.getKey() + " - " +String.join(", ",x.getValue()));
            System.out.println();
        });
    }
}
class Person{
    String name;
    String group;
}
