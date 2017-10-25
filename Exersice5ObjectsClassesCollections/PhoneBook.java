package Exersice5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,String> phonebook = new HashMap<>();
        String [] inputPhoneBook = console.readLine().split("-");

        while(!inputPhoneBook[0].equals("search")){
            phonebook.put(inputPhoneBook[0],inputPhoneBook[1]);

            inputPhoneBook = console.readLine().split("-");
        }

        while (true){
            String inputSearch = console.readLine();
            if (inputSearch.equals("stop")){
                break;
            }
            if (phonebook.containsKey(inputSearch)){
                for (String s : phonebook.keySet()) {
                    if (s.equals(inputSearch)){
                        System.out.println(s + " -> "+ phonebook.get(s));
                    }
                }
            }
            else{
                System.out.printf("Contact %s does not exist.%n",inputSearch);
            }

        }
    }
}
