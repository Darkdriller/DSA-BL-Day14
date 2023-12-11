package PalindromeCheck;

/**
 * @author Dhruv
 * @project Day14
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheck {

    public static void main(String[] args) {
        String input = "radar";  // Replace with the input string
        boolean isPalindrome = isPalindrome(input);

        System.out.println("Is the string a palindrome? " + isPalindrome);
    }

    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Convert the string to the same case to make the check case-insensitive
        str = str.toLowerCase();

        // Add characters to the deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Check if the string is a palindrome
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}
