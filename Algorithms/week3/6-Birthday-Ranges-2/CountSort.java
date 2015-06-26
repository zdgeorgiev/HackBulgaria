import java.util.ArrayList;

public class CountSort {
    public static int[] numbers = new int[1_000];

    public static int[] getHistogram(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            numbers[arr.get(i)]++;
        }

        return numbers;
    }
}