import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortingTest {

    private ArrayList<Integer> arr;

    @Before
    public void initArray() {
        this.arr = new ArrayList<Integer>();

        for (int i = 0; i < 100_000; i++) {
            arr.add(new Integer(new Random().nextInt(1_000)));
        }
    }

    @Test
    public void testSelectionSort() {
        SelectionSort s = new SelectionSort();
        s.sort(this.arr);
        assertTrue(this.isSorted());
    }

    @Test
    public void testInsertionSort() {
        InsertionSort i = new InsertionSort();
        i.sort(this.arr);
        assertTrue(this.isSorted());
    }

    @Test
    public void testMergeSort() {
        MergeSort m = new MergeSort();
        m.sort(this.arr);
        assertTrue(this.isSorted());
    }

    @Test
    public void testQuickSort() {
        QuickSort q = new QuickSort();
        q.sort(this.arr);
        assertTrue(this.isSorted());
    }

    @Test
    public void testCountSort() {
        CountSort c = new CountSort();
        c.sort(this.arr);
        assertTrue(this.isSorted());
    }

    @Test
    public void testHeapSort() {
        HeapSort h = new HeapSort();
        h.sort(this.arr);
        assertTrue(this.isSorted());
    }

    private boolean isSorted() {
        for (int i = 0; i < this.arr.size() - 1; i++) {
            if (this.arr.get(i) > this.arr.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}