/*
 * CIT300 Practical Assignment 2
 * Member 4: Main Program, Data Generation & Comparison
 * -------------------------------------------------------
 * This class provides the main console-based interface.
 * It lets users input numbers manually or generate random data,
 * perform sorting using Bubble, Merge, or Quick Sort,
 * and compare their performance (time + step count).
 */

import java.util.*;

public class DataSorterMain {
    private static Scanner sc = new Scanner(System.in);
    private static int[] data = null; // array that holds user data

    public static void main(String[] args) {
        int choice;
        do {
            // Display menu
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            // Classic switch-case syntax for Java 8 compatibility
            switch (choice) {
                case 1:
                    enterNumbers();
                    break;
                case 2:
                    generateRandomData();
                    break;
                case 3:
                    runSort("Bubble");
                    break;
                case 4:
                    runSort("Merge");
                    break;
                case 5:
                    runSort("Quick");
                    break;
                case 6:
                    compareAll();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 7);
    }

    // Helper to safely get integer input from user
    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // Option 1: Let user manually enter numbers
    private static void enterNumbers() {
        System.out.print("Enter number of elements: ");
        int n = getIntInput();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            data[i] = getIntInput();
        }
        System.out.println("Data successfully entered!");
    }

    // Option 2: Automatically generate random numbers
    private static void generateRandomData() {
        System.out.print("Enter number of random elements: ");
        int n = getIntInput();
        Random rand = new Random();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(100); // random numbers 0–99
        }
        System.out.println("Random data generated: " + Arrays.toString(data));
    }

    // Run selected sort algorithm and show result
    private static void runSort(String type) {
        if (data == null) {
            System.out.println("No data! Please enter or generate data first.");
            return;
        }

        // Copy data so original list stays unchanged
        int[] temp = Arrays.copyOf(data, data.length);
        long startTime = 0, endTime = 0;
        int steps = 0;

        // Choose sorting method
        if ("Bubble".equals(type)) {
            startTime = System.nanoTime();
            BubbleSort.bubbleSort(temp);
            endTime = System.nanoTime();
            steps = BubbleSort.stepCount;
        } else if ("Merge".equals(type)) {
            startTime = System.nanoTime();
            MergeSort.mergeSort(temp, 0, temp.length - 1);
            endTime = System.nanoTime();
            steps = MergeSort.stepCount;
        } else if ("Quick".equals(type)) {
            startTime = System.nanoTime();
            QuickSort.quickSort(temp, 0, temp.length - 1);
            endTime = System.nanoTime();
            steps = QuickSort.stepCount;
        }

        // Display sorted output and performance details
        System.out.println(type + " Sort Result: " + Arrays.toString(temp));
        System.out.printf("Time: %.3f ms | Steps: %d%n", (endTime - startTime) / 1e6, steps);
    }

    // Option 6: Compare all algorithms in a summary table
    private static void compareAll() {
        if (data == null) {
            System.out.println("Please input or generate data first!");
            return;
        }

        String[] sorts = {"Bubble", "Merge", "Quick"};
        System.out.printf("%-10s %-15s %-10s%n", "Algorithm", "Time (ms)", "Steps");
        System.out.println("--------------------------------------");

        for (String type : sorts) {
            int[] temp = Arrays.copyOf(data, data.length);
            long start = System.nanoTime();
            int steps = 0;

            if ("Bubble".equals(type)) {
                BubbleSort.bubbleSort(temp);
                steps = BubbleSort.stepCount;
            } else if ("Merge".equals(type)) {
                MergeSort.mergeSort(temp, 0, temp.length - 1);
                steps = MergeSort.stepCount;
            } else if ("Quick".equals(type)) {
                QuickSort.quickSort(temp, 0, temp.length - 1);
                steps = QuickSort.stepCount;
            }

            long end = System.nanoTime();
            System.out.printf("%-10s %-15.3f %-10d%n", type, (end - start) / 1e6, steps);
        }
    }
}
