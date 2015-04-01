package stackDLL;

import doublyLinkedList.DoublyLinkedListImpl;
import doublyLinkedList.Node;

public class stackDLL implements Stack {
    DoublyLinkedListImpl data;

    public stackDLL() {
        this.data = null;
    }

    public void push(Node next) {

        // Check if contains already
        boolean isExist = false;
        Node headCpy = this.data.getHead();
        while (headCpy != null) {
            if (headCpy.getData() == next.getData()) {
                System.out.println("Item " + next.getData() + " already exist in the stack");
                isExist = true;
                break;
            }

            headCpy = headCpy.getPrev();
        }

        if (!isExist) {
            Node temp = this.data.getHead();
            this.data.setHead(next);
            this.data.getHead().setPrev(temp);
            // System.out.println("Push - " + this.obj.getValue());
        }
    }

    public Node pop() {
        Node item = null;

        if (!this.isEmpty()) {
            item = this.data.getHead();
            this.data.setHead(this.data.getHead().getPrev());
            // System.out.println("POP - " + this.obj.getValue());
        }

        return item;
    }

    public Node peek() {
        if (!this.isEmpty()) {
            return this.data.getHead();
        }

        return null;
    }

    public boolean isEmpty() {
        if (this.data == null) {
            return true;
        }

        return false;
    }

    public void clear() {
        this.data = null;
    }
}