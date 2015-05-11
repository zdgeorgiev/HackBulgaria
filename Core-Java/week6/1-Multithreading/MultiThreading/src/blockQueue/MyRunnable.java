package blockQueue;

public class MyRunnable implements Runnable {
    public String name;
    BlockQueue bq = new BlockQueue();

    public MyRunnable(String name, BlockQueue bq) {
        this.name = name;
        this.bq = bq;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.name + " - " + this.bq.peek());
        this.bq.poll();
    }
}
