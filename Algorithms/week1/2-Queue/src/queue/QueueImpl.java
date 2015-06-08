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
            this.head.setNext(null);
        }

        this.tail = value;
        this.size++;
    }

    @Override
    public Node pop() {
        this.head.getNext().setNext(null);
        this.size--;
        return this.head;
    }

    @Override
    public Node peek() {
        return this.head;
    }

    @Override
    public int size() {
        return this.size;
    }
}
