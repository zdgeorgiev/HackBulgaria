package stackLinkedList;

public class Program {

    public static void main(String[] args) {
        Stack s = new StackImpl();

        Item i1 = new Item(new String("A"));
        Item i2 = new Item(new String("B"));
        Item i3 = new Item(new String("C"));
        Item i4 = new Item(new String("D"));
        Item i5 = new Item(new String("D"));

        // Item i1 = new Item(new Integer(1));
        // Item i2 = new Item(new Integer(2));
        // Item i3 = new Item(new Integer(3));
        // Item i4 = new Item(new Integer(4));

        s.push(i1);
        s.push(i2);
        s.push(i3);
        s.push(i4);
        s.push(i5);

        while (!s.isEmpty()) {
            Item poped = s.pop();
        }
    }
}