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
                graph[i][peoplesMap.get(s.nextInt())] = 1;
            }
        }

        System.out.println(getComponents());
    }

    private static int getComponents() {

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph[0].length; i++) {

            queue.add(i);
            int index = i;

            while (!queue.isEmpty()) {
                index = queue.poll();

                for (int j = index; j < graph[index].length; j++) {
                    if (graph[index][j] == 1 && !queue.contains(j)) {
                        queue.add(j);
                    }
                }
            }

            count++;
            i = index;
        }

        return count;
    }
}
