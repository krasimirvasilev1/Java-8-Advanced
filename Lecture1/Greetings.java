import java.util.Scanner;

public class Greetings{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstName = console.nextLine();
        String lastName = console.nextLine();

        if (firstName.isEmpty()){
            firstName = "*****";
        }

        if (lastName.isEmpty()){
            lastName = "*****";
        }


        System.out.printf("Hello, %s %s!",firstName,lastName);
    }
}
