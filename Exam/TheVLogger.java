package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class TheVLogger {
    private int counter = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Vlogger> vLogger = new LinkedHashMap<>();

        while (true) {
            String input = console.readLine();
            if (input.equals("Statistics")) {
                break;
            }
            String[] commands = input.split(" ");
            String name = commands[0];
            String joinedOrFollowed = commands[1];
            if (joinedOrFollowed.equals("joined")) {
                if (!vLogger.containsKey(name)) {
                    vLogger.put(name, new Vlogger());
                }
            } else if (joinedOrFollowed.equals("followed")) {
                String followedPerson = commands[2];
                if (vLogger.containsKey(name) && vLogger.containsKey(followedPerson)) {
                    if (name.equals(followedPerson)) {
                        continue;
                    }
                    boolean arleadyFollowedByHim = false;
                    if (vLogger.get(followedPerson).followingVlogers != null) {
                        for (String s : vLogger.get(followedPerson).followingVlogers) {
                            if (s.equals(name)) {
                                arleadyFollowedByHim = true;
                            }
                        }
                        if (!arleadyFollowedByHim) {
                            Vlogger vloggerPlus = new Vlogger();
                            vloggerPlus.heFollows = vLogger.get(followedPerson).heFollows;
                            vloggerPlus.followers = vLogger.get(followedPerson).followers + 1;
                            if (vLogger.get(followedPerson).followingVlogers == null) {
                                LinkedList<String> followingBlogers = new LinkedList<>();
                                followingBlogers.add(name);
                                vloggerPlus.followingVlogers = followingBlogers;
                            } else {
                                LinkedList<String> folloingBlogers = vLogger.get(followedPerson).followingVlogers;
                                folloingBlogers.add(name);
                                vloggerPlus.followingVlogers = folloingBlogers;
                            }

                            vLogger.put(followedPerson, vloggerPlus);
                        } else {
                            continue;
                        }
                    } else {
                        Vlogger vloggerPlus = new Vlogger();
                        vloggerPlus.heFollows = 0;
                        vloggerPlus.followers = 1;
                        LinkedList<String> followingBlogers = new LinkedList<>();
                        followingBlogers.add(name);
                        vloggerPlus.followingVlogers = followingBlogers;
                        vLogger.put(followedPerson, vloggerPlus);
                    }

                    Vlogger vloggerMinus = new Vlogger();
                    vloggerMinus.heFollows = vLogger.get(name).heFollows + 1;
                    vloggerMinus.followers = vLogger.get(name).followers;
                    if (vLogger.get(name).followingVlogers == null) {
                        LinkedList<String> followingBlogers = new LinkedList<>();
                        vloggerMinus.followingVlogers = followingBlogers;
                    } else {
                        LinkedList<String> folloingBlogers = vLogger.get(name).followingVlogers;
                        vloggerMinus.followingVlogers = folloingBlogers;
                    }

                    vLogger.put(name, vloggerMinus);
                }
            }
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vLogger.size());
        Stream<Map.Entry<String, Vlogger>> sortedFirstOutput = vLogger.entrySet().stream().sorted((x, y) -> SortByFollowersAndOther(x.getValue(), y.getValue()));
        String keyToRemove = "";
        sortedFirstOutput.limit(1).forEach(x -> {
            if (x.getValue().followers == 0) {
                System.out.printf("1. %s : %d followers, %d following&n", x.getKey(), x.getValue().followers, x.getValue().heFollows);
            } else {
                System.out.printf("1. %s : %d followers, %d following%n", x.getKey(), x.getValue().followers, x.getValue().heFollows);
                ArrayList<String> sortedFollowers = new ArrayList<>(vLogger.get(x.getKey()).followingVlogers);
                sortedFollowers.sort(Comparator.naturalOrder());
                for (String sortedFollower : sortedFollowers) {
                    System.out.println("*  " + sortedFollower);
                }
            }
            vLogger.remove(x.getKey());
        });

        Stream<Map.Entry<String, Vlogger>> sortedOtherInput = vLogger.entrySet().stream().sorted((x, y) -> (SortOther(x.getValue(), y.getValue())));

        final FinalCounter test = new FinalCounter(2);
        sortedOtherInput.forEach(x -> {
            System.out.println(test.getVal() + ". " + x.getKey() + " : " + x.getValue().followers + " followers, " + x.getValue().heFollows + " following");
            test.increment();
        });
    }

    private static int SortOther(Vlogger value, Vlogger value1) {
        int sortByFollowers = 0;
        Integer firstFollower = value.followers;
        Integer secondFollower = value1.followers;
        sortByFollowers = secondFollower.compareTo(firstFollower);
        if (sortByFollowers != 0) {
            return sortByFollowers;
        } else {
            int sortByFollowing = 0;
            Integer firstFollowing = value.heFollows;
            Integer secondFollowing = value1.heFollows;
            return firstFollowing.compareTo(secondFollowing);
        }
    }


    private static int SortByFollowersAndOther(Vlogger value, Vlogger value1) {
        int numberOfFollowers = 0;
        Integer firstNumberOfFollowers = value.followers;
        Integer secondNumberOfFollowers = value1.followers;
        numberOfFollowers = secondNumberOfFollowers.compareTo(firstNumberOfFollowers);
        if (numberOfFollowers != 0) {
            return numberOfFollowers;
        } else {
            int following = 0;
            Integer firstFollowing = value.heFollows;
            Integer secondFollowing = value1.heFollows;
            following = firstFollowing.compareTo(secondFollowing);
            return following;
        }
    }
}

class Vlogger {
    LinkedList<String> followingVlogers;
    int heFollows;
    int followers;
}

class FinalCounter {

    private int val;

    public FinalCounter(int intialVal) {
        val = intialVal;
    }

    public void increment() {
        val++;
    }

    public void decrement() {
        val--;
    }

    public int getVal() {
        return val;
    }
}
