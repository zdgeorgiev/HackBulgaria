import java.util.Comparator;
import java.util.Scanner;

public class Median {

    private Heap<Integer> minHeap;
    private Heap<Integer> maxHeap;
    private Integer median;

    private StringBuilder result = new StringBuilder();

    public Median() {
        this.minHeap = new Heap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        this.maxHeap = new Heap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    // inserts the number and returns the median
    public void insert(Integer number) {

        // TODO:

        result.append(this.median + "\n");
    }

    public static void main(String[] args) {
        Median m = new Median();

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            m.insert(s.nextInt());
        }

        System.out.println(m.result.substring(0, m.result.length() - 1));
    }
}