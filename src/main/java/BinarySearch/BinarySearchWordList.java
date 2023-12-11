package BinarySearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author  Dhruvjyoti Swain
 */
public class BinarySearchWordList {

    /**
     * Main class that looks for file and handles exceptions
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // Read words from file
            Scanner fileScanner = new Scanner(new File("C:\\Users\\Dhruv\\IdeaProjects\\Day14\\src\\main\\java\\BinarySearch\\words.txt"));
            String[] words = fileScanner.nextLine().split(",");
            fileScanner.close();

            // Sort the words
            Arrays.sort(words);

            // Get user input for word to search
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter a word to search: ");
            String searchWord = inputScanner.nextLine();
            inputScanner.close();

            // Perform binary search
            int result = binarySearch(words, searchWord);

            // Output result
            if (result >= 0) {
                System.out.println("Word found in the list.");
            } else {
                System.out.println("Word not found in the list.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Binary search code which searches for word using sorted array.
     *
     * @param Array(Sorted) words
     * @param String searchWord
     * @return index if found else -1
     */
    public static int binarySearch(String[] words, String searchWord) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int res = searchWord.compareTo(words[mid]);

            // Check if searchWord is present at mid
            if (res == 0)
                return mid;

            // If searchWord greater, ignore left half
            if (res > 0)
                left = mid + 1;

                // If searchWord is smaller, ignore right half
            else
                right = mid - 1;
        }

        return -1;
    }
}
