package ExamMay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class LettersExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder(console.readLine());

        StringBuilder number = new StringBuilder();

        int secondNumber = 0;
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (isNumber(i, text.toString())) {
                number.append(text.charAt(i));
                if (i == text.length() - 1 && number.length() != 0) {
                    sum = CalculatingSum(counter, sum, Integer.parseInt(number.toString()));
                }
            } else if (number.length() != 0) {
                if (sum == 0) {
                    sum += Integer.parseInt(number.toString());
                    number = new StringBuilder();
                } else {

                    secondNumber = Integer.parseInt(number.toString());

                    number = new StringBuilder();

                    sum = CalculatingSum(counter, sum, secondNumber);

                    secondNumber = 0;
                    counter = 0;
                }
            }

            if (!isNumber(i, text.toString())) {
                counter++;
            }
        }

        System.out.println(sum);
    }

    private static boolean isNumber (int currIndex,String text){
        if (Character.isDigit(text.charAt(currIndex))){
            return true;
        }
        else {
            return false;
        }
    }

    private static int CalculatingSum (int counter, int sum, int secondNumber){
        Predicate<Integer> check = x -> x % 2 == 0;

        if (check.test(counter)) {
                sum += secondNumber;

        }
        else {

                sum -= secondNumber;
            }
        return sum;
    }
}
