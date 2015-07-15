import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LowCostFlights {

    private static int[][] graph;
    private static int[][] minPaths;

    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        graph = new int[n][n];
        minPaths = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.nextInt();
            }
        }

        int commands = s.nextInt();

        List<ArrayList<Integer>> startAirpoints = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < commands; i++) {
            int startAirport = s.nextInt();
            int endAirport = s.nextInt();

            ArrayList<Integer> currentFlight = new ArrayList<Integer>();
            currentFlight.add(startAirport);
            currentFlight.add(endAirport);

            startAirpoints.add(currentFlight);
        }

        for (int i = 0; i < startAirpoints.size(); i++) {
            createMinPaths(startAirpoints.get(i).get(0));
        }

        for (int i = 0; i < startAirpoints.size(); i++) {
            output.append(getMinPath(startAirpoints.get(i).get(0), startAirpoints.get(i).get(1)));
        }

        System.out.print(output.toString());
    }

    private static void createMinPaths(int startPoint) {

        int[] visited = new int[graph.length];

        PriorityQueue<Pair> neighbours = new PriorityQueue<Pair>(10, new Comparator<Pair>() {

            @Override
            public int compare(Pair arg0, Pair arg1) {
                return Integer.compare(arg0.weight, arg1.weight);
            }
        });

        neighbours.add(new Pair(startPoint, 0, 0));

        while (!neighbours.isEmpty()) {

            Pair head = neighbours.poll();
            int headIndex = head.vertex;
            visited[headIndex] = 1;

            Pair nextVertex = neighbours.peek();

            // If theres more than 1 edges with same weight should add them all
            if (nextVertex != null) {
                while (nextVertex.weight == head.weight) {
                    visited[nextVertex.vertex] = 1;

                    minPaths[startPoint][nextVertex.vertex] = nextVertex.parentWeight + nextVertex.weight;

                    // Move to the next
                    nextVertex = neighbours.poll();

                    if (nextVertex != null) {
                        break;
                    }
                }
            }

            // Fill the current min value to the next vertex
            minPaths[startPoint][headIndex] = head.parentWeight + head.weight;

            for (int i = 0; i < graph[headIndex].length; i++) {
                int weight = graph[headIndex][i];
                int vertexIndex = i;

                if (visited[vertexIndex] == 0 && weight != 0) {
                    neighbours.add(new Pair(vertexIndex, weight, minPaths[startPoint][head.vertex]));
                }
            }

        }
    }

    private static String getMinPath(int from, int to) {
        if (from == to) {
            return "0\n";
        }

        int path = minPaths[from][to];
        return path != 0 ? String.valueOf(path) + "\n" : "NO WAY\n";
    }
}