package threads;

public class MyInteger {
    public static Integer counter;

    public MyInteger() {
        counter = new Integer(0);
    }

    public synchronized void increment() {
        counter++;
    }
}