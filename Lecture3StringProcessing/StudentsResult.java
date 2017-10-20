package Lecture3StringProcessing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentsResult {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|","Name","JAdv","JavaOOP","AdvOOP","Average"));

        List <String> output = new ArrayList<>();

           String [] text = console.nextLine().split(" - ");
           String name = text[0];
           String [] studentsGrades = text[1].split(", ");
           double jadvGrade = Double.parseDouble(studentsGrades[0]);
           double javaOOPGrade = Double.parseDouble(studentsGrades[1]);
           double advOOPGrade = Double.parseDouble(studentsGrades[2]);

           double average = (jadvGrade + javaOOPGrade + advOOPGrade) / 3;
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",name,jadvGrade,javaOOPGrade,advOOPGrade,average));
    }
}
