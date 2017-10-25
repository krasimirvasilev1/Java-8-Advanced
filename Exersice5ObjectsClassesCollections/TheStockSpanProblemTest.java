package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TheStockSpanProblemTest {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int spanDays = Integer.parseInt(console.readLine());

        List<Integer> stockTheNumbers = new ArrayList<>();
        for (int i = 0; i < spanDays; i++) {
            stockTheNumbers.add(Integer.parseInt(console.readLine()));
        }

        for (int i = 0; i < stockTheNumbers.size(); i++) {
            if (i == 0){
                System.out.println(1);
                continue;
            }
                int counter = 0;
                for (int j = i; j >= 0; j--) {
                    if (stockTheNumbers.get(i) >= stockTheNumbers.get(j)){
                        counter++;
                    }
                    else {
                        break;
                    }
                }
                System.out.println(counter);
            }
        }
    }
