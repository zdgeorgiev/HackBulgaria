import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class RMQTest {

    private RMQ rmq;

    @Test
    public void test() {

        ArrayList<Integer> input = new ArrayList<Integer>();

        for (int i = 1; i < 9; i++) {
            input.add(i);
        }

        this.rmq = new RMQ(input);

        int minNumber = this.rmq.min(2, 4);

        assertTrue(minNumber == 3);
    }

    @Test
    public void test2() {

        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(19);
        input.add(11);
        input.add(15);
        input.add(4);
        input.add(7);
        input.add(13);
        input.add(11);
        input.add(2);
        input.add(3);
        input.add(5);
        input.add(12);
        input.add(7);
        input.add(23);
        input.add(17);
        input.add(4);
        input.add(6);

        this.rmq = new RMQ(input);

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(this.rmq.min(0, 4));
        actual.add(this.rmq.min(5, 10));
        this.rmq.set(4, 3);
        actual.add(this.rmq.min(4, 8));
        actual.add(this.rmq.min(0, 6));
        this.rmq.set(15, 8);
        actual.add(this.rmq.min(15, 15));
        actual.add(this.rmq.min(10, 13));

        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(2);
        expected.add(2);
        expected.add(3);
        expected.add(8);
        expected.add(7);

        assertTrue(this.areEqual(actual, expected));
    }

    private boolean areEqual(ArrayList<Integer> first, ArrayList<Integer> second) {

        if (first.size() != second.size()) {
            return false;
        }

        for (int i = 0; i < first.size(); i++) {
            if (!first.get(i).equals(second.get(i))) {
                return false;
            }
        }

        return true;
    }
}
