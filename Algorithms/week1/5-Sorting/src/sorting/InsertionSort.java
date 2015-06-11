package sorting;

import java.util.ArrayList;

public class InsertionSort {

    public static void sort(ArrayList<Integer> c) {

        for (int i = 1; i < c.size(); i++) {

            int currentNumber = c.get(i);
            int leftIndex = i - 1;

            while (leftIndex != -1 && currentNumber < c.get(leftIndex)) {
                leftIndex--;
            }

            if (leftIndex + 1 != i) {
                insert(currentNumber, leftIndex + 1, c);
            }
        }
    }

    private static void insert(int value, int index, ArrayList<Integer> c) {

        int previousElement = c.get(index);
        c.set(index, value);

        for (int i = index; i < c.size() - 1; i++) {
            int prev = c.get(i + 1);
            c.set(i + 1, previousElement);
            previousElement = prev;
        }
    }
}