package ExamMay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String , TreeMap<String,ArrayList<String>>> statistics = new LinkedHashMap<>();

        while(true){
            String input = console.readLine();
            if ("Season End".equals(input)){
                break;
            }
            String [] teamsAndResults = input.split(" - ");
            String [] opponentStats = teamsAndResults[1].split(" ");
            String [] result = opponentStats[2].split(":");
            String keyTeam = teamsAndResults[0];
            String opponentTeam = opponentStats[0];
            String keyGoals = result[0];
            String valueGoals = result[1];

            if (statistics.containsKey(keyTeam)){
                if (statistics.get(keyTeam).containsKey(opponentTeam)){
                    statistics.get(keyTeam).get(opponentTeam).add(keyGoals + ":" + valueGoals);
                }
                else{
                    statistics.get(keyTeam).put(opponentTeam,new ArrayList<>());
                    statistics.get(keyTeam).get(opponentTeam).add(keyGoals + ":" + valueGoals);
                }
            }
            else{
                statistics.put(keyTeam,new TreeMap<>());

                 statistics.get(keyTeam).put(opponentTeam,new ArrayList<>());
                 statistics.get(keyTeam).get(opponentTeam).add(keyGoals+ ":" + valueGoals);
                }

            if (statistics.containsKey(opponentTeam)){
                if (statistics.get(opponentTeam).containsKey(keyTeam)){
                    statistics.get(opponentTeam).get(keyTeam).add(valueGoals + ":" + keyGoals);
                }
                else{
                    statistics.get(opponentTeam).put(keyTeam,new ArrayList<>());
                    statistics.get(opponentTeam).get(keyTeam).add(valueGoals + ":" + keyGoals);
                }
            }
            else{
                statistics.put(opponentTeam,new TreeMap<>());

                statistics.get(opponentTeam).put(keyTeam,new ArrayList<>());
                statistics.get(opponentTeam).get(keyTeam).add(valueGoals+ ":" + keyGoals);

                }
        }

        String [] teamsStatsToShow = console.readLine().split(", ");
        for (String s : teamsStatsToShow) {
            for (String s1 : statistics.get(s).keySet()) {
                for (String s2 : statistics.get(s).get(s1)) {
                    System.out.printf("%s - %s -> %s%n",s,s1,s2);
                }
            }
        }
    }
}