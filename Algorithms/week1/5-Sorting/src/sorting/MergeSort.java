package sorting;

import java.util.ArrayList;

public class MergeSort {

    public static void sort(ArrayList<Integer> arr) {
        topDownSplit(arr, 0, arr.size());
    }

    private static void topDownSplit(ArrayList<Integer> array, int start, int end) {

        // Only one element it's sorted
        if (end - start < 2) {
            return;
        }

        int middle = (end + start) / 2;
        topDownSplit(array, start, middle);
        topDownSplit(array, middle, end);
        merge(array, start, middle, end);
    }

    private static void merge(ArrayList<Integer> array, int start, int middle, int end) {

        // Arrays which holds the sorted sublist
        ArrayList<Integer> temp = new ArrayList<Integer>();

        int firstArrayIndex = start;
        int secondArrayIndex = middle;

        int firstArrayNumber = array.get(firstArrayIndex);
        int secondArrayNumber = array.get(secondArrayIndex);

        for (int i = 0; i < end - start; i++) {
            if (firstArrayIndex == middle) {
                while (secondArrayIndex != end) {
                    secondArrayNumber = array.get(secondArrayIndex++);
                    temp.add(secondArrayNumber);
                }
                break;
            } else if (secondArrayIndex == end) {
                while (firstArrayIndex != middle) {
                    firstArrayNumber = array.get(firstArrayIndex++);
                    temp.add(firstArrayNumber);
                }
                break;
            }

            firstArrayNumber = array.get(firstArrayIndex);
            secondArrayNumber = array.get(secondArrayIndex);

            if ((firstArrayIndex < middle) && firstArrayNumber < secondArrayNumber) {
                temp.add(firstArrayNumber);
                firstArrayIndex++;
            } else {
                temp.add(secondArrayNumber);
                secondArrayIndex++;
            }
        }

        copy(array, start, end, temp);
    }

    private static void copy(ArrayList<Integer> array, int start, int end, ArrayList<Integer> temp) {

        for (int i = 0; i < end - start; i++) {
            array.set(start + i, temp.get(i));
        }
    }
}
