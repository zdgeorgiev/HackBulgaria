package sorting;

import java.util.ArrayList;

public class QuickSort {

    public static void sort(ArrayList<Integer> arr) {
        quickSort(0, arr.size(), arr);
    }

    private static void quickSort(int start, int end, ArrayList<Integer> arr) {

        if (end - start < 2) {
            return;
        }

        int pivotIndex = (end + start) / 2;
        int pivotElement = arr.get(pivotIndex);

        // Pull back all bigger than the pivot
        for (int i = 0; i < pivotIndex; i++) {
            int currentElement = arr.get(i);

            if (currentElement > pivotElement) {
                arr.remove(i);
                arr.add(end - 1, currentElement);
                pivotIndex--;
                i--;
            }
        }

        // Pull front all smaller than the pivot
        for (int i = pivotIndex + 1; i < end; i++) {
            int currentElement = arr.get(i);

            if (currentElement < pivotElement) {
                arr.remove(i);
                arr.add(start, currentElement);
                pivotIndex++;
            }
        }

        quickSort(start, pivotIndex, arr);
        quickSort(pivotIndex + 1, end, arr);
    }
}