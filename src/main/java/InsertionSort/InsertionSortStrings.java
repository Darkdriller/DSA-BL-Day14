package InsertionSort;

import java.util.Arrays;

/**
 * @author Dhruvjyoti Swain
 */
public class InsertionSortStrings {

    /**
     * Main Class for testing insertion sort.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Example input
        String[] words = {"banana", "apple", "pear", "orange", "grape"};

        // Perform insertion sort on the array
        insertionSort(words);

        // Print the sorted array
        System.out.println("Sorted words: " + Arrays.toString(words));
    }

    /**
     *  Sorts an Array Inplace using Insertion Sort
     * @param words
     */
    public static void insertionSort(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String key = words[i];
            int j = i - 1;

            // Move elements of words[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && words[j].compareTo(key) > 0) {
                words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = key;
        }
    }
}
