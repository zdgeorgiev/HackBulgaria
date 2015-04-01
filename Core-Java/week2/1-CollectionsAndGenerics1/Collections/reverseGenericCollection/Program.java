package reverseGenericCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            c.add(i);
        }

        System.out.println(c);

        reverse(c);

        System.out.println(c);
    }

    static <T> void reverse(Collection<T> c) {
        Stack<T> reversed = new Stack<T>();
        for (T item : c) {
            reversed.push(item);
        }

        c.clear();

        while (!reversed.isEmpty()) {
            c.add(reversed.pop());
        }
    }
}