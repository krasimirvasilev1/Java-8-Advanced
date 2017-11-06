package AugustExam;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] flowersAsArray = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int [] buckets = Arrays.stream(console.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Integer [] flowersAsArrayInteger = new Integer[flowersAsArray.length];
        int i = 0;
        for (int ii : flowersAsArray) {
            flowersAsArrayInteger[i++] = ii;
        }

        LinkedList<Integer> flowers = new LinkedList<>(Arrays.asList(flowersAsArrayInteger));
        ArrayDeque<Integer> bucketsInQueue = new ArrayDeque<>();
        for (int j = buckets.length - 1; j >= 0; j--) {
            bucketsInQueue.add(buckets[j]);
        }

        int remainingValue = 0;
        List<Integer> secondNatureFlowers = new ArrayList<>();
        while(true){
            if(flowers.isEmpty() || bucketsInQueue.isEmpty()){
                break;
            }

            int flower = flowers.get(0);
            int bucket = bucketsInQueue.peek() + remainingValue;
            if (bucket > flower){
                remainingValue = (bucket - flower);
                bucketsInQueue.poll();
                if (bucketsInQueue.isEmpty()){
                    bucketsInQueue.add(remainingValue);
                    remainingValue = 0;
                }
                flowers.remove(0);
            }
            else if (bucket < flower){
                flowers.removeFirst();
                remainingValue = 0;
                int valueToReplace = flower - bucket;
                flowers.addFirst(valueToReplace);
                bucketsInQueue.poll();
            }
            else{
                flowers.removeFirst();
                secondNatureFlowers.add(flower);
                bucketsInQueue.poll();
                remainingValue = 0;
            }
        }

        boolean isNotEmpty = false;
        if (secondNatureFlowers.isEmpty()){
            isNotEmpty = true;
        }
        if (flowers.isEmpty()){
            while(!bucketsInQueue.isEmpty()){
                System.out.print(bucketsInQueue.poll() + remainingValue+ " ");
                remainingValue = 0;
            }

        }
        else if (bucketsInQueue.isEmpty()){

            for (Integer flower : flowers) {
                System.out.print(flower + " ");
            }
        }

        System.out.println();
        if (!isNotEmpty){

            for (Integer secondNatureFlower : secondNatureFlowers) {
                System.out.print(secondNatureFlower + " ");
            }
        }
        else{
            System.out.println("None");
        }
    }
}
