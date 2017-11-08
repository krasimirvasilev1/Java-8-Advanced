package Exersices7StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WeekStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentsAndGrades = new ArrayList<>();

        while(true){
            String input = console.readLine();

            if (input.equals("END")){
                break;
            }
            studentsAndGrades.add(input);
        }

        Stream <String[]> atLeastOneExcellentGrade = studentsAndGrades.stream().map(x -> x.split(" ")).filter(x -> AtLeastOneExcellentGrade(x));
        atLeastOneExcellentGrade.forEach(x -> System.out.printf("%s %s%n",x[0],x[1]));
    }

    private static boolean AtLeastOneExcellentGrade(String[] x) {
        boolean atLeastTwoWeekGrades = false;
        int counter = 0;
        for (int i = 2; i < x.length; i++) {
            if (x[i].equals("2") || x[i].equals("3")){
                counter++;
            }
            if (counter >= 2){
                atLeastTwoWeekGrades = true;
            }
        }
        return atLeastTwoWeekGrades;
    }
}
