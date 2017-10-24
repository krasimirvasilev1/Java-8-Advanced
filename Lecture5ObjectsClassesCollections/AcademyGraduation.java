package Lecture5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,Double> allPeople = new HashMap<String, Double>();

        int numberOfStudents = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String key = console.readLine();
            double [] grades = Arrays.stream(console.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double averageGradePerStudent = 0.0;
            for (int j = 0; j < grades.length; j++) {
                averageGradePerStudent += grades[j];
            }
            averageGradePerStudent = averageGradePerStudent / grades.length;

            allPeople.put(key,averageGradePerStudent);
        }
        for (String s : allPeople.keySet()) {
            System.out.println(s + " is graduated with " + allPeople.get(s));
        }
    }
}
