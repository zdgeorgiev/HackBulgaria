package stack;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import queue.Node;

public class StackTest {

    private StackImpl myStack = new StackImpl();

    @Before
    public void init() {
        this.myStack = new StackImpl();
    }

    @Test
    public void testPush() {
        for (int i = 1; i <= 10; i++) {
            this.myStack.push(new Node(i));
        }

        String expected = "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]";
        String actual = this.myStack.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testPop() {
        for (int i = 1; i <= 10; i++) {
            this.myStack.push(new Node(i));
        }

        this.myStack.pop();

        String expected = "[9, 8, 7, 6, 5, 4, 3, 2, 1]";
        String actual = this.myStack.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testPushAndPop() {
        for (int i = 1; i <= 10; i++) {
            this.myStack.push(new Node(i));
        }

        this.myStack.push(new Node(50));
        this.myStack.pop();

        String expected = "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]";
        String actual = this.myStack.toString();

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testPopAndPeek() {
        for (int i = 1; i <= 10; i++) {
            this.myStack.push(new Node(i));
        }

        this.myStack.pop();
        this.myStack.push(new Node(10));
        Node lastNode = this.myStack.peek();

        assertTrue(lastNode.getValue() == 10);
    }
}