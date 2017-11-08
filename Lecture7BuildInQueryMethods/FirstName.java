package Lecture7BuildInQueryMethods;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> names = Arrays.stream(console.nextLine().split(" ")).collect(Collectors.toList());
        HashSet<Character> letters = new HashSet<>();
        Stream.of(console.nextLine().split("\\s+")).map(s -> s.toLowerCase().charAt(0)).forEach(s -> letters.add(s));

        Optional<String> firstName = names.stream().filter(x -> letters.contains(x.toLowerCase().charAt(0))).sorted().findFirst();

        if (firstName.isPresent()){
            System.out.println(firstName.get());
        }
        else{
            System.out.println("No match");
        }
    }
}
