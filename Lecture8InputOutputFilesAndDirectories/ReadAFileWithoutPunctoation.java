package Lecture8InputOutputFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadAFileWithoutPunctoation {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String textInput = "D:\\SOFTUNI\\New folder\\Files-and-Streams\\input.txt";
        String textOutput = "D:\\SOFTUNI\\New folder\\Files-and-Streams\\output.txt";

        List<Character> listWithSymbols = new ArrayList<>();
        Collections.addAll(listWithSymbols,',','?','!','.');

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(textOutput);
            InputStream fileInputStream = new FileInputStream(textInput);

            int oneByte = fileInputStream.read();
            while(oneByte  >= 0){
                if (!listWithSymbols.contains((char) oneByte)){
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
