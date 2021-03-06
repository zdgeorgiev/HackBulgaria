package matrix;

public final class Matrix {
    private final int rows;
    private final int cols;

    private int[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[this.getRows()][this.getCols()];
    }

    public void operate(MatrixOperation op) {
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[0].length; j++) {
                this.data[i][j] = op.withPixel(i, j, this.data);
            }
        }
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.data.length; i++) {
            output.append("[ ");
            for (int j = 0; j < this.data[0].length; j++) {
                output.append(this.data[i][j] + " ");
            }
            output.append("]\n");
        }

        return output.toString();
    }
}
