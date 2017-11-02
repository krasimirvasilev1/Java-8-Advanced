package ExamJune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,Meteors> armies = new TreeMap<>();
        while(true){
            String input = console.readLine();
            if ("Count em all".equals(input)){
                break;
            }
            String [] commands = input.split(" -> ");
            String key = commands[0];
            String meteorsType = commands[1];
            String amountOfSoldiers = commands[2];

            if (armies.containsKey(key)){
                Meteors meteors = new Meteors();
                meteors.Black = armies.get(key).Black;
                meteors.Red = armies.get(key).Red;
                meteors.Green = armies.get(key).Green;

                if (meteorsType.equals("Green")){
                    meteors.Green = armies.get(key).Green + Integer.parseInt(amountOfSoldiers);
                    long meteorsGreen = meteors.Green;
                    if (meteors.Green >= 1000000){
                        meteors.Green = meteors.Green % 1000000;
                        meteors.Red = meteors.Red + meteorsGreen / 1000000;
                    }
                    if (meteors.Red >= 1000000){
                        long meteorsRed = meteors.Red;
                        meteors.Red = meteorsRed % 1000000;
                        meteors.Black = meteors.Black + meteorsRed / 1000000;
                    }
                }
                else if (meteorsType.equals("Red")){
                    meteors.Red = armies.get(key).Red + Integer.parseInt(amountOfSoldiers);
                    long meteorsRed = meteors.Red;
                    if (meteors.Red >= 1000000){
                        meteors.Red = meteorsRed % 1000000;
                        meteors.Black = meteors.Black + meteorsRed / 1000000;
                    }
                }
                else if (meteorsType.equals("Black")){
                    meteors.Black = armies.get(key).Black + Integer.parseInt(amountOfSoldiers);
                }

                armies.put(key,meteors);
            }

            else{
                armies.put(key,new Meteors());

                Meteors meteors = new Meteors();
                if (meteorsType.equals("Green")){
                    meteors.Green = Integer.parseInt(amountOfSoldiers);
                    long meteorsGreen = meteors.Green;
                    if (meteors.Green >= 1000000){
                        meteors.Green = meteors.Green % 1000000;
                        meteors.Red = meteors.Red + meteorsGreen / 1000000;
                    }
                    if (meteors.Red >= 1000000){
                        long meteorsRed = meteors.Red;
                        meteors.Red = meteorsRed % 1000000;
                        meteors.Black = meteors.Black + meteorsRed / 1000000;
                    }
                }
                else if (meteorsType.equals("Red")){
                    meteors.Red = Integer.parseInt(amountOfSoldiers);
                    long meteorsRed = meteors.Red;
                    if (meteors.Red >= 1000000){
                        meteors.Red = meteorsRed % 1000000;
                        meteors.Black = meteors.Black + meteorsRed / 1000000;
                    }
                }
                else if (meteorsType.equals("Black")){
                    meteors.Black = Integer.parseInt(amountOfSoldiers);
                }

                armies.put(key,meteors);
            }
        }
        Stream<Map.Entry<String,Meteors>> sortedArmies = armies.entrySet().stream().sorted((x,y) -> SortedArmies(x.getKey(),x.getValue(),y.getKey(),y.getValue()));
        sortedArmies.forEach(x -> {
            HashMap<String,Long> typesAndAmounts = new LinkedHashMap<>();
            typesAndAmounts.put("Black",x.getValue().Black);
            typesAndAmounts.put("Green",x.getValue().Green);
            typesAndAmounts.put("Red",x.getValue().Red);
            System.out.println(x.getKey());
            Stream<Map.Entry<String,Long>> sortedTypesAndAmounts = typesAndAmounts.entrySet().stream().sorted((a,b) -> SortedTypesAndAmpunts(a.getKey(),a.getValue(),b.getKey(),b.getValue()));
            sortedTypesAndAmounts.forEach(y -> System.out.println("-> "+y.getKey()+" : "+y.getValue()));
        });

    }

    private static int SortedTypesAndAmpunts(String key, Long value, String key1, Long value1) {
        int sortedByAmountOfDefeatedUnits = 0;
        Long amountOne = new Long(value);
        Long amountTwo = new Long(value1);
        sortedByAmountOfDefeatedUnits = amountTwo.compareTo(amountOne);
        if (sortedByAmountOfDefeatedUnits != 0){
            return  sortedByAmountOfDefeatedUnits;
        }
        else{
            int sortedAlphabetically = 0;
            sortedAlphabetically = key.compareTo(key1);
            return sortedAlphabetically;
        }
    }

    private static int SortedArmies(String key, Meteors value, String key1, Meteors value1) {
        int compareByBlackMeteors = 0;
        Long firstBlack = new Long(value.Black);
        Long secondBlack = new Long(value1.Black);
        compareByBlackMeteors = secondBlack.compareTo(firstBlack);
        if (compareByBlackMeteors != 0){
            return compareByBlackMeteors;
        }
        else {
            int compareByNames = 0;
            Long firstLength = new Long(key.length());
            Long secondLength = new Long(key1.length());
            compareByNames = firstLength.compareTo(secondLength);
            if (compareByNames != 0){
                return compareByNames;
            }
            else {
                int compareByNamesAlpha = 0;
                compareByNamesAlpha = key.compareTo(key1);
                return compareByNamesAlpha;
            }
        }
    }

}
class Meteors {
    long Black;
    long Red;
    long Green;
}
