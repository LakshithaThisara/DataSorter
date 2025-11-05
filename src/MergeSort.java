/*
 * CIT300 Practical Assignment 2
 * Member 2: Merge Sort Implementation
 * -------------------------------------
 * This class implements the Merge Sort algorithm.
 * Merge Sort uses divide-and-conquer and is O(n log n).
 * It also counts the number of merge operations (steps).
 */

public class MergeSort {

    // Step counter for measuring algorithmic operations
    public static int stepCount = 0;

    // Main Merge Sort method (recursive)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;  // find the middle index
            mergeSort(arr, left, mid);     // sort left half
            mergeSort(arr, mid + 1, right); // sort right half
            merge(arr, left, mid, right);   // merge both halves
        }
    }

    // Helper method to merge two sorted halves
    private static void merge(int[] arr, int left, int mid, int right) {
        stepCount++; // count each merge operation
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays for left and right halves
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge temporary arrays back into arr[]
        while (i < n1 && j < n2) {
            stepCount++; // one comparison
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements from L[] (if any)
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy remaining elements from R[] (if any)
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
