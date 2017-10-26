package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,LinkedHashMap<String,Integer>> companies = new HashMap<>();

        int numberOfInputs = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfInputs; i++) {
            String [] input = console.readLine().split(" - ");
            String company = input[0].replace("|","");
            int amount = Integer.parseInt(input[1]);
            String product = input[2].replace("|","");

            if (companies.containsKey(company)){
                if (companies.get(company).containsKey(product)){
                    int newAmount = companies.get(company).get(product) + amount;
                    companies.get(company).put(product,newAmount);
                }
                else{
                    companies.get(company).put(product,amount);
                }

            }
            else{
                companies.put(company,new LinkedHashMap<>());
                companies.get(company).put(product,amount);
            }
        }

        List <String> allcompanies = new ArrayList<>(companies.keySet());
        Collections.sort(allcompanies, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String allcompany : allcompanies) {
            StringBuilder output = new StringBuilder();
            output.append(allcompany + ": ");
            LinkedHashMap<String,Integer> productsAmounts = companies.get(allcompany);
            for (String s : productsAmounts.keySet()) {
                output.append(s+"-"+productsAmounts.get(s)+", ");
            }
            System.out.println(output.substring(0,output.length() - 2));
        }
    }
}
