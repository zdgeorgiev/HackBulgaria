import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PhoneBookTest {

    private ArrayList<PhoneBook.Contact> phoneBook = new ArrayList<>();

    @Test
    public void test() {

        PhoneBook.Contact c1 = new PhoneBook.Contact();
        c1.name = "Stefan";
        c1.number = 886123123;
        this.phoneBook.add(c1);

        PhoneBook.Contact c2 = new PhoneBook.Contact();
        c2.name = "Gloria";
        c2.number = 884551741;
        this.phoneBook.add(c2);

        PhoneBook.Contact c3 = new PhoneBook.Contact();
        c3.name = "Nikola";
        c3.number = 885555444;
        this.phoneBook.add(c3);

        PhoneBook.Contact c4 = new PhoneBook.Contact();
        c4.name = "Petko";
        c4.number = 888888888;
        this.phoneBook.add(c4);

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(888888888);
        numbers.add(885555444);
        numbers.add(884551741);

        List<String> actual = PhoneBookUtils.lookupNames(this.phoneBook, numbers);

        List<String> expected = new ArrayList<String>();

        expected.add("Petko");
        expected.add("Nikola");
        expected.add("Gloria");

        assertTrue(areEqual(actual, expected));
    }

    @Test
    public void test2() {

        PhoneBook.Contact c1 = new PhoneBook.Contact();
        c1.name = "Stanislav";
        c1.number = 1;
        this.phoneBook.add(c1);

        PhoneBook.Contact c2 = new PhoneBook.Contact();
        c2.name = "Rado";
        c2.number = 15;
        this.phoneBook.add(c2);

        PhoneBook.Contact c3 = new PhoneBook.Contact();
        c3.name = "Ivan";
        c3.number = 6;
        this.phoneBook.add(c3);

        PhoneBook.Contact c4 = new PhoneBook.Contact();
        c4.name = "Ivan";
        c4.number = 8;
        this.phoneBook.add(c4);

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(15);
        numbers.add(8);

        List<String> actual = PhoneBookUtils.lookupNames(this.phoneBook, numbers);

        List<String> expected = new ArrayList<String>();

        expected.add("Rado");
        expected.add("Ivan");

        assertTrue(areEqual(actual, expected));
    }

    private static boolean areEqual(List<String> first, List<String> second) {

        if (first.size() != second.size()) {
            return false;
        }

        for (int i = 0; i < first.size(); i++) {
            if (!first.get(i).equals(second.get(i)) || !first.get(i).equals(second.get(i))) {
                return false;
            }
        }

        return true;
    }
}