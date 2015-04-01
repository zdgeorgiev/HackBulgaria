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

/*
 * class Factory { public static Base createBase() { //configuration data for
 * creation of Base //invariant check return new Base(); } }
 */

// immutable class - doesn't contains setters
// methods should return copy of the object not their references

// private final Object i, j;
// Pair(i, j) -> i, j wont change references
// it changes his state but doesn't change his reference

// java practicies.com

// effect implements the interface

