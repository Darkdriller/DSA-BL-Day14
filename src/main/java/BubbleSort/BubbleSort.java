package BubbleSort;

import java.util.Arrays;

public class BubbleSort{

    public static void main(String[] args) {
        // Example input
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        // Perform bubble sort on the array
        bubbleSort(numbers);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    int temp = arr[j];
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
}
