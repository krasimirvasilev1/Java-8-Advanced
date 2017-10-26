package Exersice6FunctionalProgramming;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedAritmetics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

        String commands = console.nextLine();
        while (!commands.equals("end")) {

            List<Integer> newList = new ArrayList<>();
            switch (commands) {
                case "add":
                    Function<List<Integer>, List<Integer>> addNumber = integers -> {
                        for (int i = 0; i < integers.size(); i++) {
                            newList.add(integers.get(i) + 1);
                        }
                        return newList;
                    };
                    numbers = addNumber.apply(numbers);
                    break;
                case "subtract":
                    Function<List<Integer>, List<Integer>> subtrackNumber = integers -> {
                        for (int i = 0; i < integers.size(); i++) {
                            newList.add(integers.get(i) - 1);
                        }
                        return newList;
                    };
                    numbers = subtrackNumber.apply(numbers);
                    break;
                case "multiply":
                    Function<List<Integer>, List<Integer>> multiplyNumber = integers -> {
                        for (int i = 0; i < integers.size(); i++) {
                            newList.add(integers.get(i) * 2);
                        }
                        return newList;
                    };
                    numbers = multiplyNumber.apply(numbers);
                    break;
                case "print":
                    Consumer<List<Integer>> print = x -> {
                        for (Integer integer : x) {
                            System.out.print(integer + " ");
                        }
                    };
                    break;
            }
            commands = console.nextLine();
        }


    }
}
