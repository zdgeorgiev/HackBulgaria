package doublyLinkedList;

public class Program {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedListImpl();

        dll.Add(new Node(1));
        dll.Add(new Node(2));
        dll.Add(new Node(3));

        // dll.Remove(1);

        Node first = dll.getFirst();
        Node middle = dll.get(1);
        Node last = dll.getLast();

        System.out.println("Size - " + dll.size());
        System.out.println("First - " + first.getData());
        System.out.println("At index 1 - " + middle.getData());
        System.out.println("Last - " + last.getData());
    }
}