package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedList<Dragon>> allDragons = new LinkedHashMap<>();
        int numberOfDragons = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfDragons; i++) {
            String[] statsByDragon = console.readLine().split(" ");
            String typeDragon = statsByDragon[0];
            String nameDragon = statsByDragon[1];
            double damageDragon = 0;
            double healthDragon = 0;
            double armourDragon = 0;
            if (statsByDragon[2].equals("null")) {
                damageDragon = 45;
            } else {
                damageDragon = Double.parseDouble(statsByDragon[2]);
            }
            if (statsByDragon[3].equals("null")) {
                healthDragon = 250;
            } else {
                healthDragon = Double.parseDouble(statsByDragon[3]);
            }
            if (statsByDragon[4].equals("null")) {
                armourDragon = 10;
            } else {
                armourDragon = Double.parseDouble(statsByDragon[4]);
            }

            Dragon newDragon = new Dragon();
            newDragon.name = nameDragon;
            newDragon.armour = armourDragon;
            newDragon.damage = damageDragon;
            newDragon.health = healthDragon;

            if (allDragons.containsKey(typeDragon)) {
                List<Dragon> allDragonsByType = allDragons.get(typeDragon);
                boolean theSameDragonNameFound = false;
                for (Dragon dragon : allDragonsByType) {
                    if (dragon.name.equals(nameDragon)) {
                        allDragons.get(typeDragon).remove(dragon);
                        allDragons.get(typeDragon).add(newDragon);
                        theSameDragonNameFound = true;
                        break;
                    }
                }
                if (!theSameDragonNameFound){
                    allDragons.get(typeDragon).add(newDragon);
                }
            }
            else{
                    allDragons.put(typeDragon, new LinkedList<>());
                    allDragons.get(typeDragon).add(newDragon);
                }
            }

        for (String typeOfDragon : allDragons.keySet()) {
            double averageDamagePerType = 0;
            double averageHealthPerType = 0;
            double averageArmourPerType = 0;
            for (Dragon dragonPerType : allDragons.get(typeOfDragon)) {
                averageDamagePerType += dragonPerType.damage;
                averageArmourPerType += dragonPerType.armour;
                averageHealthPerType += dragonPerType.health;
            }
            int numberOfDragonsPerType = allDragons.get(typeOfDragon).size();

            averageDamagePerType = averageDamagePerType / numberOfDragonsPerType;
            averageHealthPerType = averageHealthPerType / numberOfDragonsPerType;
            averageArmourPerType = averageArmourPerType / numberOfDragonsPerType;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",typeOfDragon,averageDamagePerType,averageHealthPerType,averageArmourPerType);

            LinkedList<Dragon> sortedDragons = new LinkedList<>(allDragons.get(typeOfDragon));
            Collections.sort(sortedDragons, new Comparator<Dragon>() {
                @Override
                public int compare(Dragon o1, Dragon o2) {
                    return o1.name.compareTo(o2.name);
                }
            });

            for (Dragon sortedTypeOfDragon : sortedDragons) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",sortedTypeOfDragon.name,sortedTypeOfDragon.damage,sortedTypeOfDragon.health,sortedTypeOfDragon.armour);
            }
                }
        }
}
class Dragon{
    String name;
    Double damage;
    Double health;
    Double armour;
}
