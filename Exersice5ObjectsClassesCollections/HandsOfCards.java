package Exersice5ObjectsClassesCollections;

import java.lang.reflect.Array;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        LinkedHashMap<String,HashSet<String>> playersAndValues = new LinkedHashMap<>();

        String input = console.nextLine();
        while (!input.equals("JOKER")){
            String [] nameAndCards = input.split(": ");
            String name = nameAndCards[0];
            String [] cards = nameAndCards[1].split(", ");
            List<String> cardsAsList = Arrays.asList(cards);

            HashSet<String> cardsPerPerson = new HashSet<>(cardsAsList);

            if (playersAndValues.containsKey(name)){
                HashSet<String> allValuesPerPerson = new HashSet<>(playersAndValues.get(name));
                allValuesPerPerson.addAll(cardsPerPerson);

                playersAndValues.put(name,allValuesPerPerson);
            }
            else
            {
              playersAndValues.put(name,cardsPerPerson);
            }
                input = console.nextLine();
            }

        for (String s : playersAndValues.keySet()) {
            int result = 0;
            for (String s1 : playersAndValues.get(s)) {
                int firstChar = 0;
                int secondChar = 0;
                boolean itIs10 = false;
                switch(s1.charAt(0)){
                    case 'J':
                        firstChar += 11;
                        break;
                    case 'Q':
                        firstChar += 12;
                        break;
                    case 'K':
                        firstChar += 13;
                        break;
                    case 'A':
                        firstChar += 14;
                        break;
                    default:
                        if (s1.length() == 2){
                            firstChar += Integer.parseInt(Character.toString(s1.charAt(0)));
                        }
                        else{
                            itIs10 = true;
                            String concatTwoChars = new String(Character.toString(s1.charAt(0)) + Character.toString(s1.charAt(1)));
                            firstChar += Integer.parseInt(concatTwoChars);
                        }
                        break;
                }

                String toMultiply = "";
                if (itIs10){
                    toMultiply += s1.charAt(2);
                }
                else {
                    toMultiply += s1.charAt(1);
                }

                switch(toMultiply){
                    case "S":
                        secondChar += 4;
                        break;
                    case "H":
                        secondChar += 3;
                        break;
                    case "D":
                        secondChar += 2;
                        break;
                    case "C":
                        secondChar += 1;
                        break;
                }

                result += firstChar * secondChar;
            }
            System.out.println(s+": "+result);
        }
        }
    }