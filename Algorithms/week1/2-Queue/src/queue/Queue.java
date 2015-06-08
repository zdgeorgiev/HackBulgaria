package queue;

public interface Queue {
    void push(Node value);

    Node pop();

    Node peek();

    int size();
}
