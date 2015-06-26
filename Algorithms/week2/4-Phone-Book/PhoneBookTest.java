package phoneBook;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PhoneBookTest {

    private ArrayList<Person> phoneBook = new ArrayList<Person>();

    @Test
    public void test() {

        this.phoneBook.add(new Person("Stefan", 886123123));
        this.phoneBook.add(new Person("Gloria", 884551741));
        this.phoneBook.add(new Person("Ivan", 887111111));
        this.phoneBook.add(new Person("Nikola", 885555444));
        this.phoneBook.add(new Person("Petko", 888888888));

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(888888888);
        numbers.add(885555444);
        numbers.add(884551741);
        numbers.add(999999999);

        List<ArrayList<String>> actual = PhoneBookUtils.lookupNames(this.phoneBook, numbers);

        List<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();

        ArrayList<String> currentPerson = new ArrayList<String>();

        currentPerson.add("888888888");
        currentPerson.add("Petko");
        expected.add(currentPerson);
        currentPerson = new ArrayList<String>();

        currentPerson.add("885555444");
        currentPerson.add("Nikola");
        expected.add(currentPerson);
        currentPerson = new ArrayList<String>();

        currentPerson.add("884551741");
        currentPerson.add("Gloria");
        expected.add(currentPerson);
        currentPerson = new ArrayList<String>();

        currentPerson.add("999999999");
        currentPerson.add("Not exist");
        expected.add(currentPerson);
        currentPerson = new ArrayList<String>();

        assertTrue(areEqual(actual, expected));
    }

    private static boolean areEqual(List<ArrayList<String>> first, List<ArrayList<String>> second) {

        if (first.size() != second.size()) {
            return false;
        }

        for (int i = 0; i < first.size(); i++) {
            if (!first.get(i).get(0).equals(second.get(i).get(0)) || !first.get(i).get(1).equals(second.get(i).get(1))) {
                return false;
            }
        }

        return true;
    }
}