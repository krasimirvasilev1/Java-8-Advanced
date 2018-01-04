package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMASupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> crates = new LinkedList<>();
        int numberOfLines = 0;

        int symbolsCount = 0;

        List<String> validCrates = new ArrayList<>();
        int amountOfFood = 0;
        int amountOfDrinks = 0;

        while (true) {
            String input = console.readLine();
            if ("Collect".equals(input)) {
                break;
            }
            numberOfLines++;
            Pattern pattern = Pattern.compile("\\[(?<crate>[^]]*)\\]");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                crates.add(matcher.group("crate"));
            }
        }

        symbolsCount = crates.size() / numberOfLines;

        for (String crate : crates) {

            Pattern foodPattern = Pattern.compile("^(?<supplyTag>#[0-9]{" + symbolsCount + "})[^0-9]*#[0-9]{"+symbolsCount+"}$");
            Pattern drinkPattern = Pattern.compile("^(?<supplyTag>#[a-z]{" + symbolsCount + "})[^a-z]*#[a-z]{"+symbolsCount+"}$");

            Matcher matcher = foodPattern.matcher(crate);
            Matcher matcher1 = drinkPattern.matcher(crate);

            if (matcher.find()) {
                Pattern validCrate = Pattern.compile(matcher.group("supplyTag") + "(?<supplyBody>[a-zA-Z0-9\\s]*)" + matcher.group("supplyTag"));
                Matcher validMatch = validCrate.matcher(crate);

                if (validMatch.find()) {
                    validCrates.add(matcher.group());
                    Set<Character> uniqueCodes = new HashSet<>();
                    int lengthTag = matcher.group("supplyTag").length() - 1;
                    int valueOfAsciiCodes = 0;

                    for (int i = 0; i < validMatch.group("supplyBody").length(); i++) {
                        uniqueCodes.add(validMatch.group("supplyBody").charAt(i));
                    }

                    for (Character uniqueCode : uniqueCodes) {
                        valueOfAsciiCodes += (int) uniqueCode;
                    }

                    amountOfFood += valueOfAsciiCodes * lengthTag;
                }
            }

            if (matcher1.find()) {
                Pattern validCrate = Pattern.compile(matcher1.group("supplyTag") + "(?<supplyBody>[a-zA-Z0-9\\s]*)" + matcher1.group("supplyTag"));
                Matcher validMatch = validCrate.matcher(crate);

                if (validMatch.find()) {
                    validCrates.add(matcher1.group());
                    List<Character> uniqueCodes = new LinkedList<>();
                    List<Character> uniqueBodyCodes = new LinkedList<>();
                    int valueOfAsciiCodesTag = 0;
                    int valueOfAsciiCodesBody = 0;

                    for (int i = 0; i < validMatch.group("supplyBody").length(); i++) {
                        uniqueBodyCodes.add(validMatch.group("supplyBody").charAt(i));
                    }

                    for (int i = 1; i < matcher1.group("supplyTag").length(); i++) {
                        uniqueCodes.add(matcher1.group("supplyTag").charAt(i));
                    }

                    for (Character uniqueCode : uniqueCodes) {
                        valueOfAsciiCodesTag += (int) uniqueCode;
                    }

                    for (Character uniqueBodyCode : uniqueBodyCodes) {
                        valueOfAsciiCodesBody += (int) uniqueBodyCode;
                    }

                    amountOfDrinks += valueOfAsciiCodesBody * valueOfAsciiCodesTag;
                }
            }
        }

        if (validCrates.isEmpty()) {
            System.out.println("No supplies found!");
        }
        else{
            System.out.println("Number of supply crates: "+validCrates.size());
            System.out.println("Amount of food collected: "+ amountOfFood);
            System.out.println("Amount of drinks collected: "+amountOfDrinks);
        }
    }
}
