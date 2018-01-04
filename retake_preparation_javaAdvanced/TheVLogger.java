package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TheVLogger {
    private static int variable = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String , List<String>> followers = new LinkedHashMap<>();
        Map<String , List<String>> following = new LinkedHashMap<>();

        while(true){
            String input = console.readLine();
            if ("Statistics".equals(input)){
                break;
            }

            String[] commands = input.split("\\s+");
            switch (commands[1]){
                case "joined":
                    if (!followers.containsKey(commands[0]) && !following.containsKey(commands[0])){
                        followers.put(commands[0],new ArrayList<>());
                        following.put(commands[0],new ArrayList<>());
                    }
                    break;
                case "followed":
                    if (followers.containsKey(commands[0]) && followers.containsKey(commands[2]) && !commands[0].equals(commands[2])){
                        if (!followers.get(commands[2]).contains(commands[0])) {
                            followers.get(commands[2]).add(commands[0]);
                        }

                        if (!following.get(commands[0]).contains(commands[2])){
                            following.get(commands[0]).add(commands[2]);
                        }
                    }
                    break;
            }
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n",followers.size());

        followers.entrySet().stream().sorted((x,y) -> FindTheMostFamousVlogger(x.getKey(),y.getKey(),x.getValue(),y.getValue(),following)).limit(1)
                .forEach(x -> {
                    System.out.printf("%d. %s : %d followers, %d following%n",variable,x.getKey(),x.getValue().size(),following.get(x.getKey()).size());

                    x.getValue().stream().sorted(String::compareTo)
                            .forEach(y -> System.out.println("*  "+y));

                    increaseTheCounter();
                });

        followers.entrySet().stream().sorted((x,y) -> FindTheMostFamousVlogger(x.getKey(),y.getKey(),x.getValue(),y.getValue(),following)).skip(1)
                .forEach(x -> {
                    System.out.printf("%d. %s : %d followers, %d following%n",variable,x.getKey(),x.getValue().size(),following.get(x.getKey()).size());
                    increaseTheCounter();
                });
    }

    private static int FindTheMostFamousVlogger(String key, String key1, List<String> value, List<String> value1, Map<String, List<String>> following) {
            int followersCompare = Integer.compare(value1.size(), value.size());
            if (followersCompare != 0){
                return followersCompare;
            }

            return Integer.compare(following.get(key).size(), following.get(key1).size());
        }

    private static void increaseTheCounter() {
        variable++;
    }
}
