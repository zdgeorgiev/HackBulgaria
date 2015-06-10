package stack;

import queue.Node;
import queue.QueueImpl;

public class StackImpl implements Stack {

    private QueueImpl queue;

    public StackImpl() {
        this.queue = new QueueImpl();
    }

    @Override
    public void push(Node value) {
        this.queue.push(value);
    }

    @Override
    public Node pop() {
        Node[] nodes = getLastAndPreviousNode();

        nodes[1].setNext(null);

        return nodes[0];
    }

    @Override
    public Node peek() {
        Node[] nodes = getLastAndPreviousNode();

        return nodes[0];
    }

    private Node[] getLastAndPreviousNode() {

        Node lastNode = this.queue.peek();
        Node previousNode = this.queue.peek();

        while (previousNode != null) {
            Node nextNode = previousNode.getNext();

            if (nextNode.getNext() == null) {
                lastNode = nextNode;
                break;
            }

            previousNode = nextNode;
        }

        Node[] nodes = new Node[2];
        nodes[0] = lastNode;
        nodes[1] = previousNode;

        return nodes;
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        Node head = this.queue.peek();

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