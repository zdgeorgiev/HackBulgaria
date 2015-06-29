import java.util.ArrayList;
import java.util.List;

public class KLists {

    private Heap heap = new Heap();

    public class Node {
        public int value;
        public Node next;
    }

    // Merge K sorted lists.
    public String merge(List<ArrayList<Integer>> lists) {

        for (int i = 0; i < lists.size(); i++) {

            for (Integer number : lists.get(i)) {
                this.heap.add(number);
            }
        }

        return this.heap.sort().toString();
    }
}
