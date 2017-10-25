package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> legendaryMaterials = new HashMap<>();
        HashMap<String, Integer> commonMaterials = new HashMap<>();

        legendaryMaterials.put("fragments",0);
        legendaryMaterials.put("shards",0);
        legendaryMaterials.put("motes",0);

        String materialType = "";
        boolean legendaryItemTaken = false;
        int quantity = 0;
        while(!legendaryItemTaken){
            String [] input = console.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 0){
                    quantity = Integer.parseInt(input[i]);
                }
                else if (i % 2 == 1) {
                    String material = input[i].toLowerCase();
                    if (material.equals("motes") || material.equals("shards")
                            || material.equals("fragments")) {
                        if (legendaryMaterials.containsKey(material)) {
                            legendaryMaterials.put(material,legendaryMaterials.get(material) + quantity);
                            if (legendaryMaterials.get(material) >= 250){
                                legendaryItemTaken = true;
                                materialType = material;
                                legendaryMaterials.put(material,legendaryMaterials.get(material) - 250);
                                break;
                            }
                        }
                        else{
                            legendaryMaterials.put(material,quantity);
                            if (legendaryMaterials.get(material) >= 250){
                                legendaryItemTaken = true;
                                materialType = material;
                                legendaryMaterials.put(material,legendaryMaterials.get(material) - 250);
                                break;
                            }
                        }
                    }
                    else{
                        if (commonMaterials.containsKey(material)){
                            commonMaterials.put(material,commonMaterials.get(material) + quantity);
                        }
                        else{
                            commonMaterials.put(material,quantity);
                        }
                    }
                    quantity = 0;
                }
            }
        }

        switch (materialType){
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
        }
        LinkedList<Map.Entry<String,Integer>> orderedLegendaryList = new LinkedList<>(legendaryMaterials.entrySet());
        Collections.sort(orderedLegendaryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer numOfMaterialsFirst = o1.getValue();
                Integer numOfMaterialsSecond = o2.getValue();
                int compareTwoMaterials = numOfMaterialsSecond.compareTo(numOfMaterialsFirst);
                if (compareTwoMaterials != 0){
                    return compareTwoMaterials;
                }
                else{
                    String nameFirstMaterial = o1.getKey();
                    String nameSecondMaterial = o2.getKey();
                    return nameFirstMaterial.compareTo(nameSecondMaterial);
                }
            }
        });

       List<Map.Entry<String,Integer>> junkSortedAlphabetically = new LinkedList<>(commonMaterials.entrySet());
       Collections.sort(junkSortedAlphabetically, new Comparator<Map.Entry<String, Integer>>() {
           @Override
           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
               return o1.getKey().compareTo(o2.getKey());
           }
       });

        for (Map.Entry<String, Integer> orderedLegendaryElements : orderedLegendaryList) {
            System.out.println(orderedLegendaryElements.getKey()+": "+orderedLegendaryElements.getValue());
        }
        for (Map.Entry<String, Integer> orderedJunkElements : junkSortedAlphabetically) {
            System.out.println(orderedJunkElements.getKey()+": "+orderedJunkElements.getValue());
        }
    }
}
