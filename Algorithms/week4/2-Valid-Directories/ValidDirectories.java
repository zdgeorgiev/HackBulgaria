import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ValidDirectories {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int count = s.nextInt();

        ArrayList<Graph.Node> allNodes = new ArrayList<Graph.Node>();
        for (int i = 0; i < count; i++) {
            allNodes.add(new Graph.Node(""));
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int nextConnection = s.nextInt();

                if (nextConnection == 1) {
                    allNodes.get(i).addEdge(allNodes.get(j));
                }
            }
        }

        // L <- Empty list that will contain the sorted elements
        ArrayList<Graph.Node> L = new ArrayList<Graph.Node>();

        // S <- Set of all nodes with no incoming edges
        HashSet<Graph.Node> S = new HashSet<Graph.Node>();
        for (Graph.Node n : allNodes) {
            if (n.inEdges.size() == 0) {
                S.add(n);
            }
        }

        // while S is non-empty do
        while (!S.isEmpty()) {
            // remove a node n from S
            Graph.Node n = S.iterator().next();
            S.remove(n);

            // insert n into L
            L.add(n);

            // for each node m with an edge e from n to m do
            for (Iterator<Graph.Edge> it = n.outEdges.iterator(); it.hasNext();) {
                // remove edge e from the graph
                Graph.Edge e = it.next();
                Graph.Node m = e.to;
                it.remove();// Remove edge from n
                m.inEdges.remove(e);// Remove edge from m

                // if m has no other incoming edges then insert m into S
                if (m.inEdges.isEmpty()) {
                    S.add(m);
                }
            }
        }
        // Check to see if all edges are removed
        boolean cycle = false;
        for (Graph.Node n : allNodes) {
            if (!n.inEdges.isEmpty()) {
                cycle = true;
                break;
            }
        }
        if (cycle) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
