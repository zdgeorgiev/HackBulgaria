package stackLinkedList;

public class StackImpl implements Stack {

    private Item obj;

    public StackImpl() {
        this.obj = null;
    }

    public void push(Item next) {
        Item temp = this.obj;
        this.obj = next;
        this.obj.setpPrev(temp);
        // System.out.println("Push - " + this.obj.getValue());
    }

    public Item pop() {
        Item item = null;

        if (!this.isEmpty()) {
            item = this.obj;
            this.obj = (Item) this.obj.getPrev();
            // System.out.println("POP - " + this.obj.getValue());
        }

        return item;
    }

    public Item peek() {
        if (!this.isEmpty()) {
            return (Item) this.obj.getValue();
        }

        return null;
    }

    public boolean isEmpty() {
        if (this.obj == null) {
            return true;
        }

        return false;
    }

    public void clear() {
        this.obj = null;
    }
}