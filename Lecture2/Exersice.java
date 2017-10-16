package Lecture2;

public class Exersice {
    public static void main(String[] args) {

        String [][] demensionalArrayString = new String[3][5];
        Integer [][] demensionalArrayNumber = new Integer[3][5];


        for (int i = 0; i < demensionalArrayString.length; i++) {
            for (int j = 0; j < demensionalArrayString[i].length ; j++) {
                String something = "";
                for (int k = 0; k <= i+j; k++) {
                    something += "*";
                }
                demensionalArrayString [i][j] = something;
                demensionalArrayNumber [i][j] = i + j;
            }
        }

        for (String[] strings : demensionalArrayString) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

        for (Integer[] ints : demensionalArrayNumber) {
            for (Integer anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();

        }

    }
}
