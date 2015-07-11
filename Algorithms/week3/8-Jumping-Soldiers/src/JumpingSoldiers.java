import java.util.Scanner;

public class JumpingSoldiers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int cols = s.nextInt();
        int rows = s.nextInt();

        int[][] matrix = new int[rows][cols];

        int currentMax = Integer.MIN_VALUE;
        int soldiersSum = Integer.MAX_VALUE;
        int rowIndex = 0;
        int soldiersHigh;

        for (int i = 0; i < rows; i++) {
            soldiersHigh = 0;

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = s.nextInt();
                soldiersHigh += matrix[i][j];
            }

            int currentCount = getCurrentRowCount(i, matrix);

            if (currentMax == currentCount) {

                if (soldiersSum > soldiersHigh) {
                    soldiersSum = soldiersHigh;
                    currentMax = currentCount;
                    rowIndex = i + 1;
                }
            } else if (currentMax < currentCount) {
                soldiersSum = soldiersHigh;
                currentMax = currentCount;
                rowIndex = i + 1;
            }
        }

        System.out.println(rowIndex);
    }

    private static int getCurrentRowCount(int index, int[][] matrix) {
        int count = 0;

        for (int j = matrix[index].length - 1; j >= 0; j--) {

            for (int i = j - 1; i >= 0; i--) {

                if (matrix[index][j] > matrix[index][i]) {
                    continue;
                } else {
                    count++;
                }
            }
        }

        return count;
    }
}
