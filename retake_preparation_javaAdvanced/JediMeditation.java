package retake_preparation_javaAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(console.readLine());
        List<String> jediMasters = new LinkedList<>();
        List<String> jediKnights = new LinkedList<>();
        List<String> padawans = new LinkedList<>();

        boolean isTheYodaAppear = false;
        List<String> toshkoAndSlav = new LinkedList<>();

        List<String> output = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            String[] jedies = console.readLine().split("\\s+");

            for (int j = 0; j < jedies.length; j++) {
                switch (jedies[j].charAt(0)) {
                    case 'm':
                        jediMasters.add(jedies[j]);
                        break;
                    case 'k':
                        jediKnights.add(jedies[j]);
                        break;
                    case 'p':
                        padawans.add(jedies[j]);
                        break;
                    case 'y':
                        isTheYodaAppear = true;
                        break;
                    default:
                        toshkoAndSlav.add(jedies[j]);
                        break;
                }
            }
        }

        if (isTheYodaAppear) {
            output.addAll(jediMasters);
            output.addAll(jediKnights);
            output.addAll(toshkoAndSlav);
            output.addAll(padawans);
        } else {
            output.addAll(toshkoAndSlav);
            output.addAll(jediMasters);
            output.addAll(jediKnights);
            output.addAll(padawans);
        }

        System.out.println(String.join(" ",output));
    }
}
