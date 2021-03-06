package matrix;

public class GaussianBlur implements MatrixOperation {

    private int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 },
            { -1, 1 }, { 1, -1 } };

    public int withPixel(int x, int y, int[][] matrix) {
        int average = matrix[x][y];
        int occurrences = 1;

        for (int i = 0; i < 8; i++) {
            int nextRow = x + directions[i][0];
            int nextCol = y + directions[i][1];

            if (isValidCell(nextRow, nextCol, matrix)) {
                average += matrix[nextRow][nextCol];
                occurrences++;
            }
        }

        return average / occurrences;
    }

    private boolean isValidCell(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length);
    }
}