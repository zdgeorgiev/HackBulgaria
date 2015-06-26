import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class BirthdayRangesTest {

    @Test
    public void test() {

        ArrayList<Integer> startBirthdays = new ArrayList<Integer>();

        startBirthdays.add(5);
        startBirthdays.add(10);
        startBirthdays.add(6);
        startBirthdays.add(7);
        startBirthdays.add(3);
        startBirthdays.add(4);
        startBirthdays.add(5);
        startBirthdays.add(11);
        startBirthdays.add(21);
        startBirthdays.add(300);
        startBirthdays.add(15);

        BirthdayRanges bInRanges = new BirthdayRanges(startBirthdays, 366);

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(bInRanges.count(2, 10));
        actual.add(bInRanges.count(10, 365));
        bInRanges.add(8, 3);
        actual.add(bInRanges.count(7, 11));
        bInRanges.remove(8, 2);
        actual.add(bInRanges.count(7, 11));
        bInRanges.add(18, 5);
        actual.add(bInRanges.count(10, 20));
        bInRanges.add(5, 1);
        actual.add(bInRanges.count(5, 25));
        bInRanges.remove(5, 10);
        actual.add(bInRanges.count(1, 10));

        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(7);
        expected.add(5);
        expected.add(6);
        expected.add(4);
        expected.add(8);
        expected.add(15);
        expected.add(6);

        assertTrue(areEqual(actual, expected));
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

    @Test
    public void testBinaryIndexedTreeBuild() {

        ArrayList<Integer> startBirthdays = new ArrayList<Integer>();

        startBirthdays.add(19);
        startBirthdays.add(11);
        startBirthdays.add(15);
        startBirthdays.add(4);
        startBirthdays.add(7);
        startBirthdays.add(13);
        startBirthdays.add(11);
        startBirthdays.add(2);

        BinaryIndexedTree tree = new BinaryIndexedTree(startBirthdays, 8);

        String expected = "[82, 49, 33, 30, 19, 20, 13, 19, 11, 15, 4, 7, 13, 11, 2]";
        String actual = tree.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testBinaryIndexedTreeAdd() {

        ArrayList<Integer> startBirthdays = new ArrayList<Integer>();

        startBirthdays.add(19);
        startBirthdays.add(11);
        startBirthdays.add(15);
        startBirthdays.add(4);
        startBirthdays.add(7);
        startBirthdays.add(13);
        startBirthdays.add(11);
        startBirthdays.add(2);

        BinaryIndexedTree tree = new BinaryIndexedTree(startBirthdays, 8);

        tree.add(5, 8);

        String expected = "[90, 49, 41, 30, 19, 28, 13, 19, 11, 15, 4, 7, 21, 11, 2]";
        String actual = tree.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testBinaryIndexedTreeRemove() {

        ArrayList<Integer> startBirthdays = new ArrayList<Integer>();

        startBirthdays.add(19);
        startBirthdays.add(11);
        startBirthdays.add(15);
        startBirthdays.add(4);
        startBirthdays.add(7);
        startBirthdays.add(21);
        startBirthdays.add(11);
        startBirthdays.add(2);

        BinaryIndexedTree tree = new BinaryIndexedTree(startBirthdays, 8);

        tree.remove(5, 8);

        String expected = "[82, 49, 33, 30, 19, 20, 13, 19, 11, 15, 4, 7, 13, 11, 2]";
        String actual = tree.toString();

        assertTrue(expected.equals(actual));
    }
}