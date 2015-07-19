import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ValidDirectories {

    private static int[] visited;

    public boolean isValid(int[][] graph) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {

            int currentIndex = queue.poll();

            for (int i = 0; i < graph[currentIndex].length; i++) {

                if (graph[currentIndex][i] == 1) {
                    if (visited[i] == 0) {
                        queue.add(i);
                        visited[i] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] agrs) {
        ValidDirectories v = new ValidDirectories();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] graph = new int[n][n];
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.nextInt();
            }
        }

        System.out.println(v.isValid(graph));
    }
}
