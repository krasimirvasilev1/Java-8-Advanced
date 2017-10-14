import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = console.nextInt();
        int m = console.nextInt();

        int index = n;
        BigInteger product = new BigInteger("1");

        do {
            product = product.multiply(new BigInteger(String.valueOf(index)));
            index++;
        }
        while (index <= m);

        System.out.printf("product[%s..%s] = %s",n,m,product);
    }
}
