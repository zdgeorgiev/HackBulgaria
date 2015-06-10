package queue;

public class QueueImpl implements Queue {

    protected Node head;
    protected Node tail;
    protected int size;

    public QueueImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void push(Node value) {
        if (size != 0) {
            this.tail.setNext(value);
        } else {
            this.head = value;
        }

        this.tail = value;
        this.size++;
    }

    @Override
    public Node pop() {
        Node nextNode = this.head.getNext();
        Node headCpy = this.head;

        this.head.setNext(null);
        this.head = nextNode;
        this.size--;

        return headCpy;
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