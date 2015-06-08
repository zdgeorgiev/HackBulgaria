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

        boolean isValid = true;

        for (int i = 0; i < this.myVector.size(); i++) {
            if (this.myVector.get(i) != i) {
                isValid = false;
                break;
            }
        }

        assertTrue(isValid);
    }
}