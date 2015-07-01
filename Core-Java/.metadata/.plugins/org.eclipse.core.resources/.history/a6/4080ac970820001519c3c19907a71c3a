import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class RMQBinaryIndexedTreeTest {

    private RMQBinaryIndexedTree b;

    @Test
    public void test() {

        ArrayList<Integer> input = new ArrayList<Integer>();

        for (int i = 1; i < 9; i++) {
            input.add(i);
        }

        this.b = new RMQBinaryIndexedTree(input, 8);

        String actual = this.b.toString();
        System.out.println(actual);
        String expected = "[1, 1, 5, 1, 3, 5, 7, 1, 2, 3, 4, 5, 6, 7, 8]";

        assertTrue(actual.equals(expected));
    }
}
