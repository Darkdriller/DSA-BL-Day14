package GenericSortAndSearch;

import java.util.Arrays;

/**
 * @author Dhruv
 * @project Day14
 */
public class GenericSearchAndSort {

    /**
     * Insertion sort Implemented using Java Generics
     *
     * @param words
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] words) {
        for (int i = 1; i < words.length; i++) {
            T key = words[i];
            int j = i - 1;

            // Move elements of words[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && words[j].compareTo(key) > 0) {
                words[j + 1] = words[j];
                j = j - 1;
            }
            words[j + 1] = key;
        }
    }

    /**
     * Bubble Sort implemented using Java Generics
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap arr[j] and arr[j + 1]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    /**
     * Driver Code for MergeSort
     *
     * @param array
     * @param l
     * @param r
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array, int l, int r) {
        if (r - l > 1) {
            int mid = l + (r - l) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid, r);
            merge(array, l, mid, r);
        }
    }

    /**
     * Merge helper function for mergeSort
     *
     * @param array
     * @param l
     * @param mid
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void merge(T[] array, int l, int mid, int r) {
        T[] leftArray = Arrays.copyOfRange(array, l, mid);
        T[] rightArray = Arrays.copyOfRange(array, mid, r);

        int i = 0, j = 0, k = l;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) array[k++] = leftArray[i++];
        while (j < rightArray.length) array[k++] = rightArray[j++];
    }

    /**
     * Generics used for Binary Search
     *
     * @param array
     * @param key
     * @return
     * @param <T>
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid].compareTo(key) == 0) {
                return mid;  // key found
            }
            if (array[mid].compareTo(key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // key not found
    }


}
