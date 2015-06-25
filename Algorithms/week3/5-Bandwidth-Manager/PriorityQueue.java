import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Packet> data;
    private int size;

    public PriorityQueue() {
        this.data = new ArrayList<Packet>();
        this.size = 0;
    }

    public void push(Packet p) {

        /**
         * because when pop the first element, swap it the last one and make it
         * null and should check if at the next position element is null and
         * swap it or if is not null then add to the end of the queue
         */
        if (this.size < this.data.size() && this.data.get(this.size) == null) {
            this.data.set(this.size, p);
        } else {
            this.data.add(p);
        }

        this.size++;

        swap(0, size - 1);
        this.siftDown(0);
    }

    private void siftDown(int index) {

        for (int i = index; i < this.size - 1; i++) {

            int leftChildIndex = 2 * i + 1;
            leftChildIndex = leftChildIndex >= this.size ? -1 : leftChildIndex;

            int rightChildIndex = 2 * i + 2;
            rightChildIndex = rightChildIndex >= this.size ? -1 : rightChildIndex;

            int maxPacketIndex = 0;

            if (leftChildIndex != -1 && rightChildIndex != -1) {
                maxPacketIndex = this.data.get(leftChildIndex).getPriority() > this.data.get(rightChildIndex)
                        .getPriority() ? leftChildIndex : rightChildIndex;
            } else if (leftChildIndex != -1) {
                maxPacketIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                maxPacketIndex = rightChildIndex;
            }

            if (this.data.get(maxPacketIndex).getPriority() >= this.data.get(index).getPriority()) {
                swap(0, maxPacketIndex);
                siftDown(maxPacketIndex);
            } else {
                break;
            }
        }
    }

    public Packet pop() {
        Packet head = this.data.get(0);

        if (head == null) {
            return null;
        }

        // swap with the first element
        swap(0, this.size - 1);

        // set the last element with null
        this.data.set(this.size - 1, null);
        this.size--;

        // make heapify
        this.siftDown(0);

        return head;
    }

    private void swap(int i, int j) {
        Packet temp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);
    }
}
