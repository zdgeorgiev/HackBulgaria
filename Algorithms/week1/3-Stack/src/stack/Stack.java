package stack;

import queue.Node;

public interface Stack {
    void push(Node value);

    Node pop();

    Node peek();

    int size();
}
