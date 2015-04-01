package stackDLL;

import doublyLinkedList.Node;

public interface Stack {
    void push(Node obj);

    Node pop();

    Node peek();

    boolean isEmpty();

    void clear();
}