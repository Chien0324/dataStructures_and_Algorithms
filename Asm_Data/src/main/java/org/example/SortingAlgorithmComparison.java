package org.example;
import java.util.Random;

public class SortingAlgorithmComparison {

    // QuickSort Algorithm
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
            // Recursively sort the left and right subarrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function for QuickSort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1; // Index for elements smaller than the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place the pivot in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return the pivot index
    }

    // MergeSort Algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            // Recursively sort the left and right subarrays
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // Merge the sorted subarrays
            merge(arr, left, mid, right);
        }
    }

    // Merge two subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data into temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy any remaining elements from leftArr[]
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        // Copy any remaining elements from rightArr[]
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // BubbleSort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 100000; // Array size
        // Create random array
        int[] randomArrayBubble = new Random().ints(size, 0, 100000).toArray();
        int[] randomArrayQuick = randomArrayBubble.clone();
        int[] randomArrayMerge = randomArrayBubble.clone();

        // Time for BubbleSort
        long startTime = System.nanoTime();
        bubbleSort(randomArrayBubble);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort run time: " + (endTime - startTime) + " nanoseconds");

        // Time for QuickSort
        startTime = System.nanoTime();
        quickSort(randomArrayQuick, 0, randomArrayQuick.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort run time: " + (endTime - startTime) + " nanoseconds");

        // Time for MergeSort
        startTime = System.nanoTime();
        mergeSort(randomArrayMerge, 0, randomArrayMerge.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort run time: " + (endTime - startTime) + " nanoseconds");
    }
}
