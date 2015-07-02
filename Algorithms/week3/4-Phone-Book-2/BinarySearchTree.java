import java.util.ArrayList;

public class BinarySearchTree {

    private Node head = null;

    private ArrayList<String> sortedArray = new ArrayList<String>();

    public void insert(PhoneBook.Contact contact) {

        if (head == null) {
            this.head = new Node(contact);
        } else {

            Node headCpy = this.head;
            Node parent = null;

            while (true) {

                parent = headCpy;

                if (contact.name.compareTo(headCpy.value.name) >= 1) {
                    headCpy = headCpy.right;

                    if (headCpy == null) {
                        headCpy = new Node(contact);
                        parent.right = headCpy;
                        break;
                    }
                } else if (contact.name.compareTo(headCpy.value.name) <= -1) {
                    headCpy = headCpy.left;

                    if (headCpy == null) {
                        headCpy = new Node(contact);
                        parent.left = headCpy;
                        break;
                    }
                } else {
                    headCpy.value.number = contact.number;
                    break;
                }
            }
        }
    }

    public void remove(String contact) {
        // TODO Auto-generated method stub
    }

    public int binarySearch(String name) {

        Node headCpy = this.head;

        while (headCpy != null) {

            if (headCpy.value.name.equals(name)) {
                return headCpy.value.number;
            } else if (headCpy.value.name.compareTo(name) < 1) {
                headCpy = headCpy.right;
            } else {
                headCpy = headCpy.left;
            }
        }

        return -1;
    }

    public ArrayList<String> getOrdered() {
        this.getSubTree(this.head);
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
