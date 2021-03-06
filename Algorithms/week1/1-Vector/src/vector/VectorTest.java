package vector;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VectorTest {

    private Vector myVector;

    @Before
    public void init() {
        this.myVector = new VectorImpl();
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 11; i++) {
            this.myVector.add(i);
        }

        assertTrue(this.myVector.get(10) == 10);
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 21; i++) {
            this.myVector.add(i);
        }

        assertTrue(this.myVector.capacity() == 40);
    }

    @Test
    public void testAddAtFirstIndex() {
        for (int i = 1; i <= 10; i++) {
            this.myVector.add(i);
        }

        this.myVector.insert(0, 0);

        String actual = this.myVector.toString();
        String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]";

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testRemove() {
        for (int i = 1; i <= 10; i++) {
            this.myVector.add(i);
        }

        this.myVector.remove(5);

        String actual = this.myVector.toString();
        String expected = "[1, 2, 3, 4, 5, 7, 8, 9, 10]";

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testRemoveAll() {
        for (int i = 1; i <= 50; i++) {
            this.myVector.add(i);
        }

        while (this.myVector.size() > 0) {
            this.myVector.remove(0);
        }

        String actual = this.myVector.toString();
        String expected = "[]";

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testPop() {
        for (int i = 1; i <= 50; i++) {
            this.myVector.add(i);
        }

        this.myVector.pop();
        assertTrue(this.myVector.pop() == 49);
    }
}