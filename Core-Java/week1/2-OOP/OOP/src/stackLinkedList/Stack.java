package stackLinkedList;

public interface Stack {
    void push(Item obj);

    Item pop();

    Item peek();

    boolean isEmpty();

    void clear();
}