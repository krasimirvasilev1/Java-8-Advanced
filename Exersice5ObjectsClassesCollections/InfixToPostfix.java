package Exersice5ObjectsClassesCollections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<String> numbersAndSymbolsBetweenScopes = new ArrayDeque<>();
        ArrayDeque<String> allOtherSymbols = new ArrayDeque<>();

        String [] text = console.nextLine().split(" ");

        for (int i = 0; i < text.length; i++) {
            if (isNumeric(text[i])){
                numbersAndSymbolsBetweenScopes.add(text[i]);
            }
            else if ( !text[i].equals("+") && !text[i].equals("-") && !text[i].equals("/") && !text[i].equals("*") &&
                    !text[i].equals("(") && !text[i].equals(")")){
                numbersAndSymbolsBetweenScopes.add(text[i]);
            }
            else{
                String newChar = text[i];

                switch (newChar){
                    case "/":
                        if (allOtherSymbols.isEmpty() || !allOtherSymbols.peek().equals("*") && !allOtherSymbols.peek().equals("/")){
                            allOtherSymbols.push("/");
                        }
                        else{
                            numbersAndSymbolsBetweenScopes.add(allOtherSymbols.pop());
                            allOtherSymbols.push("/");
                        }
                        break;
                    case "*":

                        if (allOtherSymbols.isEmpty() || !allOtherSymbols.peek().equals("/") && !allOtherSymbols.peek().equals("*")){
                            allOtherSymbols.push("*");
                        }
                        else{
                            numbersAndSymbolsBetweenScopes.add(allOtherSymbols.pop());
                            allOtherSymbols.push("*");
                        }
                        break;
                    case "-":
                        if (allOtherSymbols.isEmpty() || !allOtherSymbols.peek().equals("+") && !allOtherSymbols.peek().equals("-")){
                            allOtherSymbols.push("-");
                        }
                        else{
                            numbersAndSymbolsBetweenScopes.add(allOtherSymbols.pop());
                            allOtherSymbols.push("-");
                        }
                        break;
                    case "+":
                        if (allOtherSymbols.isEmpty() || !allOtherSymbols.peek().equals("-") && !allOtherSymbols.peek().equals("+")){
                            allOtherSymbols.push("+");
                        }
                        else{
                            numbersAndSymbolsBetweenScopes.add(allOtherSymbols.pop());
                            allOtherSymbols.push("+");
                        }
                        break;
                    case "(":
                        allOtherSymbols.push("(");
                        break;
                    case ")":
                        String symbol = allOtherSymbols.pop();
                        while (!symbol.equals("(")){
                            numbersAndSymbolsBetweenScopes.add(symbol);
                            symbol = allOtherSymbols.pop();
                        }
                        break;
                }
            }
        }


        while(!allOtherSymbols.isEmpty()){
            numbersAndSymbolsBetweenScopes.add(allOtherSymbols.pop());
        }
        while(!numbersAndSymbolsBetweenScopes.isEmpty()){
            System.out.print(numbersAndSymbolsBetweenScopes.poll() + " ");
        }
    }

    private static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
