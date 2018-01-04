package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class TheDarmaInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<Integer, String>> allPeople = new LinkedHashMap<>();
        allPeople.put("Hydra", new LinkedHashMap<>());
        allPeople.put("Arrow", new LinkedHashMap<>());
        allPeople.put("Flame", new LinkedHashMap<>());
        allPeople.put("Pearl", new LinkedHashMap<>());
        allPeople.put("Orchid", new LinkedHashMap<>());

        while (true) {
            String input = console.readLine();

            if ("Recruit".equals(input)) {
                break;
            }

            String[] commands = input.split(":");
            switch (commands[2]) {
                case "Hydra":
                    allPeople.get("Hydra").put(Integer.parseInt(commands[1]), commands[0]);
                    break;
                case "Arrow":
                    allPeople.get("Arrow").put(Integer.parseInt(commands[1]), commands[0]);
                    break;
                case "Flame":
                    allPeople.get("Flame").put(Integer.parseInt(commands[1]), commands[0]);
                    break;
                case "Pearl":
                    allPeople.get("Pearl").put(Integer.parseInt(commands[1]), commands[0]);
                    break;
                case "Orchid":
                    allPeople.get("Orchid").put(Integer.parseInt(commands[1]), commands[0]);
                    break;
            }
        }

        boolean stationOrNot = false;
        boolean notValidStation = false;

        String stationToOutput = null;
        StringBuilder builder = new StringBuilder();
        switch (console.readLine()) {
            case "Arrow":
                stationToOutput = "Arrow";
                stationOrNot = true;
                builder.append(String.format("The Arrow station: Development of defensive strategies, and Intelligence gathering.%n"));
                break;
            case "Hydra":
                stationToOutput = "Hydra";
                stationOrNot = true;
                builder.append(String.format("The Hydra station: Zoological Research.%n"));
                break;
            case "Flame":
                stationToOutput = "Flame";
                stationOrNot = true;
                builder.append(String.format("The Flame station: Communication.%n"));
                break;
            case "Pearl":
                stationToOutput = "Pearl";
                builder.append(String.format("The Pearl station: Psychological Research and/or Observation.%n"));
                stationOrNot = true;
                break;
            case "Orchid":
                stationToOutput = "Orchid";
                builder.append(String.format("The Orchid station: Space-time manipulation research, disguised as a Botanical station.%n"));
                stationOrNot = true;
                break;
            case "DHARMA Initiative":
                stationOrNot = false;
                break;
                default:
                    builder.append("DHARMA Initiative does not have such a station!");
                    notValidStation = true;
                    break;
        }

        if (!notValidStation){
            if (stationOrNot){
                if (allPeople.get(stationToOutput).size() == 0){
                    builder.append("No recruits.");
                }
                else{
                    allPeople.get(stationToOutput).entrySet().stream().sorted((x,y) -> SortByStation(x.getKey(),y.getKey(),x.getValue(),y.getValue()))
                            .forEach(x -> builder.append(String.format("###%s - %d%n",x.getValue(),x.getKey())));
                }
            }
            else{
                allPeople.entrySet().stream().sorted((x,y) -> sortByEverything(x.getKey(),y.getKey(),x.getValue(),y.getValue()))
                        .forEach(x -> builder.append(String.format("The %s has %d DHARMA recruits in it.%n",x.getKey(),x.getValue().size())));
            }
        }

        System.out.println(builder.toString());
    }

    private static int sortByEverything(String key, String key1, Map<Integer, String> value, Map<Integer, String> value1) {
        int compareByAmountOfRecruits = Integer.compare(value1.size(),value.size());

        if (compareByAmountOfRecruits != 0){
            return compareByAmountOfRecruits;
        }

        return key.compareTo(key1);
    }

    private static int SortByStation(Integer key, Integer key1, String value, String value1) {
        int sortBydescendingOrder = Integer.compare(key1 , key);

        return sortBydescendingOrder;
    }
}
