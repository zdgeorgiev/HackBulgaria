public class MinMaxHeap {

    public static class Node {

        public int value;
        public Node left;
        public Node right;
    }

    // Checks if a binary tree is a min/max heap.
    public boolean isMinMax(Node root) {
        return minMaxHeapUtil(root, Integer.MAX_VALUE);
    }

    private boolean minMaxHeapUtil(Node root, int rootValue) {

        if (root == null) {
            return true;
        }

        return checkLeftSubTree(root.left, root.value) && checkRightSubTree(root.right, root.value);
    }

    private static boolean checkLeftSubTree(Node node, int parentValue) {

        if (node == null) {
            return true;
        }

        if (node.value <= parentValue) {
            return checkLeftSubTree(node.left, node.value) && checkRightSubTree(node.right, node.value);
        } else {
            return false;
        }
    }

    private static boolean checkRightSubTree(Node node, int parentValue) {

        if (node == null) {
            return true;
        }

        if (node.value > parentValue) {
            return checkLeftSubTree(node.left, node.value) && checkRightSubTree(node.right, node.value);
        } else {
            return false;
        }
    }
}
