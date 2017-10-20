package Exersice3StringProcessing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();
        String regexWithDash = "(\\+359)-(\\d)-(\\d{3})-(\\d{4})\\b";
        String regexWithSpace = "(\\+359) (\\d) (\\d{3}) (\\d{4})\\b";

        while(!text.equals("end")){
            if (Pattern.matches(regexWithDash,text)){
                System.out.println(text);
            }
            else if (Pattern.matches(regexWithSpace,text)){
                System.out.println(text);
            }


            text = console.nextLine();
        }
    }
}
