package Lecture3StringProcessing;

import java.util.Scanner;

public class ParseURL {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] text = console.nextLine().split("://");

        if (text.length != 2){
            System.out.println("Invalid URL");
        }
        else{

            String https = text[0];
            int indexOfSoftuniBG = text[1].indexOf('/');
            String softuniBG = text[1].substring(0, indexOfSoftuniBG);

            String resourses = text[1].substring(indexOfSoftuniBG + 1, text[1].length());

            System.out.println("Protocol = " + https);
            System.out.println("Server = " + softuniBG);
            System.out.println("Resources = " + resourses);
        }
    }
}
