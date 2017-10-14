import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        double base = Double.parseDouble(console.nextLine());
        double height = Double.parseDouble(console.nextLine());

        double area = CalcTriangleArea(base,height);

        System.out.printf("%.2f",area);
    }

    private static double CalcTriangleArea(double base,double height){
        return (base*height) / 2 ;
    }
}
