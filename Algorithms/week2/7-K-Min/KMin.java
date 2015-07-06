import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KMin {

    private Heap<Integer> maxHeap = new Heap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    // Finds the k-th minimum element in an unsorted collection.
    public int kthMinimum(List<Integer> numbers, int k) {

        for (int i = 0; i < k; i++) {
            this.maxHeap.push(numbers.get(i));
        }

        for (int i = k; i < numbers.size(); i++) {

            if (numbers.get(i) < this.maxHeap.peek()) {
                this.maxHeap.pop();
                this.maxHeap.push(numbers.get(i));
            }
        }

        return this.maxHeap.pop();
    }
}