import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double kilometers = Double.parseDouble(console.nextLine());
        String timeOfDay = console.next();

        double totalPrice = 0;

        if (kilometers < 20){
            if (timeOfDay.equals("day")){
                totalPrice = 0.70 + (kilometers* 0.79);
            }
            else {
                totalPrice = 0.70 + (kilometers * 0.9);
            }
        }
        else if(kilometers < 100){
            totalPrice = kilometers * 0.09;
        }
        else {
            totalPrice = kilometers * 0.06;
        }

        System.out.printf("%.2f",totalPrice);
    }
}
