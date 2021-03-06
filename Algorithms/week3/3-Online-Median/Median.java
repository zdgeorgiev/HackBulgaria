import java.util.Comparator;
import java.util.Scanner;

public class Median {

    private Heap<Integer> minHeap;
    private Heap<Integer> maxHeap;
    private Integer median;
    private int balance = 0;

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

        if (median == null) {
            minHeap.push(number);
            balance = 1;
            median = minHeap.peek();
        } else {

            switch (balance) {
                case 1:
                    if (number <= median) { // median stays the same
                        maxHeap.push(number);
                    } else {
                        minHeap.push(number);
                        maxHeap.push(minHeap.pop());
                        median = minHeap.peek();
                    }
                    balance = 0;
                    break;
                case 0:
                    if (number < median) {
                        maxHeap.push(number);
                        balance = -1;
                        median = maxHeap.peek();
                    } else {
                        minHeap.push(number);
                        balance = 1;
                        median = minHeap.peek();
                    }
                    break;
                case -1:
                    if (number <= median) {
                        maxHeap.push(number);
                        minHeap.push(maxHeap.pop());
                    } else { // median stays the same
                        minHeap.push(number);
                    }
                    balance = 0;
                    median = minHeap.peek();
                    break;
            }
        }

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