package Stack;

public interface Stack {
    void push(Item obj);

    void pop();

    Item peek();

    boolean isEmpty();

    void clear();
}