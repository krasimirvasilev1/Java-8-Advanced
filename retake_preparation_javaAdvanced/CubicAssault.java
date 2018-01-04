package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> armies = new LinkedHashMap<>();

        while(true){
            String input = console.readLine();

            if ("Count em all".equals(input)){
                break;
            }

            String[] regionColourAndAmount = input.split(" -> ");
            String region = regionColourAndAmount[0];
            String color = regionColourAndAmount[1];
            int amount = Integer.parseInt(regionColourAndAmount[2]);

            if (armies.containsKey(region)){
                armies.get(region).put(color , armies.get(region).get(color) + amount);
            }
            else{
                armies.put(region, new LinkedHashMap<>());
                armies.get(region).put("Black",0L);
                armies.get(region).put("Red",0L);
                armies.get(region).put("Green",0L);

                armies.get(region).put(color, armies.get(region).get(color) + amount);
            }
        }

        for (Map.Entry<String, Map<String, Long>> stringMapEntry : armies.entrySet()) {
            if (stringMapEntry.getValue().get("Green") >= 1_000_000){
                long greenMeteorsLeft = stringMapEntry.getValue().get("Green") % 1_000_000;
                long redMeteorsIncrease = stringMapEntry.getValue().get("Green") / 1_000_000;
                stringMapEntry.getValue().put("Green", greenMeteorsLeft);
                stringMapEntry.getValue().put("Red", stringMapEntry.getValue().get("Red") + redMeteorsIncrease);
            }
            if (stringMapEntry.getValue().get("Red") >= 1_000_000){
                long redMeteorsLeft = stringMapEntry.getValue().get("Red") % 1_000_000;
                long blackMeteorsIncrease = stringMapEntry.getValue().get("Red") / 1_000_000;
                stringMapEntry.getValue().put("Red", redMeteorsLeft);
                stringMapEntry.getValue().put("Black", stringMapEntry.getValue().get("Black") + blackMeteorsIncrease);
            }
        }

        armies.entrySet().stream().sorted((x,y) -> sortArmiesByRegion(x.getKey(),y.getKey(),x.getValue(),y.getValue()))
                .forEach(x -> {
                    System.out.println(x.getKey());
                    Map<String,Long> armiesInThisRegion = x.getValue();
                    armiesInThisRegion.entrySet().stream().sorted((a,b) -> sortedRegionArmies(a.getKey(),b.getKey(),a.getValue(),b.getValue()))
                            .forEach(y -> System.out.println("-> "+y.getKey()+" : "+ y.getValue()));
                });
    }

    private static int sortedRegionArmies(String key, String key1, Long value, Long value1) {
        int defeatedUnitsCompare = Long.compare(value1,value);
        if (defeatedUnitsCompare != 0){
            return defeatedUnitsCompare;
        }

        return key.compareTo(key1);
    }

    private static int sortArmiesByRegion(String key, String key1, Map<String, Long> value, Map<String, Long> value1) {
        int blackMeteorsCountCompare = Long.compare(value1.get("Black"),value.get("Black"));
        if (blackMeteorsCountCompare != 0){
            return blackMeteorsCountCompare;
        }
        int regionNameCompare = Integer.compare(key.length(),key1.length());
        if (regionNameCompare != 0){
            return regionNameCompare;
        }

        return key.compareTo(key1);
    }
}
