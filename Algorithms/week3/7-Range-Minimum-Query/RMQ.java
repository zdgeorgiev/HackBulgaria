import java.util.ArrayList;

public class RMQ {

    private RMQBinaryIndexedTree data;

    public RMQ(ArrayList<Integer> inputData) {
        this.data = new RMQBinaryIndexedTree(inputData, inputData.size());
    }

    // sets the value at index
    public void set(int index, int value) {
        this.data.set(index, value);
    }

    // returns the minimum value in a range
    public int min(int startIndex, int endIndex) {
        return this.data.min(startIndex, endIndex);
    }
}
