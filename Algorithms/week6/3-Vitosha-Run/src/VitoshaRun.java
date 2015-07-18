import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class VitoshaRun {

    private static int[][] matrix;
    private static int[][] minPathMatrix;

    private static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 0, -1 }, { -1, 1 },
            { 1, -1 }, { -1, -1 } };

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        matrix = new int[n][n];
        minPathMatrix = new int[n][n];

        Point startingPoint = new Point(s.nextInt(), s.nextInt(), 0);
        Point endPoint = new Point(s.nextInt(), s.nextInt(), 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        fillMinPaths(startingPoint, endPoint);

        System.out.println(minPathMatrix[endPoint.x][endPoint.y]);
    }

    private static void fillMinPaths(Point startingPoint, Point endPoint) {

        if (startingPoint.x == endPoint.x && endPoint.y == startingPoint.y) {
            return;
        }

        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point arg0, Point arg1) {
                return Integer.compare(arg0.value, arg1.value);
            }
        });

        queue.add(startingPoint);

        while (!queue.isEmpty()) {

            Point currentPoint = queue.poll();
            int currentMinValue = currentPoint.value;

            // Proccess all the points with same min value
            while (currentPoint.value == currentMinValue) {
                if (minPathMatrix[endPoint.x][endPoint.y] != 0) {
                    break;
                }

                if (minPathMatrix[currentPoint.x][currentPoint.y] == 0) {
                    minPathMatrix[currentPoint.x][currentPoint.y] = currentPoint.value;
                } else {
                    break;
                }

                for (int i = 0; i < directions.length; i++) {
                    int nextRow = currentPoint.x + directions[i][0];
                    int nextCol = currentPoint.y + directions[i][1];

                    if (isValidCell(nextRow, nextCol) && !(nextRow == startingPoint.x && nextCol == startingPoint.y)) {
                        int nextPointValue = Math
                                .abs(matrix[currentPoint.x][currentPoint.y] - matrix[nextRow][nextCol]) + 1;
                        queue.add(new Point(nextRow, nextCol, nextPointValue + currentPoint.value));
                    }
                }

                currentPoint = queue.peek();

                if (currentPoint != null && currentPoint.value == currentMinValue) {
                    queue.poll();
                } else {
                    break;
                }
            }
        }
    }

    private static boolean isValidCell(int x, int y) {
        return ((x < matrix.length && x >= 0) && (y < matrix[0].length && y >= 0)) && minPathMatrix[x][y] == 0;
    }
}