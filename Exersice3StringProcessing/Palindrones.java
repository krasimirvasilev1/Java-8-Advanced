package Exersice3StringProcessing;

import java.util.*;

public class Palindrones {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Set<String> palindromes = new TreeSet<>();
        List <String> list = Arrays.asList(console.nextLine().split("[ ,.?!]"));

        StringBuilder newtext = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(" ")){
                continue;
            }
            else{
                StringBuilder stringForTest = new StringBuilder();
                for (int j = 0; j < list.get(i).length(); j++) {
                    String string = list.get(i);
                    stringForTest.append(string);
                    String reversedString = stringForTest.reverse().toString();

                    if (reversedString.equals(string)){
                        palindromes.add(reversedString);
                    }
                }
                }
            }
        System.out.println("[" + String.join(", ",palindromes) + "]");
        }
    }
