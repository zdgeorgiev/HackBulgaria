package matrix;

public class Threshold implements MatrixOperation {
    private final int MAX_INTENSITY = 127;

    public int withPixel(int x, int y, int[][] matrix) {
        if (matrix[x][y] < MAX_INTENSITY) {
            // for black pixel
            return 1;
        }

        // for white pixel
        return 0;
    }
}