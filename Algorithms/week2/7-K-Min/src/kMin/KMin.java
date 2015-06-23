package kMin;

import java.util.Arrays;
import java.util.List;

public class KMin {

    // Finds the k-th minimum element in an unsorted collection.
    public int kthMinimum(List<Integer> numbers, int k) {

        int minNumber = Integer.MAX_VALUE;
        int count = 0;

        heapify(numbers, numbers.size());

        int size = numbers.size() - 1;

        while (k > count) {

            if (numbers.get(0) != minNumber) {
                minNumber = numbers.get(0);
                count++;
                swap(0, size, numbers);
            }

            siftDown(0, size, numbers);

            size--;
        }

        return minNumber;
    }

    public static void main(String[] args) {
        KMin kmin = new KMin();

        List<Integer> numbers = Arrays.asList(5, 2, 3, 6, 1, 4);

        System.out.println(kmin.kthMinimum(numbers, 1));
        System.out.println(kmin.kthMinimum(numbers, 3));
        System.out.println(kmin.kthMinimum(numbers, 6));
    }

    private static void heapify(List<Integer> arr, int size) {

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i, size, arr);
        }
    }

    private static void swap(int i, int j, List<Integer> arr) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private static void siftDown(int parentIndex, int size, List<Integer> arr) {

        for (int i = parentIndex; i <= size / 2 - 1; i++) {
            int currentParent = arr.get(i);

            int leftChildIndex = 2 * i + 1;
            leftChildIndex = leftChildIndex >= size ? -1 : leftChildIndex;

            int rightChildIndex = 2 * i + 2;
            rightChildIndex = rightChildIndex >= size ? -1 : rightChildIndex;

            int maxChildIndex = i;

            if (leftChildIndex != -1 && rightChildIndex != -1) {
                maxChildIndex = arr.get(leftChildIndex) > arr.get(rightChildIndex) ? rightChildIndex : leftChildIndex;
            } else if (leftChildIndex != -1) {
                maxChildIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                maxChildIndex = rightChildIndex;
            }

            if (arr.get(maxChildIndex) < currentParent) {
                swap(i, maxChildIndex, arr);
                siftDown(maxChildIndex, size, arr);
            } else {
                break;
            }
        }
    }
}