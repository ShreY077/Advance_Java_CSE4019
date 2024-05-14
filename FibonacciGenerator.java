public class FibonacciGenerator {
    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = prev + current;
            prev = temp;
        }
        return current;
    }
}
