package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class EarthQuake {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<List<Integer>> numbers = new ArrayDeque<>();

        List<Integer> seismicities = new ArrayList<>();

        int numberOfEarthQuakes = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfEarthQuakes; i++) {
            String[] currLineOfInput = console.readLine().split("\\s+");

            List<Integer> currLineOfInputInList = new ArrayList<>();
            for (int j = 0; j < currLineOfInput.length; j++) {
                currLineOfInputInList.add(Integer.parseInt(currLineOfInput[j]));
            }

            numbers.addLast(currLineOfInputInList);
        }

        while (!numbers.isEmpty()) {
            List<Integer> currFirst = numbers.removeFirst();
            int currSeismicity = currFirst.get(0);

            seismicities.add(currSeismicity);

            if (currFirst.size() != 1) {
                for (int i = 1; i < currFirst.size(); i++) {
                    if (currSeismicity < currFirst.get(i)){
                        currFirst = currFirst.subList(i,currFirst.size());
                        numbers.addLast(currFirst);
                        break;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer seismicity : seismicities) {
            builder.append(seismicity + " ");
        }

        System.out.println(seismicities.size());
        System.out.println(builder.toString().trim());

    }
}
