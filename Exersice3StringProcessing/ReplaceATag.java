package Exersice3StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder combinedTexts = new StringBuilder(console.nextLine());
        while (!combinedTexts.toString().equals("END")) {

            Pattern pattern = Pattern.compile("href=");
            Matcher matcher = pattern.matcher(combinedTexts);
            while (matcher.find()) {
                int startIndex = combinedTexts.indexOf("<a");
                int endIndex = combinedTexts.indexOf("</a>");
                int hrefIndex = combinedTexts.indexOf("href");

                String substring = "";
                if (startIndex != -1 || endIndex != -1) {
                    if (hrefIndex > startIndex || hrefIndex < endIndex) {
                        substring = combinedTexts.substring(startIndex, endIndex + 4);
                        substring = substring.replace('<', '[').replace("a", "URL").replace('>', ']');
                        combinedTexts.replace(startIndex, endIndex + 4, substring);
                    }
                }
            }
            System.out.println(combinedTexts);

            combinedTexts = new StringBuilder(console.nextLine());
        }
    }
}
