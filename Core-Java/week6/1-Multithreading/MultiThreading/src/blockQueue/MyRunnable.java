package blockQueue;

public class MyRunnable implements Runnable {
    private String name;
    private BlockQueue<Integer> bq;

    public MyRunnable(String name, BlockQueue<Integer> bq) {
        this.name = name;
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            bq.poll();
            System.out.println(" Called by Thread " + this.name);
        }
    }
}
