package PrimeNumber;

/**
 * @author Dhruv
 * @project Day14
 */
import java.util.Arrays;

public class PrimeNumbersInRange {

    public static void main(String[] args) {
        int n = 1000;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Updating all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        // Printing all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
