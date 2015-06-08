package vector;

public class VectorImpl implements Vector {

    private int[] data;
    private int size;

    public VectorImpl() {
        this.data = new int[10];
        size = 0;
    }

    @Override
    public void insert(int index, int value) {
        if (index >= this.size) {
            throw new IllegalArgumentException("Invalid Index");
        }

        // If don't have enough space for the next element
        if (this.size + 1 == this.data.length) {
            resizeData();
        }

        int[] newData = new int[this.data.length + 1];

        // Left part
        for (int i = 0; i < index; i++) {
            newData[i] = this.data[i];
        }

        // Add the element in the index
        newData[index] = value;

        // Right part
        for (int i = index + 1; i < newData.length; i++) {
            newData[i] = this.data[i - 1];
        }

        this.data = newData;
        size++;
    }

    @Override
    public void add(int value) {
        if (this.size == this.data.length) {
            this.resizeData();
        }

        this.data[size] = value;
        size++;
    }

    @Override
    public int get(int index) {
        return this.data[index];
    }

    @Override
    public int capacity() {
        return this.data.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void resizeData() {
        int[] newData = new int[this.data.length * 2];

        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("[");
        for (int i = 0; i < this.size; i++) {
            output.append(this.data[i]);

            if (i + 1 < this.size) {
                output.append(", ");
            }
        }
        output.append("]");

        return output.toString();
    }
}