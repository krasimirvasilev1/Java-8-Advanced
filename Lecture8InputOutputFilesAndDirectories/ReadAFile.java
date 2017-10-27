package Lecture8InputOutputFilesAndDirectories;

import java.io.*;

public class ReadAFile {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String path = "D:\\SOFTUNI\\New folder\\Files-and-Streams\\input.txt";
        try (FileInputStream fileInputStream = new FileInputStream(path)){
            int oneByte = fileInputStream.read();

            System.out.println((char)oneByte);
            while(oneByte >= 0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
