package Exersices7StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> enrollmentYearAndGrades = new ArrayList<>();

        while(true){
            String input = console.readLine();

            if (input.equals("END")){
                break;
            }

            enrollmentYearAndGrades.add(input);
        }

        Stream<String []> enrolmentYearFilter = enrollmentYearAndGrades.stream().map(x -> x.split(" ")).filter(x -> ValidEnrolmmentYear(x));
        enrolmentYearFilter.forEach(x -> {
            for (int i = 1; i < x.length; i++) {
                System.out.printf(x[i] + " ");
            }
            System.out.println();
        });
    }

    private static boolean ValidEnrolmmentYear(String[] x) {
        String fifthAndSixthElement = Character.toString(x[0].charAt(4))+""+""+Character.toString(x[0].charAt(5));

        if (fifthAndSixthElement.equals("14") || fifthAndSixthElement.equals("15")){
            return true;
        }
        else {
            return false;
        }

    }
}
