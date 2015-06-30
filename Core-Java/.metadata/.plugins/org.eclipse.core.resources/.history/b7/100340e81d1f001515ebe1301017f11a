package sorting;

import java.util.ArrayList;

public class SelectionSort {

    public static void sort(ArrayList<Integer> arr) {

        for (int i = 0; i < arr.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(minIndex) > arr.get(j)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
    }
}
