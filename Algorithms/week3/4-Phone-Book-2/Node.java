public class Node {

    public PhoneBook.Contact value;
    public Node left;
    public Node right;

    public Node(PhoneBook.Contact contact) {
        this.value = contact;
        this.left = null;
        this.right = null;
    }

    public PhoneBook.Contact getValue() {
        return value;
    }
}
