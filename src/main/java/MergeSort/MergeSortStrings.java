package MergeSort;

import java.util.Arrays;

/**
 * @author Dhruv
 * @project Day14
 **/



public class MergeSortStrings {

    public static void main(String[] args) {
        String[] arr = {"pear", "apple", "orange", "grape", "banana"};
        mergeSort(arr, 0, arr.length);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }


    /**
     *  Main function that sorts arr[l..r] using merge()
     *
     *
     * @param String Array arr
     * @param int Index l
     * @param int Index r
     */
    public static void mergeSort(String[] arr, int l, int r) {
        if (r - l > 1) {
            int mid = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, mid);
            mergeSort(arr, mid, r);

            // Merge the sorted halves
            merge(arr, l, mid, r);
        }
    }

    /**
     * Merges two subarrays of arr[] which are sorted
     *
     * @param String Array arr
     * @param int Index l
     * @param int Index mid
     * @param int Index r
     */
    public static void merge(String[] arr, int l, int mid, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - l;
        int n2 = r - mid;

        // Create temp arrays
        String[] L = new String[n1];
        String[] R = new String[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, mid, R, 0, n2);

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
