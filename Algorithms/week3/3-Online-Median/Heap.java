import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {

    private ArrayList<T> arr;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.arr = new ArrayList<T>();
    }

    public void insert(T value) {
        this.arr.add(value);

        swap(0, this.arr.size() - 1);

        this.siftDown(0, this.arr.size());
    }

    public T pop() {
        T head = this.peek();

        swap(0, this.arr.size() - 1);
        this.arr.remove(this.arr.size() - 1);
        this.siftDown(0, this.getSize());

        return head;
    }

    public T peek() {
        return this.arr.get(0);
    }

    private void swap(int i, int j) {
        T temp = this.arr.get(i);
        this.arr.set(i, this.arr.get(j));
        this.arr.set(j, temp);
    }

    private void siftDown(int parentIndex, int size) {

        for (int j = 0; j <= size / 2 - 1; j++) {
            for (int i = parentIndex; i <= size / 2 - 1; i++) {
                T currentParent = this.arr.get(i);

                int leftChildIndex = 2 * i + 1;
                leftChildIndex = leftChildIndex >= size ? -1 : leftChildIndex;

                int rightChildIndex = 2 * i + 2;
                rightChildIndex = rightChildIndex >= size ? -1 : rightChildIndex;

                int maxChildIndex = i;

                if (leftChildIndex != -1 && rightChildIndex != -1) {
                    maxChildIndex = this.comparator
                            .compare(this.arr.get(leftChildIndex), this.arr.get(rightChildIndex)) >= 0 ? leftChildIndex
                            : rightChildIndex;
                } else if (leftChildIndex != -1) {
                    maxChildIndex = leftChildIndex;
                } else if (rightChildIndex != -1) {
                    maxChildIndex = rightChildIndex;
                }

                if (this.comparator.compare(this.arr.get(maxChildIndex), currentParent) >= 0) {
                    swap(i, maxChildIndex);
                    siftDown(maxChildIndex, size);
                } else {
                    break;
                }
            }
        }
    }

    public int getSize() {
        return this.arr.size();
    }
}