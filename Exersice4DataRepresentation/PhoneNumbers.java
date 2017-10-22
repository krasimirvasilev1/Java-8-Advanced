package Exersice4DataRepresentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = "";
        String input = console.nextLine();

        List<String> names = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        while (!input.equals("END")){
            text += input;

            input = console.nextLine();
        }
        Pattern pattern = Pattern.compile("(([A-Z][A-Za-z]*)[^A-Za-z\\d+]*(\\+?\\d[\\/\\.\\-\\)\\( \\d]*\\d))");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            names.add(matcher.group(2));
            String [] phoneNumbersadditionaSigns = matcher.group(3).split("[().\\/ -]",-1);
            String clearPhone = "";
            for (int i = 0; i < phoneNumbersadditionaSigns.length; i++) {
                clearPhone += phoneNumbersadditionaSigns[i];
            }
            numbers.add(clearPhone);
        }


        if (names.isEmpty() || numbers.isEmpty()){
            System.out.println("<p>No matches!</p>");
        }
        else{
            System.out.print("<ol>");
            for (int i = 0; i < names.size(); i++) {
                System.out.print("<li><b>"+names.get(i)+":</b> "+numbers.get(i)+"</li>");
            }
            System.out.print("</ol>");
        }

    }
}
