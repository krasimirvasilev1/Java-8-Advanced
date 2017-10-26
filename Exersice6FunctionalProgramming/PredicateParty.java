package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List <String> peopleInvited = Arrays.stream(console.readLine().split(" ")).collect(Collectors.toList());
        while(true){
            String  input = console.readLine();
            if (input.equals("Party!")){
                break;
            }

            String [] command = input.split(" ");

            String doubleOrRemove = command[0];
            String endsWithStartsWithLength = command[1];
            String requirement = command[2];
            for (int i = 0; i < peopleInvited.size(); i++) {
                if (doubleOrRemove.equals("Double")) {
                    if (endsWithStartsWithLength.equals("StartsWith")) {

                        Predicate<String> checkTheLength = x -> x.substring(0, requirement.length()).length() == requirement.length();
                        Predicate<String> checkIfItStartsWith = x -> x.substring(0, requirement.length()).equals(requirement);

                        if (checkTheLength.test(peopleInvited.get(i)) && checkIfItStartsWith.test(peopleInvited.get(i))) {
                            peopleInvited.add(i, peopleInvited.get(i));
                            i++;
                        }
                    } else if (endsWithStartsWithLength.equals("EndsWith")) {
                        Predicate<String> checkTheLength = x -> x.substring(x.length()- requirement.length(), x.length()).length() == requirement.length();
                        Predicate<String> checkIfItStartsWith = x -> x.substring(x.length()- requirement.length(), x.length()).equals(requirement);

                        if (checkTheLength.test(peopleInvited.get(i)) && checkIfItStartsWith.test(peopleInvited.get(i))) {
                            peopleInvited.add(i, peopleInvited.get(i));
                            i++;
                        }
                    } else if (endsWithStartsWithLength.equals("Length")) {
                        Predicate<String> checkTheLength = x -> x.length() == Integer.parseInt(requirement);

                        if (checkTheLength.test(peopleInvited.get(i))) {
                            peopleInvited.add(i, peopleInvited.get(i));
                            i++;
                        }
                    }
                }
                else if (doubleOrRemove.equals("Remove")) {
                    if (endsWithStartsWithLength.equals("StartsWith")) {

                        Predicate<String> checkTheLength = x -> x.substring(0, requirement.length()).length() == requirement.length();
                        Predicate<String> checkIfItStartsWith = x -> x.substring(0, requirement.length()).equals(requirement);

                        if (checkTheLength.test(peopleInvited.get(i)) && checkIfItStartsWith.test(peopleInvited.get(i))) {
                            peopleInvited.remove(i);
                            i--;
                        }
                    } else if (endsWithStartsWithLength.equals("EndsWith")) {
                        Predicate<String> checkTheLength = x -> x.substring(x.length()- requirement.length(), x.length()).length() == requirement.length();
                        Predicate<String> checkIfItStartsWith = x -> x.substring(x.length()- requirement.length(), x.length()).equals(requirement);

                        if (checkTheLength.test(peopleInvited.get(i)) && checkIfItStartsWith.test(peopleInvited.get(i))) {
                            peopleInvited.remove(i);
                            i--;
                        }
                    } else if (endsWithStartsWithLength.equals("Length")) {
                        Predicate<String> checkTheLength = x -> x.length() == Integer.parseInt(requirement);

                        if (checkTheLength.test(peopleInvited.get(i))) {
                            peopleInvited.remove(i);
                            i--;
                        }
                    }
                }
            }

        }

        if (peopleInvited.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }
        else{
            System.out.println(String.join(", ",peopleInvited.toString().replace("[","").replace("]",""))+ " are going to the party!");
        }
    }
}
