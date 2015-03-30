package doublyLinkedList;

public interface DoublyLinkedList {
    void Add(Node node);

    void Remove(int node);

    int size();

    Node get(int index);

    Node getFirst();

    Node getLast();
}