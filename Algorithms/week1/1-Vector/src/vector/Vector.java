package vector;

public interface Vector {
    void insert(int index, int value);

    void add(int value);

    void remove(int index);

    int pop();

    int get(int index);

    int size();

    int capacity();
}
