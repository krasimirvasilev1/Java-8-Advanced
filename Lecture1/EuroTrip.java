import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double quantity = console.nextDouble();

        BigDecimal priceInLeva = new BigDecimal(quantity*1.20);
        BigDecimal levaInDeutscheMarks = new BigDecimal("4210500000000");

        BigDecimal result = priceInLeva.multiply(levaInDeutscheMarks);

        System.out.printf("%.2f marks",result);
    }
}
