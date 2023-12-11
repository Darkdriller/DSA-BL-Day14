package PrimeNumber;

/**
 * @author Dhruv
 * @project Day14
 */
import java.util.*;

public class PrimeNumbersExtended{

    public static void main(String[] args) {
        int n = 1000;
        List<Integer> primes = getPrimes(n);

        System.out.println("Prime numbers that are palindromes:");
        for (int prime : primes) {
            if (isPalindrome(prime)) {
                System.out.print(prime + " ");
            }
        }
        System.out.println("\n\nPrime numbers that are anagrams of each other:");
        findAnagramPrimes(primes);
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        List<Integer> primeList = new ArrayList<>();

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeList.add(i);
            }
        }

        return primeList;
    }

    private static boolean isPalindrome(int number) {
        int palindrome = number;
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return number == reverse;
    }

    private static void findAnagramPrimes(List<Integer> primes) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int prime : primes) {
            char[] arr = String.valueOf(prime).toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(prime);
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                System.out.println(map.get(key));
            }
        }
    }
}
