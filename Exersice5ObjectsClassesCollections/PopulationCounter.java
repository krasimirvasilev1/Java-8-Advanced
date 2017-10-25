package Exersice5ObjectsClassesCollections;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Long> countryAndPopulation = new LinkedHashMap<>();
        LinkedHashMap<String,LinkedList<TownAndPopulation>> countryAndCity = new LinkedHashMap<>();

        String report = console.readLine();
        while(!report.equals("report")){
            String [] input = report.split("\\|");
            String town = input[0];
            String country = input[1];
            Long population = Long.parseLong(input[2]);

            if (countryAndPopulation.isEmpty()){
                countryAndPopulation.put(country,population);
            }
            else{
                if (countryAndPopulation.containsKey(country)){
                    countryAndPopulation.put(country,countryAndPopulation.get(country) + population);
                }
                else{
                    countryAndPopulation.put(country,population);
                }
            }
            TownAndPopulation newInput = new TownAndPopulation();
            newInput.name = town;
            newInput.population = population;

            if (countryAndCity.isEmpty()){
                countryAndCity.put(country,new LinkedList<TownAndPopulation>());
                countryAndCity.get(country).add(newInput);
            }
            else{
                if (countryAndCity.containsKey(country)){
                    countryAndCity.get(country).add(newInput);
                }
                else{
                    countryAndCity.put(country,new LinkedList<TownAndPopulation>());
                    countryAndCity.get(country).add(newInput);
                }
            }

            report = console.readLine();
        }

        List<Map.Entry<String,Long>> list = new LinkedList<>(countryAndPopulation.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });



        for (Map.Entry<String,Long> item : list) {
            System.out.println(item.getKey() + " (total population: "+item.getValue()+")");
            
            List<TownAndPopulation> sortedList = new LinkedList<TownAndPopulation>(countryAndCity.get(item.getKey()));
            Collections.sort(sortedList, new Comparator<TownAndPopulation>() {
                @Override
                public int compare(TownAndPopulation o1, TownAndPopulation o2) {
                     return o2.population.compareTo(o1.population);
                }
            });

            for (TownAndPopulation townAndPopulation : sortedList) {
                System.out.println("=>"+townAndPopulation.name+": "+townAndPopulation.population);
            }
        }

    }
}
class TownAndPopulation {
    String name;
    Long population;
}
