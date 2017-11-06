package AugustExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,LinkedHashMap<String,Integer>> allRegionsAndColours =  new LinkedHashMap<>();
        LinkedHashMap<String,Integer> allRegionsAndValues = new LinkedHashMap<>();

        while (true) {
            String input = console.readLine();
            if ("Icarus, Ignite!".equals(input)) {
                break;
            }
            String[] info = input.split(" ");
            if (info.length != 4){
                continue;
            }
            String regionName = info[1].substring(1, info[1].length() - 1);
            String colourName = info[2].substring(1, info[2].length() - 1);
            int amount = Integer.parseInt(info[3]);

            if (isRegionValid(regionName) && isColourValid(colourName)){
                if (allRegionsAndColours.containsKey(regionName)){

                    int currValueForRegions = allRegionsAndValues.get(regionName);
                    allRegionsAndValues.put(regionName,currValueForRegions + amount);

                   if (allRegionsAndColours.get(regionName).containsKey(colourName)){
                       int currValue = allRegionsAndColours.get(regionName).get(colourName);
                       allRegionsAndColours.get(regionName).put(colourName,currValue + amount);
                   }
                   else{
                        allRegionsAndColours.get(regionName).put(colourName, amount);
                   }
                }
                else{
                    allRegionsAndColours.put(regionName, new LinkedHashMap<>());
                    allRegionsAndColours.get(regionName).put(colourName,amount);

                    allRegionsAndValues.put(regionName,amount);
                }
            }

        }

        Stream<Map.Entry<String,Integer>> sortedRegionsByAmount = allRegionsAndValues.entrySet().stream().sorted((x,y) -> SortedByAmountThenAlphabetically(x.getKey(),y.getKey(),x.getValue(),y.getValue()));
        sortedRegionsByAmount.forEach(x -> {
            Stream<Map.Entry<String,Integer>> sortedRegionsAndColours = allRegionsAndColours.get(x.getKey()).entrySet().stream().sorted((a,b) -> MainMapSortedByAmountThenAlphabetically(a.getKey(),b.getKey(),a.getValue(),b.getValue()));
            System.out.println(x.getKey());
            sortedRegionsAndColours.forEach(y -> System.out.println("*--"+ y.getKey()+" | "+y.getValue()));
        });
    }

    private static int MainMapSortedByAmountThenAlphabetically(String akey, String bkey, Integer avalue, Integer bvalue) {
        int compareByValues = 0;
        Integer a = new Integer(avalue);
        Integer b = new Integer(bvalue);
        compareByValues = a.compareTo(b);
        if (compareByValues != 0){
            return compareByValues;
        }
        else{
            return akey.compareTo(bkey);
        }
    }

    private static int SortedByAmountThenAlphabetically(String xKey,String yKey,Integer xValue,Integer yValue) {
        int compareByValues = 0;
        Integer a = new Integer(xValue);
        Integer b = new Integer(yValue);
        compareByValues = b.compareTo(a);
        if (compareByValues != 0){
            return compareByValues;
        }
        else{
            return xKey.compareTo(yKey);
        }
    }


    private static boolean isColourValid(String colourName) {
        for (int i = 0; i < colourName.length(); i++) {
            if (!Character.isDigit(colourName.charAt(i)) && !Character.isLetter(colourName.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean isRegionValid(String regionName) {
        boolean startsWithUpperCase = false;
        boolean allSymbolsAreLowerCase = true;
        if (String.valueOf(regionName.charAt(0)).equals(String.valueOf(regionName.charAt(0)).toUpperCase())) {
            startsWithUpperCase = true;
        }
        for (int i = 1; i < regionName.length(); i++) {
            if (!String.valueOf(regionName.charAt(i)).equals(String.valueOf(regionName.charAt(i)).toLowerCase())) {
                allSymbolsAreLowerCase = false;
            }
        }

        if (allSymbolsAreLowerCase && startsWithUpperCase) {
            return true;
        } else {
            return false;
        }
    }
}
