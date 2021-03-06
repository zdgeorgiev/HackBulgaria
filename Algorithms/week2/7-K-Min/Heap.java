import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {

    private ArrayList<T> arr;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.arr = new ArrayList<T>();
    }

    public void push(T value) {
        this.arr.add(value);
        this.siftUp(this.arr.size() - 1);
    }

    public T pop() {
        T head = this.peek();

        swap(0, this.arr.size() - 1);
        this.arr.remove(this.arr.size() - 1);
        this.siftDown(0, this.arr.size());

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

    public void heapify() {

        for (int i = this.getSize() / 2 - 1; i >= 0; i--) {
            this.siftDown(i, this.arr.size());
        }
    }

    private void siftUp(int index) {

        while (index > 0) {
            T currentParent = this.arr.get((index - 1) / 2);

            if (this.comparator.compare(this.arr.get(index), currentParent) > 0) {
                swap(index, (index - 1) / 2);
                siftUp((index - 1) / 2);
            } else {
                break;
            }
        }
    }

    private void siftDown(int index, int size) {

        while (index <= size / 2 - 1) {
            T currentParent = this.arr.get(index);

            int leftChildIndex = 2 * index + 1;
            leftChildIndex = leftChildIndex >= size ? -1 : leftChildIndex;

            int rightChildIndex = 2 * index + 2;
            rightChildIndex = rightChildIndex >= size ? -1 : rightChildIndex;

            int maxChildIndex = index;

            if (leftChildIndex != -1 && rightChildIndex != -1) {
                maxChildIndex = this.comparator.compare(this.arr.get(leftChildIndex), this.arr.get(rightChildIndex)) > 0 ? leftChildIndex
                        : rightChildIndex;
            } else if (leftChildIndex != -1) {
                maxChildIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                maxChildIndex = rightChildIndex;
            }

            if (this.comparator.compare(this.arr.get(maxChildIndex), currentParent) > 0) {
                swap(index, maxChildIndex);
                siftDown(maxChildIndex, size);
            } else {
                break;
            }
        }
    }

    public int getSize() {
        return this.arr.size();
    }
}