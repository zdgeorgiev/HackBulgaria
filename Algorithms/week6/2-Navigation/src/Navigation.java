import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Navigation {

    private static List<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        int m = s.nextInt();

        int startingIndex = s.nextInt();
        int endIndex = s.nextInt();

        for (int i = 0; i < m; i++) {
            int fromIndex = s.nextInt();
            int toIndex = s.nextInt();
            int weight = s.nextInt();

            graph.get(fromIndex - 1).add(new Pair(toIndex - 1, weight, 0));
            graph.get(toIndex - 1).add(new Pair(fromIndex - 1, weight, 0));
        }

        getMinDistance(startingIndex - 1, endIndex - 1);
    }

    private static void getMinDistance(int startingIndex, int endIndex) {

        int[] visited = new int[graph.size()];
        int[] minPathVector = new int[graph.size()];

        PriorityQueue<Pair> neighbours = new PriorityQueue<Pair>(10, new Comparator<Pair>() {

            @Override
            public int compare(Pair arg0, Pair arg1) {
                return Integer.compare(arg0.weight, arg1.weight);
            }
        });

        neighbours.add(new Pair(startingIndex, 0, 0));

        while (!neighbours.isEmpty()) {

            Pair head = neighbours.poll();
            int headIndex = head.vertex;
            visited[headIndex] = 1;

            Pair nextVertex = neighbours.peek();

            // If theres more than 1 edges with same weight should add them all
            if (nextVertex != null) {
                while (nextVertex.weight == head.weight) {
                    visited[nextVertex.vertex] = 1;

                    minPathVector[nextVertex.vertex] = nextVertex.parentWeight + nextVertex.weight;

                    // Move to the next
                    nextVertex = neighbours.poll();

                    if (nextVertex != null) {
                        break;
                    }
                }
            }

            // Fill the current min value to the next vertex
            minPathVector[headIndex] = head.parentWeight + head.weight;

            // Break if reached the end point
            if (minPathVector[endIndex] != 0) {
                System.out.println(minPathVector[endIndex]);
                return;
            }

            for (int i = 0; i < graph.get(headIndex).size(); i++) {
                int weight = graph.get(headIndex).get(i).weight;
                int vertexIndex = graph.get(headIndex).get(i).vertex;

                if (visited[vertexIndex] == 0 && weight != 0) {
                    neighbours.add(new Pair(vertexIndex, weight, minPathVector[head.vertex]));
                }
            }
        }
    }
}