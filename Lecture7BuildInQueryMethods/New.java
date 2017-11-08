package Lecture7BuildInQueryMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class New {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> paca = new ArrayList<>();
        paca.add("1");
        paca.add("4");


        Stream <Integer> integerStream = paca.stream().map(Integer::valueOf);
        }
    }

