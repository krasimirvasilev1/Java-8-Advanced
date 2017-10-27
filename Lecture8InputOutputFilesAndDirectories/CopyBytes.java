package Lecture8InputOutputFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {

        Scanner console = new Scanner (System.in);


        String path = "‪D:\\SOFTUNI\\New Folder\\Files-and-Streams\\Files-and-Streams\\input.txt";


        String outputPath = "D:\\SOFTUNI\\New Folder\\Files-and-Streams\\Files-and-Streams\\output.txt";

        try (FileInputStream inputStreamReader = new FileInputStream(path)){
            int oneByte = 0;
            while((oneByte = inputStreamReader.read()) >= 0) {
                String everySymbolAsByte = String.valueOf(oneByte);
                FileOutputStream  fileOutputStream = new FileOutputStream(outputPath);
                for (int i = 0; i < everySymbolAsByte.length(); i++) {
                    if (!everySymbolAsByte.equals(" ")){
                    fileOutputStream.write(everySymbolAsByte.charAt(i));
                    }
                    else{
                        fileOutputStream.write(everySymbolAsByte.charAt(i));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
