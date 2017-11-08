package Lecture7BuildInQueryMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      OptionalInt integerIntStream = Arrays.stream(console.readLine().split(" ")).filter(x -> !x.isEmpty()).filter(x -> isNumber(x)).mapToInt(Integer::valueOf).reduce((x1, x2) -> x1 + x2);

      if (integerIntStream.isPresent()){
          System.out.println(integerIntStream.getAsInt());
      }
      else{
          System.out.println("No match");
      }
    }

    public static boolean isNumber (String text){
        int [] number = {1,2,3,4,5,6,7,8,9};
        boolean isPlusMunusOrNumber = false;
        boolean isNumber = false;
        if (text.charAt(0) == '-' || text.charAt(0) == '+'){
            isPlusMunusOrNumber = true;
        }
        if (isPlusMunusOrNumber){
            for (int i = 1; i < text.length(); i++) {
                isNumber = false;
                for (int j = 0; j < number.length; j++) {
                    if (String.valueOf(number[j]).equals(String.valueOf(text.charAt(i)))){
                        isNumber = true;
                    }
                }
                if (!isNumber){
                    break;
                }
            }
        }
        else{
            for (int i = 0; i < text.length(); i++) {
                isNumber = false;
                for (int j = 0; j < number.length; j++) {
                    if (String.valueOf(number[j]).equals(String.valueOf(text.charAt(i)))){
                        isNumber = true;
                        break;
                    }
                }
                if (!isNumber){
                    break;
                }
            }
        }
        return isNumber;

    }
}