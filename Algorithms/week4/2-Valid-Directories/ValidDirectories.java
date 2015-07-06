import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ValidDirectories {

    private ArrayList<Integer> visited = new ArrayList<Integer>();

    public boolean isValid(int[][] graph) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(0);

        while (!queue.isEmpty()) {

            int currentIndex = queue.poll();

            for (int i = 0; i < graph[currentIndex].length; i++) {

                if (!this.visited.contains(graph[currentIndex][i])) {
                    if (graph[currentIndex][i] == 1) {
                        queue.add(i);
                        this.visited.add(i);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] agrs) {
        ValidDirectories v = new ValidDirectories();
        int[][] graph = new int[][] { { 0, 1, 0, 1, 0, 2 }, { 0, 0, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 2, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        System.out.println(v.isValid(graph));
    }
}
