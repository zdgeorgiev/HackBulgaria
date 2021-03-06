import java.util.ArrayList;

public class PhoneBook {

    public static class Contact {

        public String name;
        public int number;
    }

    private BinarySearchTree data;

    public PhoneBook() {
        this.data = new BinarySearchTree();
    }

    // inserts a new contact
    public void insert(Contact contact) {
        this.data.insert(contact);
    }

    // lookup a name and print its phone number
    public int lookup(String name) {
        return this.data.search(name);
    }

    // list all records in an alphabetical order
    public ArrayList<String> list() {
        return this.data.getOrdered();
    }

    // remove a record for a given name
    public void remove(String name) {
        this.data.remove(this.data.head, name);
    }
}
