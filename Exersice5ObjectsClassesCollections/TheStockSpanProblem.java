package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TheStockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int spanDays = Integer.parseInt(console.readLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        List<Integer> stockTheNumbers = new ArrayList<>();
        for (int i = 0; i < spanDays; i++) {
            numbers.add(Integer.parseInt(console.readLine()));
        }

        while(!numbers.isEmpty()){
            if (stockTheNumbers.isEmpty()){
                stockTheNumbers.add(numbers.poll());
                System.out.println(1);
            }
            else{
                int counter = 1;
                int newSpanCheck = numbers.poll();
                for (int i = stockTheNumbers.size() - 1; i >= 0 ; i--) {
                    if (newSpanCheck >= stockTheNumbers.get(i)){
                        counter++;
                    }
                    else {
                        break;
                    }
                }
                stockTheNumbers.add(newSpanCheck);
                System.out.println(counter);
            }
        }
    }
}
