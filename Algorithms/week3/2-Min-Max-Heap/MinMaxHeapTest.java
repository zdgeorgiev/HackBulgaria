import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MinMaxHeapTest {

    @Test
    public void test() {
        MinMaxHeap minMaxHeap = new MinMaxHeap();

        MinMaxHeap.Node node1 = new MinMaxHeap.Node();
        node1.value = 20;

        MinMaxHeap.Node node2 = new MinMaxHeap.Node();
        node2.value = 40;

        MinMaxHeap.Node node3 = new MinMaxHeap.Node();
        node3.value = 93;

        MinMaxHeap.Node node4 = new MinMaxHeap.Node();
        node4.value = 29;

        MinMaxHeap.Node node5 = new MinMaxHeap.Node();
        node5.value = 21;

        MinMaxHeap.Node node6 = new MinMaxHeap.Node();
        node6.value = 26;

        MinMaxHeap.Node node7 = new MinMaxHeap.Node();
        node7.value = 22;

        MinMaxHeap.Node node8 = new MinMaxHeap.Node();
        node8.value = 37;

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        assertTrue(minMaxHeap.isMinMax(node1));
    }
}