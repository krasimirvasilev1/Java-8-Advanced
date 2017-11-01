package ExamMayRetake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String [] input = console.readLine().split(" ");

        List<String> royalists = new LinkedList<>();
        List<String> nonRoyalists = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = 0; j < input[i].length(); j++) {
                sum += (int)input[i].charAt(j);
                if (sum > 26){
                    while (sum > 26){
                        sum -= 26;
                    }
                }
            }
            if (sum == 18){
                royalists.add(input[i]);
            }
            else{
                nonRoyalists.add(input[i]);
            }
        }

        if (royalists.size() >= nonRoyalists.size()){
            System.out.println("Royalists - "+royalists.size());
            for (String royalist : royalists) {
                System.out.println(royalist);
            }
            System.out.println("All hail Royal!");
        }
        else{
            for (String nonRoyalist : nonRoyalists) {
                System.out.println(nonRoyalist);
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
