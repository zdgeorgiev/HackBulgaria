package sorting;

import java.util.ArrayList;

public class SelectionSort {

    public static void sort(ArrayList<Integer> c) {

        for (int i = 0; i < c.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < c.size(); j++) {
                if (c.get(minIndex) > c.get(j)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = c.get(i);
                c.set(i, c.get(minIndex));
                c.set(minIndex, temp);
            }
        }
    }
}
