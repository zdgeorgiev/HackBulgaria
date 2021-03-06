package multiplyingMatrices;

public class ParallelMatricesMultiplier {
    private int[][] firstMatrix = null;
    private int[][] secondMatrix = null;

    private int[][] result = null;

    public ParallelMatricesMultiplier(int[][] first, int[][] second) {
        this.firstMatrix = first;
        this.secondMatrix = second;
        this.result = new int[firstMatrix.length][secondMatrix[0].length];
    }

    public int[][] multiply() {
        Thread[] threads = new Thread[this.firstMatrix.length];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MultiplierRowWorker(i, firstMatrix, secondMatrix, result));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }
}
