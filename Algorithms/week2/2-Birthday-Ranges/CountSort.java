import java.util.List;

public class CountSort {
    private static int[] numbers;

    public static void sort(List<Integer> arr) {
        numbers = new int[366];
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

    private static void fillHistogram(List<Integer> c) {
        for (int i = 0; i < c.size(); i++) {
            numbers[c.get(i)]++;
        }
    }
}
