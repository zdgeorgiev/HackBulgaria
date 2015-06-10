package stack;

import queue.Node;
import queue.QueueImpl;

public class StackImpl implements Stack {

    private QueueImpl q1;
    private QueueImpl q2;

    public StackImpl() {
        this.q1 = new QueueImpl();
        this.q2 = new QueueImpl();
    }

    @Override
    public void push(Node value) {
        this.q2.push(value);

        Node prevHead = this.q1.peek();

        while (prevHead != null) {
            this.q2.push(prevHead);
            prevHead = prevHead.getNext();
        }

        this.q1 = this.q2;
        this.q2 = new QueueImpl();
    }

    @Override
    public Node pop() {
        return this.q1.pop();
    }

    @Override
    public Node peek() {
        return this.q1.peek();
    }

    @Override
    public int size() {
        return this.q1.size();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        Node head = this.q1.peek();

        output.append("[");
        while (head != null) {
            output.append(head.getValue());
            head = head.getNext();

            if (head != null) {
                output.append(", ");
            }
        }
        output.append("]");

        return output.toString();
    }
}