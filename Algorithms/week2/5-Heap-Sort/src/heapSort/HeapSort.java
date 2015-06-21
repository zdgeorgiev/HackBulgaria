package heapSort;

import java.util.Arrays;

public class HeapSort {

    // Sorts a sequence of integers.
    public void sort(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            heapify(i, sequence);

            System.out.println(Arrays.toString(sequence));
        }
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();

        h.sort(new int[] { 1, 6, 3, 7, 18, 4, 52, 13 });
    }

    private static void heapify(int arrayIndex, int[] arr) {

        int size = arr.length - arrayIndex;

        for (int i = size / 2 + arrayIndex - 1; i >= arrayIndex; i--) {
            shiftDown(i, arrayIndex, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void shiftDown(int parentIndex, int arrayIndex, int[] arr) {

        int size = arr.length;

        for (int i = parentIndex; i <= (size - arrayIndex) / 2 + arrayIndex - 1; i++) {
            int currentParent = arr[i];

            int leftChildIndex = 2 * i - arrayIndex + 1;
            leftChildIndex = leftChildIndex >= size ? -1 : leftChildIndex;

            int rightChildIndex = 2 * i - arrayIndex + 2;
            rightChildIndex = rightChildIndex >= size ? -1 : rightChildIndex;

            int minChildIndex = i;

            if (leftChildIndex != -1 && rightChildIndex != -1) {
                minChildIndex = arr[leftChildIndex] > arr[rightChildIndex] ? rightChildIndex : leftChildIndex;
            } else if (leftChildIndex != -1) {
                minChildIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                minChildIndex = rightChildIndex;
            }

            if (arr[minChildIndex] < currentParent) {
                swap(i, minChildIndex, arr);
                shiftDown(minChildIndex, arrayIndex, arr);
            }
        }
    }
}