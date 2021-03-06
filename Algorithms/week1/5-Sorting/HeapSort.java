import java.util.ArrayList;

public class HeapSort {

    public void sort(ArrayList<Integer> sequence) {

        heapify(sequence, sequence.size());

        int size = sequence.size() - 1;

        for (int i = 0; i < sequence.size(); i++) {

            swap(0, size, sequence);

            siftDown(0, size, sequence);

            size--;
        }
    }

    private void heapify(ArrayList<Integer> arr, int size) {

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i, size, arr);
        }
    }

    private void swap(int i, int j, ArrayList<Integer> arr) {

        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private void siftDown(int parentIndex, int size, ArrayList<Integer> arr) {

        for (int i = parentIndex; i <= size / 2 - 1; i++) {
            int currentParent = arr.get(i);

            int leftChildIndex = 2 * i + 1;
            leftChildIndex = leftChildIndex >= size ? -1 : leftChildIndex;

            int rightChildIndex = 2 * i + 2;
            rightChildIndex = rightChildIndex >= size ? -1 : rightChildIndex;

            int maxChildIndex = i;

            if (leftChildIndex != -1 && rightChildIndex != -1) {
                maxChildIndex = arr.get(leftChildIndex) < arr.get(rightChildIndex) ? rightChildIndex : leftChildIndex;
            } else if (leftChildIndex != -1) {
                maxChildIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                maxChildIndex = rightChildIndex;
            }

            if (arr.get(maxChildIndex) > currentParent) {
                swap(i, maxChildIndex, arr);
                siftDown(maxChildIndex, size, arr);
            } else {
                break;
            }
        }
    }
}