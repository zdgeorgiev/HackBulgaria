package blockQueue;

public class Program {
    public static void main(String[] args) throws InterruptedException {

        final BlockQueue<Integer> bq = new BlockQueue<Integer>(10);

        Thread a = new Thread(new MyRunnable("GET", bq));

        Thread b = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    bq.add(i);
                }
            }
        });

        a.start();
        b.start();
    }
}
