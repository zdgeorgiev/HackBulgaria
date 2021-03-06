import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Castaway {

    /**
     * graph is list which contains the different adjacency list for every
     * alphabet letter indexed from 0 to 25, at the 26 index will contain the
     * starting point adjacency and at the 27 the finish point adjacency
     */
    private static ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();

    private static char[][] map;

    private static Point startingPoint;
    private static Point endPoint;

    private static final int GRAPH_SIZE = 28;
    private static final int START_POINT_INDEX = 26;
    private static final int END_POINT_INDEX = 27;

    private static boolean isFound = false;

    public static void main(String[] args) {

        initializeGraph();

        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();

        map = new char[rows][cols];

        startingPoint = new Point(s.nextInt(), s.nextInt());
        endPoint = new Point(s.nextInt(), s.nextInt());

        s.nextLine();

        for (int i = 0; i < rows; i++) {
            String currentLine = s.nextLine();

            for (int j = 0; j < currentLine.length(); j++) {
                map[i][j] = currentLine.charAt(j);
            }
        }

        parseTheMatrixAsGraph();

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int fromPoint = getIntFromLetter(s.next().charAt(0));
            int toPoint = getIntFromLetter(s.next().charAt(0));

            graph.get(fromPoint).add(toPoint);
            graph.get(toPoint).add(fromPoint);
        }

        if (startingPoint.x == endPoint.x && startingPoint.y == endPoint.y) {
            System.out.println(0);
        } else if (!isFound) {
            int steps = BFS(START_POINT_INDEX, END_POINT_INDEX);
            System.out.println(steps == -1 ? "NNnoooo" : steps);
        }
    }

    private static int BFS(int startingPointIndex, int endPointIndex) {

        int steps = 0;

        int[] visited = new int[28];

        int pointsAtCurrentLevel = 1;

        Queue<Integer> s = new LinkedList<>();
        s.add(startingPointIndex);

        while (pointsAtCurrentLevel != 0) {

            int nextLevelPoints = 0;
            steps++;

            for (int i = 0; i < pointsAtCurrentLevel; i++) {

                Integer currentPoint = s.poll();

                for (Integer nextPoint : graph.get(currentPoint)) {

                    if (visited[nextPoint] == 0) {
                        if (nextPoint == endPointIndex) {
                            return steps;
                        }

                        visited[nextPoint] = 1;
                        nextLevelPoints++;
                        s.add(nextPoint);
                    }
                }
            }

            pointsAtCurrentLevel = nextLevelPoints;
        }

        return -1;
    }

    private static void getNearestHarbours(int indexToSave, Point point, int[][] visited) {

        ArrayList<Integer> currentIslandHarbours = new ArrayList<Integer>();

        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 },
                { -1, -1 } };

        Queue<Point> points = new LinkedList<Point>();
        points.add(point);

        visited[point.x][point.y] = 1;

        while (!points.isEmpty()) {

            Point currentPoint = points.poll();
            char currentPointChar = map[currentPoint.x][currentPoint.y];

            if (Character.isLetter(currentPointChar)) {
                int charPointIndex = getIntFromLetter(currentPointChar);

                currentIslandHarbours.add(charPointIndex);
            }

            for (int i = 0; i < directions.length; i++) {
                int nextRow = currentPoint.x + directions[i][0];
                int nextCol = currentPoint.y + directions[i][1];

                // If start and end points are in the same island
                if (indexToSave == START_POINT_INDEX && endPoint.x == nextRow && endPoint.y == nextCol) {
                    System.out.println(1);
                    isFound = true;
                    return;
                }

                if (isValidCell(nextRow, nextCol) && map[nextRow][nextCol] != '.' && visited[nextRow][nextCol] == 0) {

                    visited[nextRow][nextCol] = 1;
                    points.add(new Point(nextRow, nextCol));
                }
            }
        }

        connectHarbours(currentIslandHarbours, indexToSave);
    }

    private static void connectHarbours(ArrayList<Integer> currentIslandHarbours, int indexToSave) {

        if (indexToSave == START_POINT_INDEX || indexToSave == END_POINT_INDEX) {
            currentIslandHarbours.add(indexToSave);
        }

        for (int i = 0; i < currentIslandHarbours.size(); i++) {
            for (int j = 0; j < currentIslandHarbours.size(); j++) {
                if (i == j) {
                    continue;
                }

                graph.get(currentIslandHarbours.get(i)).add(currentIslandHarbours.get(j));
            }
        }
    }

    private static void parseTheMatrixAsGraph() {

        // If the starting or end point is in the see its impossible
        if (map[startingPoint.x][startingPoint.y] == '.' || map[endPoint.x][endPoint.y] == '.') {
            return;
        }

        int[][] visited = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                char currentChar = map[i][j];

                if (Character.isLetter(currentChar) && visited[i][j] == 0) {
                    getNearestHarbours(getIntFromLetter(currentChar), new Point(i, j), visited);
                }
            }
        }

        visited = new int[map.length][map[0].length];

        getNearestHarbours(START_POINT_INDEX, startingPoint, visited);
        getNearestHarbours(END_POINT_INDEX, endPoint, visited);
    }

    private static void initializeGraph() {
        for (int i = 0; i < GRAPH_SIZE; i++) {
            graph.add(new HashSet<Integer>());
        }
    }

    private static boolean isValidCell(int x, int y) {
        return (x < map.length && x >= 0) && (y < map[0].length && y >= 0);
    }

    private static int getIntFromLetter(char letter) {
        return letter - 97;
    }
}
