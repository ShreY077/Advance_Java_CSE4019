import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
    public static List<Integer> generatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }
        return primes;
    }
}
