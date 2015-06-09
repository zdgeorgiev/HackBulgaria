package queue;

public class QueueImpl implements Queue {

    private Node head;
    private Node tail;
    private int size;

    public QueueImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void push(Node value) {
        if (size == 0) {
            this.head = value;
            this.tail = value;
        }

        this.tail.setNext(value);
        this.tail = value;
        this.size++;
    }

    @Override
    public Node pop() {
        Node prevHead = this.head;
        prevHead.setNext(prevHead.getNext());
        this.head = this.head.getNext();
        this.size--;
        return prevHead;
    }

    @Override
    public Node peek() {
        return this.head;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("[");
        Node headCpy = this.head;

        while (headCpy != null) {
            output.append(headCpy.getValue());

            headCpy = headCpy.getNext();
            if (headCpy != null) {
                output.append(", ");
            }
        }

        output.append("]");

        return output.toString();
    }
}