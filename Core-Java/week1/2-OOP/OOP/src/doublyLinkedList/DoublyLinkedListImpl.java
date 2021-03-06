package doublyLinkedList;

public class DoublyLinkedListImpl implements DoublyLinkedList {
    private int count = 0;
    private Node head;

    public DoublyLinkedListImpl() {
        this.setHead(null);
    }

    public void Add(Node next) {
        if (next == null) {
            System.out.println("Next node cannot be null");
        } else {
            if (this.head == null) {
                this.setHead(next);
            } else {
                Node headCpy = this.getHead();
                this.getHead().setNext(next);
                next.setPrev(headCpy);
                this.setHead(next);
            }

            this.setCount(this.getCount() + 1);
        }
    }

    public void Remove(int node) {
        // Search for the node
        Node headCpy = this.head;
        while (headCpy != null) {
            if (headCpy.getData() == node) {

                // Change neighbors connections
                if (headCpy.getPrev() != null) {
                    headCpy.getPrev().setNext(headCpy.getNext());
                }
                if (headCpy.getNext() != null) {
                    headCpy.getNext().setPrev(headCpy.getPrev());
                }

                headCpy = null;
                this.setCount(this.getCount() - 1);
                break;
            }

            headCpy = headCpy.getPrev();
        }
    }

    public int size() {
        return this.getCount();
    }

    public Node get(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid index");
            return null;
        }

        Node headCpy = this.head;
        int currentIndex = this.getCount() - 1;

        while (true) {
            if (currentIndex == index) {
                break;
            }

            currentIndex--;
            headCpy = headCpy.getPrev();
        }

        return headCpy;
    }

    public Node getFirst() {
        Node headCpy = this.head;

        while (headCpy.getPrev() != null) {
            headCpy = headCpy.getPrev();
        }

        return headCpy;
    }

    public Node getLast() {
        return this.getHead();
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }
}