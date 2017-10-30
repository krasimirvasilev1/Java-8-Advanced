package ExamMay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

         String [][] matrix = new String[8][8];
         int counterRows = 0;
         int counterColums = 0;

         int invalidMoves = 0;
         int outOfBounds = 0;
         List figuresTakenToThisMoment = new ArrayList();
        while(counterRows < 8){
            String newInput = console.readLine();
            for (int i = 0; i < newInput.length(); i++) {
                if (newInput.charAt(i) == ' '){
                    continue;
                }
                else if (newInput.charAt(i) == '|'){
                    counterColums++;
                }
                else {
                    char kindOfFigure = newInput.charAt(i);
                    matrix[counterRows][counterColums] = String.valueOf(kindOfFigure);
                }
            }
            counterColums = 0;
            counterRows++;
        }

        String positionOfKnight = console.readLine();


        while(true){
            String text = console.readLine();
            if (text.equals("END")){
                break;
            }
            String [] commands = text.split(" -> ");
            String startingPosition = commands[0];
            String endingPosition = commands[1];

            if (!startingPosition.equals(positionOfKnight)){
                invalidMoves++;
                continue;
            }
            else{
                int rowKnight = Integer.parseInt(String.valueOf(startingPosition.charAt(0)));
                int coloumnKnight = Integer.parseInt(String.valueOf(startingPosition.charAt(1)));

                int rowToBeMoved = Integer.parseInt(String.valueOf(endingPosition.charAt(0)));
                int coloumnToBeMoved = Integer.parseInt(String.valueOf(endingPosition.charAt(1)));

                int diffRows = Math.abs(rowKnight - rowToBeMoved);
                int diffColoums = Math.abs(coloumnKnight - coloumnToBeMoved);

                if (diffRows == 2 && diffColoums == 1 || diffColoums == 2 && diffRows == 1){
                    if (rowToBeMoved > 7 || coloumnToBeMoved > 7 || rowToBeMoved < 0 || coloumnToBeMoved < 0){
                        outOfBounds++;
                        continue;
                    }

                    String whatLaysThere = matrix[rowToBeMoved][coloumnToBeMoved];
                    if (whatLaysThere == null){
                        positionOfKnight = String.valueOf(rowToBeMoved) + String.valueOf(coloumnToBeMoved);
                    }
                    else{
                        figuresTakenToThisMoment.add(whatLaysThere);
                        matrix [rowToBeMoved][coloumnToBeMoved] = new String();
                        positionOfKnight = String.valueOf(rowToBeMoved) + String.valueOf(coloumnToBeMoved);
                    }
             }
             else{
                    invalidMoves++;
                }
            }
        }
        String output = String.join(", ",figuresTakenToThisMoment);
        System.out.println("Pieces take: "+ output);
        System.out.println("Invalid moves: "+invalidMoves);
        System.out.println("Board out moves: "+outOfBounds);
    }
}
