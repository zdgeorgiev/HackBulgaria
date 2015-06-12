package sorting;

import java.util.ArrayList;

public class InsertionSort {

    public static void sort(ArrayList<Integer> arr) {

        for (int i = 1; i < arr.size(); i++) {

            int currentNumber = arr.get(i);
            int leftIndex = i - 1;

            while (leftIndex != -1 && currentNumber < arr.get(leftIndex)) {
                leftIndex--;
            }

            if (leftIndex + 1 != i) {
                insert(currentNumber, leftIndex + 1, arr);
            }
        }
    }

    private static void insert(int value, int index, ArrayList<Integer> c) {

        int previousElement = c.get(index);
        c.set(index, value);

        for (int i = index; i < c.size() - 1; i++) {
            c.set(i + 1, previousElement);
            previousElement = c.get(i + 1);
        }
    }
}