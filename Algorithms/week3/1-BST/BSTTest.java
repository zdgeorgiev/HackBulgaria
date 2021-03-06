import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BSTTest {

    @Test
    public void test() {
        BST bst = new BST();

        BST.Node node1 = new BST.Node();
        node1.value = 20;

        BST.Node node2 = new BST.Node();
        node2.value = 13;

        BST.Node node3 = new BST.Node();
        node3.value = 5;

        BST.Node node4 = new BST.Node();
        node4.value = 3;

        BST.Node node5 = new BST.Node();
        node5.value = 25;

        BST.Node node6 = new BST.Node();
        node6.value = 19;

        BST.Node node7 = new BST.Node();
        node7.value = 22;

        BST.Node node8 = new BST.Node();
        node8.value = 29;

        BST.Node node9 = new BST.Node();
        node9.value = 1;

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node6;

        node3.left = node4;

        node5.left = node7;
        node5.right = node8;

        BST.Node node10 = new BST.Node();
        node10.value = 24;

        node8.left = node10;

        assertTrue(!bst.isBST(node1));
    }
}