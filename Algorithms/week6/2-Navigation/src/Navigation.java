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

        ArrayList<ArrayList<Integer>> shortestPaths = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < graph.size(); i++) {
            shortestPaths.add(new ArrayList<Integer>());
        }

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
            int headIndex = head.vertexIndex;
            visited[headIndex] = 1;

            // Already shortest path found
            if (shortestPaths.get(headIndex).size() == 0) {
                shortestPaths.get(headIndex).add(head.parentIndex);
            }

            Pair nextVertex = neighbours.peek();

            // If theres more than 1 edges with same weight should add them all
            if (nextVertex != null) {
                while (nextVertex.weight == head.weight) {
                    visited[nextVertex.vertexIndex] = 1;

                    minPathVector[nextVertex.vertexIndex] = minPathVector[nextVertex.parentIndex] + nextVertex.weight;

                    if (shortestPaths.get(nextVertex.vertexIndex).size() == 0) {
                        shortestPaths.get(nextVertex.vertexIndex).add(nextVertex.parentIndex);
                    }

                    // Move to the next
                    nextVertex = neighbours.poll();

                    if (nextVertex != null) {
                        break;
                    }
                }
            }

            // Fill the current min value to the next vertex
            minPathVector[headIndex] = minPathVector[head.parentIndex] + head.weight;

            // Break if reached the end point
            if (minPathVector[endIndex] != 0) {
                System.out.println(minPathVector[endIndex]);
                // System.out.println(shortestPaths.get(endIndex));
                printMinPath(shortestPaths, endIndex);
                return;
            }

            for (int i = 0; i < graph.get(headIndex).size(); i++) {
                int weight = graph.get(headIndex).get(i).weight;
                int vertexIndex = graph.get(headIndex).get(i).vertexIndex;

                if (visited[vertexIndex] == 0 && weight != 0) {
                    neighbours.add(new Pair(vertexIndex, weight, head.vertexIndex));
                }
            }
        }
    }

    private static void printMinPath(List<ArrayList<Integer>> list, int index) {
        int prevIndex = list.get(index).get(0);
        int lastIndex = 0;

        StringBuilder result = new StringBuilder();

        while (lastIndex != prevIndex) {

            result.insert(0, (prevIndex + 1) + " ");
            int temp = prevIndex;
            prevIndex = list.get(prevIndex).get(0);
            lastIndex = temp;
        }

        result.append(index + 1);

        System.out.println(result.toString());
    }
}
