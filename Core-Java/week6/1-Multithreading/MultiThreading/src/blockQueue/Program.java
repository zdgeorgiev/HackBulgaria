package blockQueue;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> bq = new BlockQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            bq.add(new Integer(i));
        }

        Thread a = new Thread(new MyRunnable("A", bq));
        Thread b = new Thread(new MyRunnable("B", bq));

        a.start();
        b.start();
        a.join();
        b.join();
    }
}
