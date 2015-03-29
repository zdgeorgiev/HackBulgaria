package Stack;

public class Program {

    public static void main(String[] args) {
        StackImpl s = new StackImpl();

        // Item i1 = new Item(new String("A"));
        // Item i2 = new Item(new String("B"));
        // Item i3 = new Item(new String("C"));
        // Item i4 = new Item(new String("D"));

        Item i1 = new Item(new Integer(1));
        Item i2 = new Item(new Integer(2));
        Item i3 = new Item(new Integer(3));
        Item i4 = new Item(new Integer(4));

        s.push(i1);
        s.push(i2);
        s.push(i3);
        s.push(i4);

        for (int i = 0; i < 4; i++) {
            s.pop();
        }

        System.out.println(s.isEmpty());
    }
}