package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Map<String,Integer>> regions = new HashMap<>();

        while(true){
            String input = console.readLine();
            if ("Icarus, Ignite!".equalsIgnoreCase(input)){
                break;
            }
            String [] commands = input.split(" ");
            Pattern patternRegion = Pattern.compile("<[A-Z][a-z]+>");
            Pattern patternColor = Pattern.compile("<[A-Za-z0-9]+>");

            if (commands.length == 4) {

                Matcher matcher = patternRegion.matcher(commands[1]);
                Matcher matcher1 = patternColor.matcher(commands[2]);

                if (matcher.find() && matcher1.find()) {
                    String region = matcher.group().substring(1,matcher.group().length() - 1);
                    String color = matcher1.group().substring(1, matcher1.group().length() - 1);
                    int amountRoses = Integer.parseInt(commands[3]);

                    if (regions.containsKey(region)) {
                        if (regions.get(region).containsKey(color)) {
                            regions.get(region).put(color, regions.get(region).get(color) + amountRoses);
                        } else {
                            regions.get(region).put(color, amountRoses);
                        }
                    } else {
                        regions.put(region, new LinkedHashMap<>());
                        regions.get(region).put(color, amountRoses);
                    }
                }
            }
        }

        regions.entrySet().stream().sorted((x,y) -> OrderRosesRegions(x.getKey(),y.getKey(),x.getValue(),y.getValue()))
                .forEach(x -> {
                        System.out.println(x.getKey());
                        x.getValue().entrySet().stream().sorted((a,b) -> OrderColors(a.getKey(),b.getKey(),a.getValue(),b.getValue()))
                                .forEach(y -> System.out.println("*--"+ y.getKey()+" | "+ y.getValue()));
                    });
    }

    private static int OrderColors(String key, String key1, Integer value, Integer value1) {
        int compareRosesCount =  Integer.compare(value,value1);
        if (compareRosesCount != 0){
            return compareRosesCount;
        }

        return key.compareTo(key1);
    }

    private static int OrderRosesRegions(String key, String key1, Map<String, Integer> value, Map<String, Integer> value1) {
        int compareRosesCount =  Long.compare(value1.entrySet().stream().mapToLong(Map.Entry::getValue).sum(),value.entrySet().stream().mapToLong(Map.Entry::getValue).sum());
        if (compareRosesCount != 0){
            return compareRosesCount;
        }

        return key.compareTo(key1);
    }
}
