package ExamMayRetake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Double> teamsAndMonthlyPayment = new LinkedHashMap<>();
        LinkedHashMap<String,List<Person>> teamsAndEmployees = new LinkedHashMap<>();

        while(true){
            String input = console.readLine();
            if (input.equals("Pishi kuf i da si hodim")){
                break;
            }
            String [] inputAsArray = input.split(";");
            if (inputAsArray.length != 4){
                continue;
            }
            String name = "";
            int workHoursPerDay = Integer.MIN_VALUE;
            double dailyPayment = Integer.MIN_VALUE;
            String team = "";

            Pattern patternName = Pattern.compile("^[a-zA-Z]+$");
            Pattern patternHoursPerDay = Pattern.compile("^[-]?[0-9]+$");
            Pattern patterDailyPaymnet = Pattern.compile("^[-]?[0-9]+([\\.|0-9][0-9]+)?$");
            Pattern patternTeam = Pattern.compile("^[a-zA-Z]+$");

            Matcher matcherName = patternName.matcher(inputAsArray[0]);
            Matcher matcherHoursPerDay = patternHoursPerDay.matcher(inputAsArray[1]);
            Matcher matcherDailyPayment = patterDailyPaymnet.matcher(inputAsArray[2]);
            Matcher matcherTeam = patternTeam.matcher(inputAsArray[3]);

            if (matcherName.find()){
                name = matcherName.group();
            }
            if (matcherHoursPerDay.find()){
                workHoursPerDay = Integer.parseInt(matcherHoursPerDay.group());
            }
            if (matcherDailyPayment.find()){
                dailyPayment = Double.parseDouble(matcherDailyPayment.group());
            }
            if (matcherTeam.find()){
                team = matcherTeam.group();
            }

            if (!name.equals("") && workHoursPerDay != Integer.MIN_VALUE && dailyPayment != Integer.MIN_VALUE && !team.equals("")){
                Person person = new Person();
                person.name = name;
                person.dailyPayment = (dailyPayment * (double)workHoursPerDay) / 24;
                person.workHours = workHoursPerDay;
                double personDailyPayment = person.dailyPayment;

                if (teamsAndEmployees.containsKey(team)){
                    boolean containsThatName = false;
                    for (List<Person> personList : teamsAndEmployees.values()) {
                        for (Person person1 : personList) {
                            if (person1.name.equals(name)){
                                containsThatName = true;
                                break;
                            }
                        }
                        if (containsThatName){
                            break;
                        }
                    }
                    if (!containsThatName){
                        teamsAndEmployees.get(team).add(person);

                        teamsAndMonthlyPayment.put(team,teamsAndMonthlyPayment.get(team) + personDailyPayment * 30);
                    }
                }
                else{
                    boolean containsThatName = false;
                    for (List<Person> personList : teamsAndEmployees.values()) {
                        for (Person person1 : personList) {
                            if (person1.name.equals(name)){
                                containsThatName = true;
                                break;
                            }
                        }
                        if (containsThatName){
                            break;
                        }
                    }
                    if (!containsThatName){
                        teamsAndEmployees.put(team,new ArrayList<>());
                        teamsAndEmployees.get(team).add(person);

                        teamsAndMonthlyPayment.put(team,personDailyPayment * 30);
                    }
                }
            }
        }
        Stream<Map.Entry<String,Double>> sortedTeamsAndMontly = teamsAndMonthlyPayment.entrySet().stream().sorted((x,y) -> y.getValue().compareTo(x.getValue()));
        sortedTeamsAndMontly.forEach(x -> {
            Stream<Person> sortedPersons = teamsAndEmployees.get(x.getKey()).stream().sorted((a,b) -> SortThemBuValueAndThenAlpha(a.workHours,b.workHours,a.dailyPayment,b.dailyPayment,a.name,b.name));
            System.out.println("Team - "+x.getKey());
            sortedPersons.forEach(y -> System.out.printf("$$$%s - %d - %.6f%n",y.name,y.workHours,y.dailyPayment));
        });
    }

    private static int SortThemBuValueAndThenAlpha(Integer workHours, Integer workHours1, Double dailyPayment, Double dailyPayment1,String name,String name1) {
        int compareByWorkHours = 0;
        compareByWorkHours = workHours1.compareTo(workHours);
        if (compareByWorkHours != 0){
            return compareByWorkHours;
        }
        else{

            Double secondPersonDailyIncome = (dailyPayment1 * (double)workHours1) / 24;
            Double firstPersonDailyIncome = (dailyPayment * (double)workHours) / 24;
            int compaerByDailyIncome = secondPersonDailyIncome.compareTo(firstPersonDailyIncome);
            if (compaerByDailyIncome != 0){
                return compaerByDailyIncome;
            }
            else{
                return name.compareTo(name1);
            }
        }
    }


}
class Person {
    String name;
    Integer workHours;
    Double dailyPayment;
}
