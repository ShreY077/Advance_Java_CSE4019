import java.util.Scanner;
import java.math.BigInteger;

public class PowMain {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter a number: ");
       int a = scanner.nextInt();

       System.out.print("Enter a power: ");
       int b = scanner.nextInt();

       System.out.println("Value of a^b: " + power(a, b));

       scanner.close();
   }

   public static BigInteger power(int a, int b) {
       BigInteger result = BigInteger.ONE;
       BigInteger base = BigInteger.valueOf(a);

       while (b > 0) {
           if (b % 2 == 1) {
               result = result.multiply(base);
           }
           base = base.multiply(base);
           b >>= 1;
       }

       return result;
   }
}