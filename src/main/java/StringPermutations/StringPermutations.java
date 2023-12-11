package StringPermutations;
import java.util.*;

public class StringPermutations {

    // Recursive method to generate permutations

    /**
     * Uses recursive method to generate permutations
     * by removing first character getting remaining string
     * and recursively generate permutations
     *
     * @param str
     * @return
     */
    public static Set<String> generatePermutationsRecursive(String str) {
        Set<String> result = new HashSet<>();
        if (str.length() == 0) {
            result.add("");
            return result;
        }

        char firstChar = str.charAt(0);
        String remainingStr = str.substring(1);
        Set<String> words = generatePermutationsRecursive(remainingStr);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                result.add(prefix + firstChar + suffix);
            }
        }
        return result;
    }


    /**
     * Use a queue and add all possible next characters that are in the
     * original string but not already in the permutation more times than
     * they occur in the original string.
     *
     * @param str
     * @return
     */
    public static Set<String> generatePermutationsIterative(String str) {
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.length() == str.length()) {
                result.add(s);
            } else {
                for (char c : str.toCharArray()) {
                    if (countOccurrences(s, c) < countOccurrences(str, c)) {
                        queue.add(s + c);
                    }
                }
            }
        }

        return result;
    }

    /**
     * Count Occurances is used to ensure characters are added to the permutations the correct number of times.
     *
     * @param str
     * @param c
     * @return
     */
    private static int countOccurrences(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abc123";  // Example string
        Set<String> permutationsRecursive = generatePermutationsRecursive(str);
        Set<String> permutationsIterative = generatePermutationsIterative(str);

        // Check if both sets are equal
        if (permutationsRecursive.equals(permutationsIterative)) {
            System.out.println("Both methods return the same set of permutations." + permutationsRecursive);
        } else {
            System.out.println("Methods return different sets of permutations." );
        }
    }
}
