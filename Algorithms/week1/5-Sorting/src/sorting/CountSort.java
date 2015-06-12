package sorting;

import java.util.ArrayList;

public class CountSort {
    private static int[] numbers = new int[1_000];

    public static void sort(ArrayList<Integer> arr) {
        fillHistogram(arr);

        arr.clear();
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            if (currentNumber != 0) {
                for (int j = 0; j < currentNumber; j++) {
                    arr.add(i);
                }
            }
        }
    }

    private static void fillHistogram(ArrayList<Integer> c) {
        for (int i = 0; i < c.size(); i++) {
            numbers[c.get(i)]++;
        }
    }
}
