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
    public void testPeek() {

        for (int i = 0; i < 5; i++) {
            this.myQueue.push(new Node(i));
        }

        Node head = this.myQueue.peek();

        assertTrue(head.getValue() == 0);
    }

    @Test
    public void testPushAndThenPeek() {

        for (int i = 0; i < 5; i++) {
            this.myQueue.push(new Node(i));
        }

        this.myQueue.pop();
        Node head = this.myQueue.peek();

        assertTrue(head.getValue() == 1);
    }
}
