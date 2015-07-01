import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PhoneBookTest {

    private PhoneBook book;

    @Before
    public void init() {
        this.book = new PhoneBook();
    }

    @Test
    public void test() {

        ArrayList<String> actual = new ArrayList<String>();

        PhoneBook.Contact c1 = new PhoneBook.Contact();
        c1.name = "Stanislav";
        c1.number = 1;
        this.book.insert(c1);

        PhoneBook.Contact c2 = new PhoneBook.Contact();
        c2.name = "Rado";
        c2.number = 15;
        this.book.insert(c2);

        actual.add(String.format("%s", this.book.lookup("Rado")));

        PhoneBook.Contact c3 = new PhoneBook.Contact();
        c3.name = "Ivan";
        c3.number = 6;
        this.book.insert(c3);

        actual.add(String.format("%s", this.book.lookup("Ivan")));

        PhoneBook.Contact c4 = new PhoneBook.Contact();
        c4.name = "Ivan";
        c4.number = 8;
        this.book.insert(c4);

        actual.add(String.format("%s", this.book.lookup("Ivan")));
        actual.add(String.format("%s", this.book.lookup("Pesho")));

        this.book.remove("Ivan");

        actual.add(String.format("%s", this.book.lookup("Ivan")));

        PhoneBook.Contact c5 = new PhoneBook.Contact();
        c5.name = "Ani";
        c5.number = 23;
        this.book.insert(c5);

        PhoneBook.Contact c6 = new PhoneBook.Contact();
        c6.name = "Pesho";
        c6.number = 44;
        this.book.insert(c6);

        PhoneBook.Contact c7 = new PhoneBook.Contact();
        c7.name = "Eli";
        c7.number = 77;
        this.book.insert(c7);

        PhoneBook.Contact c8 = new PhoneBook.Contact();
        c8.name = "Georgi";
        c8.number = 83;
        this.book.insert(c8);

        actual.add(this.book.list().toString());

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("15");
        expected.add("6");
        expected.add("8");
        expected.add("NOT FOUND!");
        expected.add("NOT FOUND!");
        expected.add("[Ani 23, Eli 77, Georgi 83, Pesho 44, Rado 15, Stanislav 1]");

        assertTrue(this.areEqual(actual, expected));
    }

    private boolean areEqual(ArrayList<String> first, ArrayList<String> second) {

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
