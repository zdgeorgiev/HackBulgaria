import java.util.Comparator;
import java.util.Scanner;

public class Median {

    private Heap<Integer> minHeap;
    private Heap<Integer> maxHeap;
    private Integer median;

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

        if (this.median == null) {
            minHeap.push(number);
            this.median = number;
        } else {
            if (number >= this.median) {

                if (this.minHeap.getSize() - 1 == this.maxHeap.getSize()) {
                    this.maxHeap.push(this.minHeap.pop());
                    this.minHeap.push(number);
                    this.median = this.minHeap.peek();
                } else {
                    this.minHeap.push(number);
                }
            } else {

                if (this.minHeap.getSize() == this.maxHeap.getSize()) {
                    this.minHeap.push(this.maxHeap.pop());
                    this.maxHeap.push(number);
                    this.median = this.minHeap.peek();
                } else {
                    this.maxHeap.push(number);
                }
            }
        }

        System.out.println(this.median);
    }

    public static void main(String[] args) {
        Median m = new Median();

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            m.insert(s.nextInt());
        }
    }
}