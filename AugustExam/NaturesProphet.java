package AugustExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NaturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder();
        while(true){
            String input = console.readLine();
            if ("---NMS SEND---".equals(input)){
                break;
            }
            text.append(input);
        }

        List<String>sequenceOfWords = new ArrayList<>();
        StringBuilder charsWhichCoverTheRequir = new StringBuilder();
        String previousChar = "";
        for (int i = 0; i < text.length(); i++) {
            if (i == 0){
                previousChar = String.valueOf(text.charAt(i));
                charsWhichCoverTheRequir.append(previousChar);
                continue;
            }
            if (String.valueOf(text.charAt(i)).toLowerCase().compareTo(previousChar.toLowerCase()) >= 0){
                previousChar = String.valueOf(text.charAt(i));
                charsWhichCoverTheRequir.append(String.valueOf(text.charAt(i)));
            }
            else{
                sequenceOfWords.add(charsWhichCoverTheRequir.toString());
                charsWhichCoverTheRequir = new StringBuilder();
                previousChar = String.valueOf(text.charAt(i));
                charsWhichCoverTheRequir.append(previousChar);
            }
        }
        if (!charsWhichCoverTheRequir.toString().isEmpty()){
            sequenceOfWords.add(charsWhichCoverTheRequir.toString());
        }

        String delimiter = console.readLine();
        String textToBePrinted = String.join(delimiter,sequenceOfWords);

        System.out.println(textToBePrinted);
    }
}
