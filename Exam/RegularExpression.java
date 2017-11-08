package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        StringBuilder newBuilder = new StringBuilder(console.readLine());

        while(true){
            String input = console.readLine();
            if (input.equals("Print")){
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != '%'){
                    if (input.charAt(i) == '.'){
                        builder.append('\\');
                        builder.append(input.charAt(i));
                    }
                    else{
                        builder.append(input.charAt(i));
                    }
                }
                else {
                    builder.append("[^ ]*");
                }
            }

            Pattern pattern = Pattern.compile(builder.toString());
            Matcher matcher = pattern.matcher(newBuilder.toString());

            while(matcher.find()){
                builder.setLength(0);
                String toBeReplaced = matcher.group();
                builder.append(toBeReplaced);
                builder.reverse();
                newBuilder = new StringBuilder(newBuilder.toString().replace(matcher.group(),builder.toString()));

                builder.setLength(0);
            }
            builder.setLength(0);
        }
        System.out.println(newBuilder);
    }
}
