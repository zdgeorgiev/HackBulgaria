import java.util.ArrayList;

public class BinaryIndexedTree {

    private int[] data;

    public BinaryIndexedTree(ArrayList<Integer> inputData, int totalLeafs) {
        int usedNotes = totalLeafs * 2 - 1;
        int totalNotesRequired = 1;

        while (usedNotes > totalNotesRequired) {
            totalNotesRequired *= 2;
        }

        // make complete binary tree
        this.data = new int[totalNotesRequired - 1];

        this.buildBIT(inputData);
    }

    private void buildBIT(ArrayList<Integer> inputData) {
        this.fillFirstLayer(inputData);

        for (int i = this.data.length / 2 - 1; i >= 0; i--) {

            // fill each note with the sum of its childs
            this.data[i] = this.data[2 * i + 1] + this.data[2 * i + 2];
        }
    }

    private void fillFirstLayer(ArrayList<Integer> inputData) {

        for (int i = 0; i < inputData.size(); i++) {
            this.data[this.data.length / 2 + i] = inputData.get(i);
        }
    }

    public void add(int index, int amount) {

        int changegChildIndex = this.data.length / 2 + index;
        this.data[changegChildIndex] += amount;

        while (changegChildIndex != 0) {

            // update the value of the parent
            int parentIndex = (changegChildIndex - 1) / 2;
            this.data[parentIndex] = this.data[2 * parentIndex + 1] + this.data[2 * parentIndex + 2];
            changegChildIndex = parentIndex;
        }
    }

    public void remove(int index, int amount) {

        int changedChildIndex = this.data.length / 2 + index;
        this.data[changedChildIndex] -= amount;

        if (this.data[changedChildIndex] < 0) {
            this.data[changedChildIndex] = 0;
        }

        while (changedChildIndex != 0) {

            // update the value of the parent
            int parentIndex = (changedChildIndex - 1) / 2;
            this.data[parentIndex] = this.data[2 * parentIndex + 1] + this.data[2 * parentIndex + 2];
            changedChildIndex = parentIndex;
        }
    }

    public int count(int upperBound) {

        int rangeCount = 0;

        // select the upperBound + 1 index
        int childIndex = this.data.length / 2 + upperBound + 1;

        while (childIndex != 0) {
            if (isRightChild(childIndex)) {
                rangeCount += this.data[childIndex - 1];
            }

            childIndex = (childIndex - 1) / 2;
        }

        return rangeCount;
    }

    private boolean isRightChild(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;

        if (2 * parentIndex + 2 == childIndex) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("[");
        for (int i = 0; i < this.data.length; i++) {
            output.append(this.data[i]);

            if (i + 1 != this.data.length) {
                output.append(", ");
            }
        }
        output.append("]");

        return output.toString();
    }
}