/*
 * CIT300 Practical Assignment 2
 * Member 1: Bubble Sort Implementation
 * -------------------------------------
 * This class implements the Bubble Sort algorithm.
 * It counts the number of steps (comparisons/swaps)
 * to demonstrate algorithmic complexity.
 */

public class BubbleSort {

    // Variable to count how many steps (comparisons/swaps) are made
    public static int stepCount = 0;

    // Bubble Sort method (sorts in ascending order)
    public static void bubbleSort(int[] arr) {
        stepCount = 0;  // reset counter before each run
        int n = arr.length;

        // Outer loop: runs through the array n-1 times
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                stepCount++;  // one comparison = one step
                // Swap if the current element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}