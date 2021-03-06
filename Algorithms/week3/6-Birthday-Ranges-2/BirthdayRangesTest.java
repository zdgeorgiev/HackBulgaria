import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class BirthdayRangesTest {

    @Test
    public void test() {

        ArrayList<Integer> birthdays = new ArrayList<Integer>();

        birthdays.add(5);
        birthdays.add(10);
        birthdays.add(6);
        birthdays.add(7);
        birthdays.add(3);
        birthdays.add(4);
        birthdays.add(5);
        birthdays.add(11);
        birthdays.add(21);
        birthdays.add(300);
        birthdays.add(15);

        BirthdayRanges bInRanges = new BirthdayRanges(birthdays);

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

        ArrayList<Integer> birthdays = new ArrayList<Integer>();

        birthdays.add(19);
        birthdays.add(11);
        birthdays.add(15);
        birthdays.add(4);
        birthdays.add(7);
        birthdays.add(13);
        birthdays.add(11);
        birthdays.add(2);

        BinaryIndexedTree tree = new BinaryIndexedTree(birthdays, 8);

        String expected = "[82, 49, 33, 30, 19, 20, 13, 19, 11, 15, 4, 7, 13, 11, 2]";
        String actual = tree.toString();
        System.out.println(actual);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testBinaryIndexedTreeAdd() {

        ArrayList<Integer> birthdays = new ArrayList<Integer>();

        birthdays.add(19);
        birthdays.add(11);
        birthdays.add(15);
        birthdays.add(4);
        birthdays.add(7);
        birthdays.add(13);
        birthdays.add(11);
        birthdays.add(2);

        BinaryIndexedTree tree = new BinaryIndexedTree(birthdays, 8);

        tree.add(5, 8);

        String expected = "[90, 49, 41, 30, 19, 28, 13, 19, 11, 15, 4, 7, 21, 11, 2]";
        String actual = tree.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testBinaryIndexedTreeRemove() {

        ArrayList<Integer> birthdays = new ArrayList<Integer>();

        birthdays.add(19);
        birthdays.add(11);
        birthdays.add(15);
        birthdays.add(4);
        birthdays.add(7);
        birthdays.add(21);
        birthdays.add(11);
        birthdays.add(2);

        BinaryIndexedTree tree = new BinaryIndexedTree(birthdays, 8);

        tree.remove(5, 8);

        String expected = "[82, 49, 33, 30, 19, 20, 13, 19, 11, 15, 4, 7, 13, 11, 2]";
        String actual = tree.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testBinaryIndexedResize() {

        ArrayList<Integer> birthdays = new ArrayList<Integer>();

        birthdays.add(19);
        birthdays.add(11);
        birthdays.add(15);
        birthdays.add(4);
        birthdays.add(7);

        BinaryIndexedTree tree = new BinaryIndexedTree(birthdays, 5);
        BirthdayRanges b = new BirthdayRanges(birthdays);

        String expected = "[56, 49, 7, 30, 19, 7, 0, 19, 11, 15, 4, 7, 0, 0, 0]";
        String actual = tree.toString();

        assertTrue(expected.equals(actual));
    }
}