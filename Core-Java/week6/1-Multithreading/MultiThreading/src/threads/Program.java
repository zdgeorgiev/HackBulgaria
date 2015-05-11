package threads;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        final MyInteger m = new MyInteger();

        Thread A = new Thread(new MyRunnable("A", m));
        Thread B = new Thread(new MyRunnable("B", m));

        A.start();
        B.start();

        A.join();
        B.join();
    }
}