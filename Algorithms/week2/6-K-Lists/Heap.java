import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> data = new ArrayList<Integer>();

    public void add(int number) {

        int nextNodeIndex = this.data.size();
        int parentIndex = (nextNodeIndex - 1) / 2;

        this.data.add(number);

        while (nextNodeIndex != 0) {

            parentIndex = (nextNodeIndex - 1) / 2;

            if (this.data.get(parentIndex) > this.data.get(nextNodeIndex)) {
                swap(nextNodeIndex, parentIndex);
            }

            nextNodeIndex = parentIndex;
        }
    }

    public ArrayList<Integer> sort() {

        int size = this.data.size();
        this.heapify(size);

        for (int i = 0; i < this.data.size(); i++) {

            this.swap(0, size - 1);

            this.siftDown(0, size - 1);

            size--;
        }

        return this.data;
    }

    private void heapify(int size) {

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i, size);
        }
    }

    private void swap(int i, int j) {
        int temp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);
    }

    private void siftDown(int parentIndex, int size) {

        for (int i = parentIndex; i <= size / 2 - 1; i++) {
            int currentParent = this.data.get(i);

            int leftChildIndex = 2 * i + 1;
            leftChildIndex = leftChildIndex >= size ? -1 : leftChildIndex;

            int rightChildIndex = 2 * i + 2;
            rightChildIndex = rightChildIndex >= size ? -1 : rightChildIndex;

            int maxChildIndex = i;

            if (leftChildIndex != -1 && rightChildIndex != -1) {
                maxChildIndex = this.data.get(leftChildIndex) < this.data.get(rightChildIndex) ? rightChildIndex
                        : leftChildIndex;
            } else if (leftChildIndex != -1) {
                maxChildIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                maxChildIndex = rightChildIndex;
            }

            if (this.data.get(maxChildIndex) > currentParent) {
                swap(i, maxChildIndex);
                siftDown(maxChildIndex, size);
            } else {
                break;
            }
        }
    }
}
