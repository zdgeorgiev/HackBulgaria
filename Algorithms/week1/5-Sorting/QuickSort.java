import java.util.ArrayList;

public class QuickSort {

    public void sort(ArrayList<Integer> arr) {
        quickSort(0, arr.size(), arr);
    }

    private void quickSort(int start, int end, ArrayList<Integer> arr) {

        if (end - start < 2) {
            return;
        }

        int pivot = arr.get(end - 1);
        int pivotIndex = start;
        int temp;

        for (int i = start; i < end; i++) {
            if (arr.get(i) < pivot) {
                temp = arr.get(i);
                arr.set(i, arr.get(pivotIndex));
                arr.set(pivotIndex, temp);

                pivotIndex++;
            }
        }

        temp = arr.get(pivotIndex);
        arr.set(pivotIndex, pivot);
        arr.set(end - 1, temp);

        quickSort(start, pivotIndex, arr);
        quickSort(pivotIndex + 1, end, arr);
    }
}