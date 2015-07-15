import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Navigation {

    private static List<ArrayList<Vertex>> graph = new ArrayList<ArrayList<Vertex>>();

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Vertex>());
        }

        int m = s.nextInt();

        int startingIndex = s.nextInt();
        int endIndex = s.nextInt();

        for (int i = 0; i < m; i++) {
            int fromIndex = s.nextInt();
            int toIndex = s.nextInt();
            int weight = s.nextInt();

            graph.get(fromIndex - 1).add(new Vertex(toIndex - 1, weight, 0));
            graph.get(toIndex - 1).add(new Vertex(fromIndex - 1, weight, 0));
        }

        getMinDistance(startingIndex - 1, endIndex - 1);
    }

    private static void getMinDistance(int startingIndex, int endIndex) {

        /**
         * shortestPaths contains a pair with smallest distance for the current
         * index and previous parent index, that means if the distance is -1 the
         * current node isnt visited yet, and this removes additional array for
         * visited checking
         */
        ArrayList<Pair> shortestPaths = new ArrayList<Pair>();

        for (int i = 0; i < graph.size(); i++) {
            shortestPaths.add(new Pair(-1, -1));
        }

        // Initialize the first value with 0
        shortestPaths.get(startingIndex).value = 0;

        PriorityQueue<Vertex> neighbours = new PriorityQueue<Vertex>(10, new Comparator<Vertex>() {

            @Override
            public int compare(Vertex arg0, Vertex arg1) {
                return Integer.compare(arg0.weight, arg1.weight);
            }
        });

        neighbours.add(new Vertex(startingIndex, 0, 0));

        while (!neighbours.isEmpty()) {

            Vertex head = neighbours.poll();
            int headIndex = head.vertexIndex;

            // If the shortest path isnt found yet
            if (shortestPaths.get(headIndex).prevParentIndex == -1) {
                shortestPaths.get(headIndex).prevParentIndex = head.parentIndex;
            }

            Vertex nextVertex = neighbours.peek();

            // If theres more than 1 edges with same weight should add them all
            if (nextVertex != null) {
                while (nextVertex.weight == head.weight) {

                    shortestPaths.get(nextVertex.vertexIndex).value = shortestPaths.get(nextVertex.parentIndex).value
                            + nextVertex.weight;

                    if (shortestPaths.get(nextVertex.vertexIndex).prevParentIndex == -1) {
                        shortestPaths.get(nextVertex.vertexIndex).prevParentIndex = nextVertex.parentIndex;
                    }

                    // Move to the next
                    nextVertex = neighbours.poll();

                    if (nextVertex != null) {
                        break;
                    }
                }
            }

            // Fill the current min weight to the next vertex
            shortestPaths.get(headIndex).value = shortestPaths.get(head.parentIndex).value + head.weight;

            // Break if reached the end point
            if (shortestPaths.get(endIndex).prevParentIndex != -1) {
                System.out.println(shortestPaths.get(endIndex).value);
                printMinPath(shortestPaths, endIndex);
                return;
            }

            for (int i = 0; i < graph.get(headIndex).size(); i++) {
                int weight = graph.get(headIndex).get(i).weight;
                int vertexIndex = graph.get(headIndex).get(i).vertexIndex;

                if (shortestPaths.get(vertexIndex).value == -1 && weight != 0) {
                    neighbours.add(new Vertex(vertexIndex, weight, head.vertexIndex));
                }
            }
        }
    }

    private static void printMinPath(List<Pair> list, int index) {
        int prevIndex = list.get(index).prevParentIndex;
        int lastIndex = 0;

        StringBuilder result = new StringBuilder();

        while (lastIndex != prevIndex) {

            result.insert(0, (prevIndex + 1) + " ");
            int temp = prevIndex;
            prevIndex = list.get(prevIndex).prevParentIndex;
            lastIndex = temp;
        }

        result.append(index + 1);

        System.out.println(result.toString());
    }
}