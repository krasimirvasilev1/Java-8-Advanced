package Lecture5ObjectsClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
       BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Set<String> allGuests = new TreeSet<>();
       String guestsCome = console.readLine();
       while (!"PARTY".equals(guestsCome)){
           allGuests.add(guestsCome);

           guestsCome = console.readLine();
       }

       String guestsCheck = console.readLine();
        while (!"END".equals(guestsCheck)){
            if (allGuests.contains(guestsCheck)){
                allGuests.remove(guestsCheck);
            }

            guestsCheck = console.readLine();
        }

        System.out.println(allGuests.size());
        for (String allGuest : allGuests) {
            if (Character.isDigit(allGuest.charAt(0))){
                System.out.println(allGuest);
            }
        }
        for (String allGuest : allGuests) {
            if (Character.isLetter(allGuest.charAt(0))){
                System.out.println(allGuest);
            }
        }
    }
}
