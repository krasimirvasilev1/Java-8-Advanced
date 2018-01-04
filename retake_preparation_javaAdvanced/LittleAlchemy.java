package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        ArrayDeque<Integer> gold = new ArrayDeque<>();

        String [] stonesFromInput = console.readLine().split("\\s+");
        for (int i = 0; i < stonesFromInput.length; i++) {
            stones.addLast(Integer.parseInt(stonesFromInput[i]));
        }

        while(true){
            String input = console.readLine();
            if (input.equals("Revision")){
                break;
            }
            String[] commands = input.split("\\s+");
            switch (commands[0]){
                case "Apply":
                    for (int i = 0; i < Integer.parseInt(commands[2]); i++) {
                        if (!stones.isEmpty()) {
                            int currStone = stones.removeFirst();

                            currStone -= 1;

                            if (currStone <= 0) {
                                gold.addLast(0);
                            } else {
                                stones.addLast(currStone);
                            }
                        }
                    }
                    break;
                case "Air":
                    if (!gold.isEmpty()){
                        int fromGoldToStone = gold.removeLast() + Integer.parseInt(commands[2]);

                        stones.addLast(fromGoldToStone);
                    }
                    break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer s : stones) {
            builder.append(s + " ");
        }

        System.out.println(builder.toString().trim());
        System.out.println(gold.size());
    }
}
