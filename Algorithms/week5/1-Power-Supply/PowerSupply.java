import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PowerSupply {

    private static Queue<Pair> pq;
    private static ArrayList<ArrayList<Pair>> graph;
    private static int[] visited;

    public static void main(String[] args) {

        pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair arg0, Pair arg1) {
                return Integer.compare(arg0.weight, arg1.weight);
            }
        });

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        visited = new int[1000];
        graph = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < 1000; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < n; i++) {
            int firstV = s.nextInt() - 1;
            int secondV = s.nextInt() - 1;
            int weight = s.nextInt();

            Pair p1 = new Pair(secondV, weight);
            Pair p2 = new Pair(firstV, weight);

            graph.get(firstV).add(p1);
            graph.get(secondV).add(p2);
        }

        System.out.println(minWeight());

    }

    private static int minWeight() {

        int totalSum = 0;
        int startIndex = 0;

        for (Pair p : graph.get(startIndex)) {
            pq.add(p);
        }

        visited[startIndex] = 1;

        while (!pq.isEmpty()) {
            Pair lowestPair = pq.peek();
            pq.poll();

            if (visited[lowestPair.value] == 0) {
                totalSum += lowestPair.weight;
                visited[lowestPair.value] = 1;

                for (Pair child : graph.get(lowestPair.value)) {
                    if (visited[child.value] == 0) {
                        pq.add(child);
                    }
                }
            }
        }

        return totalSum;
    }
}