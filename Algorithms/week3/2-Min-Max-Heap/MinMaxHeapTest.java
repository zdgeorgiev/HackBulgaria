import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MinMaxHeapTest {

    @Test
    public void test() {
        MinMaxHeap minMaxHeap = new MinMaxHeap();

        MinMaxHeap.Node node1 = new MinMaxHeap.Node();
        node1.value = 20;

        MinMaxHeap.Node node2 = new MinMaxHeap.Node();
        node2.value = 13;

        MinMaxHeap.Node node3 = new MinMaxHeap.Node();
        node3.value = 5;

        MinMaxHeap.Node node4 = new MinMaxHeap.Node();
        node4.value = 3;

        MinMaxHeap.Node node5 = new MinMaxHeap.Node();
        node5.value = 25;

        MinMaxHeap.Node node6 = new MinMaxHeap.Node();
        node6.value = 19;

        MinMaxHeap.Node node7 = new MinMaxHeap.Node();
        node7.value = 22;

        MinMaxHeap.Node node8 = new MinMaxHeap.Node();
        node8.value = 29;

        MinMaxHeap.Node node9 = new MinMaxHeap.Node();
        node9.value = 1;

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node6;

        node3.left = node4;

        node5.left = node7;
        node5.right = node8;

        MinMaxHeap.Node node10 = new MinMaxHeap.Node();
        node10.value = 24;

        node8.left = node10;

        assertTrue(minMaxHeap.isMinMax(node1));
    }
}