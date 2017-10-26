package Exersice6FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> allComingToTheParty = Arrays.stream(console.readLine().split(" ")).collect(Collectors.toList());

        List<String> filters = new ArrayList<>();
        List<String> removeFilters = new ArrayList<>();
        while (true) {
            String input = console.readLine();
            if (input.equals("Print")) {
                break;
            }
            String[] command = input.split(";");
            String filterOrNot = command[0];
            String startsWithEndsWithLength = command[1];
            String lettersInTheStartOrInTheEnd = command[2];
            if (filterOrNot.equals("Add filter")) {
                filters.add(input);
            } else if (filterOrNot.equals("Remove filter")) {
                for (String filter : filters) {
                    String[] commandFilter = filter.split(";");
                    if (commandFilter[1].equals(startsWithEndsWithLength) && commandFilter[2].equals(lettersInTheStartOrInTheEnd)) {
                        filters.remove(filter);
                        break;
                    }
                }
            }
        }

            for (int i = 0; i < filters.size(); i++) {
                String[] command = filters.get(i).split(";");
                String startsWithEndsWithLength = command[1];
                String lettersInTheStartOrInTheEnd = command[2];

                    for (int j = 0; j < allComingToTheParty.size(); j++) {
                        if (startsWithEndsWithLength.equals("Starts with")) {

                            Predicate<String> checkTheLength = x -> x.substring(0, lettersInTheStartOrInTheEnd.length()).length() == lettersInTheStartOrInTheEnd.length();
                            Predicate<String> checkIfItStartsWith = x -> x.substring(0, lettersInTheStartOrInTheEnd.length()).equals(lettersInTheStartOrInTheEnd);

                            if (checkTheLength.test(allComingToTheParty.get(j)) && checkIfItStartsWith.test(allComingToTheParty.get(j))) {
                                allComingToTheParty.remove(j);
                                j--;
                            }
                        } else if (startsWithEndsWithLength.equals("Ends with")) {
                            Predicate<String> checkTheLength = x -> x.substring(x.length() - lettersInTheStartOrInTheEnd.length(),x.length()).length() == lettersInTheStartOrInTheEnd.length();
                            Predicate<String> checkIfItStartsWith = x -> x.substring(x.length() - lettersInTheStartOrInTheEnd.length(),x.length()).equals(lettersInTheStartOrInTheEnd);

                            if (checkTheLength.test(allComingToTheParty.get(j)) && checkIfItStartsWith.test(allComingToTheParty.get(j))) {
                                allComingToTheParty.remove(j);
                                j--;
                            }
                        } else if (startsWithEndsWithLength.equals("Length")) {
                            Predicate<String> checkTheLength = x -> x.length() == Integer.parseInt(lettersInTheStartOrInTheEnd);

                            if (checkTheLength.test(allComingToTheParty.get(j))) {
                                allComingToTheParty.remove(j);
                                j--;
                            }
                        } else if (startsWithEndsWithLength.equals("Contains")) {
                            int index = j;
                            Predicate<String> checkIfContains = x -> allComingToTheParty.get(index).contains(lettersInTheStartOrInTheEnd);

                            if (checkIfContains.test(allComingToTheParty.get(j))) {
                                allComingToTheParty.remove(j);
                                j--;
                            }

                        }
                    }
            }

            for (String s : allComingToTheParty) {
                System.out.print(s + " ");
            }
        }
    }
