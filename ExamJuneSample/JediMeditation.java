package ExamJuneSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;

public class JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(console.readLine());

        List<String> masters = new ArrayList<>();
        List<String> knights = new ArrayList<>();
        List<String> padawans = new ArrayList<>();
        List<String> toshkoAndSav = new ArrayList<>();
        boolean yodaIsHere = false;
        for (int i = 0; i < number; i++) {
            String[] allYodas = console.readLine().split(" ");
            for (int j = 0; j < allYodas.length; j++) {
                switch(allYodas[j].charAt(0)){
                    case 'm':
                        masters.add(allYodas[j]);
                        break;
                    case 'k':
                        knights.add(allYodas[j]);
                        break;
                    case 'p':
                        padawans.add(allYodas[j]);
                        break;
                    case 'y':
                        yodaIsHere = true;
                        break;
                        default:
                            toshkoAndSav.add(allYodas[j]);
                            break;
                }
            }
        }


            if (yodaIsHere) {
                for (String master : masters) {
                    System.out.print(master + " ");
                }
                for (String knight : knights) {
                    System.out.print(knight + " ");
                }
                for (String s : toshkoAndSav) {
                    System.out.print(s + " ");
                }
                for (String padawan : padawans) {
                    System.out.print(padawan + " ");
                }
            }
            else {
                for (String s : toshkoAndSav) {
                    System.out.print(s + " ");
                }
                for (String master : masters) {
                    System.out.print(master + " ");
                }
                for (String knight : knights) {
                    System.out.print(knight + " ");
                }
                for (String padawan : padawans) {
                    System.out.print(padawan + " ");
                }
            }
        }
    }
