public class MinMaxHeap {

    public static class Node {

        public int value;
        public Node left;
        public Node right;
    }

    // Checks if a binary tree is a min/max heap.
    public boolean isMinMax(Node root) {
        return minMaxHeapUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    }

    private static boolean minMaxHeapUtil(Node currentNode, int minValue, int maxValue, int level) {

        if (currentNode == null) {
            return true;
        }

        boolean isInRange = currentNode.value >= minValue && currentNode.value < maxValue;

        if ((level & 1) == 0) {
            maxValue = currentNode.value;
        } else {
            minValue = currentNode.value;
        }

        return isInRange && minMaxHeapUtil(currentNode.left, minValue, maxValue, level + 1)
                && minMaxHeapUtil(currentNode.right, minValue, maxValue, level + 1);
    }
}