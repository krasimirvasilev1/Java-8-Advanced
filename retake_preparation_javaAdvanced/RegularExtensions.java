package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String text = console.readLine();

        while(true){
            String pattern = console.readLine();

            if ("Print".equals(pattern)){
                break;
            }

            if (pattern.contains(".")){
                pattern = pattern.replace(".","\\.");
            }
            if (pattern.contains("%")){
                pattern = pattern.replaceAll("%","[^ ]*");
            }

            Pattern pattern1 = Pattern.compile(pattern);
            Matcher matcher = pattern1.matcher(text);

            while(matcher.find()){
                StringBuilder match = new StringBuilder(matcher.group());

                text = text.replace(matcher.group(),match.reverse());
            }
        }

        System.out.println(text);
    }
}
