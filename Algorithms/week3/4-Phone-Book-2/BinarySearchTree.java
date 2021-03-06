import java.util.ArrayList;

public class BinarySearchTree {

    public Node head = null;

    private ArrayList<String> sortedArray = new ArrayList<String>();

    public void insert(PhoneBook.Contact contact) {

        if (head == null) {
            this.head = new Node(contact);
        } else {

            Node headCpy = this.head;
            Node parent = null;

            while (true) {

                parent = headCpy;

                if (contact.name.compareTo(headCpy.value.name) > 0) {
                    headCpy = headCpy.right;

                    if (headCpy == null) {
                        parent.right = new Node(contact);
                        break;
                    }
                } else if (contact.name.compareTo(headCpy.value.name) < 0) {
                    headCpy = headCpy.left;

                    if (headCpy == null) {
                        parent.left = new Node(contact);
                        break;
                    }
                } else {
                    headCpy.value.number = contact.number;
                    break;
                }
            }
        }
    }

    public Node remove(Node root, String name) {

        if (root == null)
            return null;
        else if (root.value.name.compareTo(name) > 0)
            root.left = remove(root.left, name);
        else if (root.value.name.compareTo(name) < 0)
            root.right = remove(root.right, name);
        else {
            if (root.left == null && root.right == null) {
                if (root == this.head) {
                    this.head = null;
                    return null;
                }

                root = null;
            } else if (root.right != null && root.left == null) {
                root = root.right;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else {
                Node minNode = getMinNodeRightSubTree(root.right);
                root.right = this.remove(root.right, minNode.value.name);
                root.value = minNode.value;
            }
        }

        return root;
    }

    private Node getMinNodeRightSubTree(Node headCpy) {
        Node minNode = headCpy;

        while (minNode.left != null) {
            minNode = minNode.left;
        }

        return minNode;
    }

    public int search(String name) {

        Node headCpy = this.head;

        while (headCpy != null) {

            if (headCpy.value.name.equals(name)) {
                return headCpy.value.number;
            } else if (headCpy.value.name.compareTo(name) < 0) {
                headCpy = headCpy.right;
            } else {
                headCpy = headCpy.left;
            }
        }

        return -1;
    }

    public ArrayList<String> getOrdered() {
        if (this.head != null) {
            this.getSubTree(this.head);
        }

        return this.sortedArray;
    }

    private void getSubTree(Node head) {

        if (head == null) {
            return;
        }

        getSubTree(head.left);
        this.sortedArray.add(head.value.name + " " + head.value.number);
        getSubTree(head.right);
    }
}
