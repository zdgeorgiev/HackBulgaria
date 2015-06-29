import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KListsTest {

    private KLists klist = new KLists();

    @Test
    public void test() {

        List<ArrayList<Integer>> allArrays = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(3);
        first.add(5);
        first.add(7);
        first.add(9);

        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(2);
        second.add(4);
        second.add(6);

        ArrayList<Integer> third = new ArrayList<Integer>();
        third.add(0);
        third.add(1);
        third.add(8);
        third.add(10);

        allArrays.add(first);
        allArrays.add(second);
        allArrays.add(third);

        String actual = klist.merge(allArrays);
        String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]";

        System.out.println(actual);

        assertTrue(actual.equals(expected));
    }
}
