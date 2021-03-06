import java.util.ArrayList;

public class InsertionSort {

    public void sort(ArrayList<Integer> arr) {

        for (int i = 1; i < arr.size(); i++) {

            int leftIndex = i - 1;
            boolean shouldChange = false;

            int currentNumber = arr.get(i);
            int leftNumber = arr.get(leftIndex);

            // Find the lower index where it should be placed
            while (currentNumber < leftNumber) {
                shouldChange = true;
                leftIndex--;

                if (leftIndex < 0) {
                    break;
                }

                leftNumber = arr.get(leftIndex);
            }

            if (shouldChange) {
                insert(leftIndex + 1, i, arr);
            }
        }
    }

    private void insert(int leftIndex, int rightIndex, ArrayList<Integer> arr) {

        int previousDeleted = arr.get(leftIndex);
        int rightNumber = arr.get(rightIndex);

        arr.set(leftIndex, rightNumber);

        for (int i = leftIndex; i < rightIndex; i++) {
            int prev = arr.get(i + 1);
            arr.set(i + 1, previousDeleted);
            previousDeleted = prev;
        }
    }
}