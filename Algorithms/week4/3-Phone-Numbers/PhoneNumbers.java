import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class PhoneNumbers {

    private static Map<Integer, Integer> peoplesMap = new HashMap<Integer, Integer>();
    private static int[][] graph;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            peoplesMap.put(s.nextInt(), peoplesMap.size());
        }

        graph = new int[n][n];

        // Create adjacent matrix
        for (int i = 0; i < n; i++) {
            int friendsPhones = s.nextInt();

            for (int j = 0; j < friendsPhones; j++) {
                int nextIndex = s.nextInt();
                graph[i][peoplesMap.get(nextIndex)] = 1;
                graph[peoplesMap.get(nextIndex)][i] = 1;
            }
        }

        System.out.println(getComponents());
    }

    private static int getComponents() {

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[graph.length];

        while (true) {

            int firstNotVisitedIndex = -1;

            for (int j = 0; j < visited.length; j++) {
                if (visited[j] == 0) {
                    firstNotVisitedIndex = j;
                    break;
                }
            }

            if (firstNotVisitedIndex == -1) {
                break;
            }

            visited[firstNotVisitedIndex] = 1;

            queue.add(firstNotVisitedIndex);

            while (!queue.isEmpty()) {
                int index = queue.poll();

                for (int j = 0; j < graph[index].length; j++) {
                    if (graph[index][j] == 1 && visited[j] == 0) {
                        queue.add(j);
                        visited[j] = 1;
                    }
                }
            }

            count++;
        }

        return count;
    }
}
