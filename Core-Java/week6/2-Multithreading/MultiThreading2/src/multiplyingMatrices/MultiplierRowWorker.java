package multiplyingMatrices;

public class MultiplierRowWorker implements Runnable {
    private int[] firstMatrixRow;
    private int rowIndex;

    private int[][] firstMatrix = null;
    private int[][] secondMatrix = null;

    private int[][] result = null;

    public MultiplierRowWorker(int rowIndex, int[][] firstMatrix, int[][] secondMatrix, int[][] result) {
        this.firstMatrix = firstMatrix;
        this.firstMatrixRow = getRow(rowIndex);
        this.rowIndex = rowIndex;
        this.secondMatrix = secondMatrix;
        this.result = result;
    }

    @Override
    public void run() {
        // System.out.println(Thread.currentThread().getName() +
        // " Multiplying row - " + this.rowIndex);

        for (int j = 0; j < this.secondMatrix[0].length; j++) {
            int value = 0;

            for (int i = 0; i < this.firstMatrixRow.length; i++) {

                value += this.firstMatrixRow[i] * this.secondMatrix[i][j];
            }

            this.result[rowIndex][j] = value;
        }

        // System.out.println(Thread.currentThread().getName() +
        // " Finished row - " + this.rowIndex);
    }

    private int[] getRow(int rowIndex) {
        return this.firstMatrix[rowIndex];
    }
}
