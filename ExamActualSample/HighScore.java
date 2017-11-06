package ExamActualSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class HighScore {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Long> playersAndTotalScore = new LinkedHashMap<>();
        LinkedHashMap<String,List<String>> playersAndBattles = new LinkedHashMap<>();

        while(true){
            String input = console.readLine();
            if (input.equals("osu!")){
                break;
            }
            String [] twoPlayersStats = input.split("<->");
            String [] playerOneStats = twoPlayersStats[0].split(" ");
            String [] playerTwoStats = twoPlayersStats[1].split(" ");
            long playerOneScore = Long.parseLong(playerOneStats[0]);
            long playerTwoScore = Long.parseLong(playerTwoStats[1]);
            String playerOneName = playerOneStats[1];
            String playerTwoName = playerTwoStats[0];

            long diff = 0;
            if (playerOneScore >= playerTwoScore){
                diff = playerOneScore - playerTwoScore;

                if (playersAndTotalScore.containsKey(playerOneName)){
                    playersAndTotalScore.put(playerOneName,playersAndTotalScore.get(playerOneName) + diff);
                    playersAndBattles.get(playerOneName).add("*   "+playerTwoName+" <-> "+diff);
                }
                else{
                    playersAndTotalScore.put(playerOneName,diff);
                    playersAndBattles.put(playerOneName,new LinkedList<>());
                    playersAndBattles.get(playerOneName).add("*   "+playerTwoName+" <-> "+diff);
                }
                if (playersAndTotalScore.containsKey(playerTwoName)){
                    playersAndTotalScore.put(playerTwoName,playersAndTotalScore.get(playerTwoName) - diff);
                    playersAndBattles.get(playerTwoName).add("*   "+playerOneName+" <-> "+(playerTwoScore - playerOneScore));
                }
                else{
                    playersAndTotalScore.put(playerTwoName,playerTwoScore - playerOneScore);
                    playersAndBattles.put(playerTwoName,new LinkedList<>());
                    playersAndBattles.get(playerTwoName).add("*   "+playerOneName+" <-> "+(playerTwoScore - playerOneScore));
                }
            }
            else{
                diff = playerTwoScore - playerOneScore;
                if (playersAndTotalScore.containsKey(playerOneName)){
                    playersAndTotalScore.put(playerOneName,playersAndTotalScore.get(playerOneName) - diff);
                    playersAndBattles.get(playerOneName).add("*   "+playerTwoName+" <-> "+(playerOneScore - playerTwoScore));
                }
                else{
                    playersAndTotalScore.put(playerOneName,playerOneScore - playerTwoScore);
                    playersAndBattles.put(playerOneName,new LinkedList<>());
                    playersAndBattles.get(playerOneName).add("*   "+playerTwoName+" <-> "+(playerOneScore - playerTwoScore));
                }
                if (playersAndTotalScore.containsKey(playerTwoName)){
                    playersAndTotalScore.put(playerTwoName,playersAndTotalScore.get(playerTwoName) + diff);
                    playersAndBattles.get(playerTwoName).add("*   "+playerOneName+" <-> "+diff);
                }
                else{
                    playersAndTotalScore.put(playerTwoName,diff);
                    playersAndBattles.put(playerTwoName,new LinkedList<>());
                    playersAndBattles.get(playerTwoName).add("*   "+playerOneName+" <-> "+diff);
                }
            }
        }

        Stream<Map.Entry<String,Long>> sortedPlayersAndTotalScores = playersAndTotalScore.entrySet().stream().sorted((x,y) -> y.getValue().compareTo(x.getValue()));
        sortedPlayersAndTotalScores.forEach(x -> {
            System.out.println(x.getKey()+" - ("+x.getValue()+")");
            playersAndBattles.get(x.getKey()).forEach(y -> System.out.println(y));
        });
    }
}
