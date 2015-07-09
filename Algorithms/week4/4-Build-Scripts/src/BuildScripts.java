import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildScripts {

    public static List<String> projects = new ArrayList<>();
    public static List<String> sorted = new ArrayList<>();
    public static int[] visited;
    public static int[] tempVisited;

    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            projects.add(s.next());
        }

        String startingProject = s.next();
        int startingIndex = projects.indexOf(startingProject);

        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        int k;
        ArrayList<Integer> neighbours;

        for (int i = 0; i < n; i++) {
            k = s.nextInt();
            neighbours = new ArrayList<Integer>();

            for (int j = 0; j < k; j++) {
                neighbours.add(projects.indexOf(s.next()));
            }

            graph.add(neighbours);
        }

        visited = new int[projects.size()];
        tempVisited = new int[projects.size()];

        topologicalSort(graph, startingIndex);

        if (!sorted.get(sorted.size() - 1).equals(startingProject)) {

            System.out.println("BUILD ERROR");
            return;
        } else {
            for (int i = 0; i < sorted.size(); i++) {
                output.append(sorted.get(i));

                if (i + 1 < sorted.size()) {
                    output.append(" ");
                }
            }
        }

        System.out.println(output);
    }

    private static void topologicalSort(List<ArrayList<Integer>> graph, int startNode) {

        visit(graph, startNode);
    }

    private static void visit(List<ArrayList<Integer>> graph, int node) {
        if (tempVisited[node] == 1) {
            return;
        }

        if (visited[node] == 0) {
            tempVisited[node] = 1;

            for (int i = 0; i < graph.get(node).size(); i++) {

                int nextNodeIndex = graph.get(node).get(i);

                if (visited[nextNodeIndex] == 0) {
                    visit(graph, nextNodeIndex);
                }
            }
        }

        visited[node] = 1;
        tempVisited[node] = 0;
        sorted.add(projects.get(node));
    }
}
