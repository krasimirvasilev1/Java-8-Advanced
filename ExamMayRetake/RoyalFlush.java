package ExamMayRetake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> allcards = new ArrayList<>();
        int numberOfRows = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfRows; i++) {
            String[] cards = console.readLine().split("");
            ArrayList<String> cardsAsLists = new ArrayList<>(Arrays.asList(cards));
            allcards.addAll(cardsAsLists);
        }

        ArrayList<String> spades = new ArrayList<>();
        ArrayList<String> clubs = new ArrayList<>();
        ArrayList<String> hearts = new ArrayList<>();
        ArrayList<String> diamonds = new ArrayList<>();
        ArrayList<String> numberOfFlushes = new ArrayList<>();

        String cardNumber = "";
        String cardType = "";
        String oneAll = "";
        for (int i = 0; i < allcards.size(); i++) {
            if (cardNumber.equals("")){
                if (allcards.get(i).equals("1")){
                    cardNumber = allcards.get(i) + allcards.get(i + 1);
                    i++;
                }
                else{
                    cardNumber = allcards.get(i);
                }
            }
            else if (cardType.equals("")){
                cardType = allcards.get(i);
                oneAll = cardNumber + cardType;
            }
            else{
                AddingToLists(spades, clubs, hearts, diamonds, cardType, oneAll,numberOfFlushes,cardNumber);

                if (allcards.get(i).equals("1")){
                    cardNumber = allcards.get(i) + allcards.get(i + 1);
                    i++;
                }
                else{
                    cardNumber = allcards.get(i);
                }
                    cardType = "";
            }
        }
        AddingToLists(spades,clubs,hearts,diamonds,cardType,oneAll,numberOfFlushes,cardNumber);
        System.out.println("Royal's Royal Flushes - "+numberOfFlushes.size()+".");
    }

    private static void AddingToLists(ArrayList<String> spades, ArrayList<String> clubs, ArrayList<String> hearts, ArrayList<String> diamonds, String cardType, String oneAll,ArrayList<String> numberOfFlushes,String cardNumber) {
        if (cardType.equals("s")) {
            if (cardNumber.equals("10")){
                spades.clear();
                spades.add(oneAll);
            }
            else{
                spades.add(oneAll);
            }
            if (isAFlush(spades)) {
                System.out.println("Royal Flush Found - Spades");
                numberOfFlushes.add("yes");
                spades.clear();
            } else if (!isGoingWell(spades)) {
                spades.clear();
            }
        }
        else if (cardType.equals("c")){
            if (cardNumber.equals("10")){
                clubs.clear();
                clubs.add(oneAll);
            }
            else{
                clubs.add(oneAll);
            }
            if (isAFlush(clubs)) {
                System.out.println("Royal Flush Found - Clubs");
                numberOfFlushes.add("yes");
                clubs.clear();
            } else if (!isGoingWell(clubs)) {
                clubs.clear();
            }
        }
        else if (cardType.equals("h")){
            if (cardNumber.equals("10")){
                hearts.clear();
                hearts.add(oneAll);
            }
            else{
                hearts.add(oneAll);
            }
            if (isAFlush(hearts)) {
                System.out.println("Royal Flush Found - Hearts");
                numberOfFlushes.add("yes");
                hearts.clear();
            } else if (!isGoingWell(hearts)) {
                hearts.clear();
            }
        }
        else if (cardType.equals("d")){
            if (cardNumber.equals("10")){
                diamonds.clear();
                diamonds.add(oneAll);
            }
            else{
                diamonds.add(oneAll);
            }
            if (isAFlush(diamonds)) {
                System.out.println("Royal Flush Found - Diamonds");
                numberOfFlushes.add("yes");
                diamonds.clear();
            } else if (!isGoingWell(diamonds)) {
                diamonds.clear();
            }
        }
    }

    private static boolean isAFlush(ArrayList<String> spades) {
        if (spades.size() != 5){
            return false;
        }
        else{
            if (!spades.get(0).contains("10")){
                return false;
            }
            if (!spades.get(1).contains("J")){
                return false;
            }
            if(!spades.get(2).contains("Q")){
                return  false;
            }
            if (!spades.get(3).contains("K")){
                return false;
            }
            if (!spades.get(4).contains("A")){
                return false;
            }
            return true;
        }
    }

    private static boolean isGoingWell(ArrayList<String> spades) {
        int counter = 0;
        boolean rankingIsFine = false;
        for (String spade : spades) {
           if (counter == 0 && spade.charAt(0) == '1' && spade.charAt(1) == '0'){
                   rankingIsFine = true;
               }
               else if (counter == 1 && spade.charAt(0) == 'J'){
                   rankingIsFine = true;
               }
               else if (counter == 2 && spade.charAt(0) == 'Q'){
                   rankingIsFine = true;
                }
                else if (counter == 3 && spade.charAt(0) == 'K'){
                   rankingIsFine = true;
           }
           else if (counter == 4 && spade.charAt(0) == 'A'){
                    rankingIsFine = true;
           }
           else{
               return false;
           }
           counter++;
        }
        return  rankingIsFine;
    }

}
