package queue;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private Queue myQueue;

    @Before
    public void init() {
        this.myQueue = new QueueImpl();
    }

    @Test
    public void testToString() {

        for (int i = 1; i <= 5; i++) {
            this.myQueue.push(new Node(i));
        }

        String expected = "[1, 2, 3, 4, 5]";
        String actual = myQueue.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testPeek() {

        for (int i = 0; i < 5; i++) {
            this.myQueue.push(new Node(i));
        }

        Node head = this.myQueue.peek();

        assertTrue(head.getValue() == 0);
    }

    @Test
    public void testPush() {

        for (int i = 0; i < 30; i++) {
            this.myQueue.push(new Node(i));
        }

        assertTrue(this.myQueue.size() == 30);
    }

    @Test
    public void testPop() {

        for (int i = 0; i < 5; i++) {
            this.myQueue.push(new Node(i));
        }

        // Remove the first element
        this.myQueue.pop();

        String expected = "[1, 2, 3, 4]";
        String actual = myQueue.toString();

        assertTrue(expected.equals(actual));
    }
}
