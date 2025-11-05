public class QuickSort {

    // Step counter for measuring algorithmic operations
    public static int stepCount = 0;

    // Quick Sort recursive function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method that places the pivot element in correct position
    private static int partition(int[] arr, int low, int high) {
        stepCount++; // count partition as one operation
        int pivot = arr[high]; // pivot is last element
        int i = (low - 1);     // index of smaller element

        // Traverse through all elements and swap when needed
        for (int j = low; j < high; j++) {
            stepCount++; // comparison
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return the pivot index
    }
}