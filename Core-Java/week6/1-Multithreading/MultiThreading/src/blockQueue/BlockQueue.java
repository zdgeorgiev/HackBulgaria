package blockQueue;

import java.util.ArrayList;

public class BlockQueue<T> {
    private ArrayList<T> list;
    private Object lock = new Object();
    private int size;

    public BlockQueue(int size) {
        this.list = new ArrayList<>();
        this.size = size;
    }

    public void add(T arg0) {
        synchronized (this.lock) {
            while (this.list.size() == size) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            this.list.add(arg0);
            this.lock.notifyAll();
        }
    }

    public T poll() {
        synchronized (this.lock) {
            while (this.list.isEmpty()) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T temp = list.get(0);
            System.out.print("List size: " + this.list.size() + "; poll - " + temp);
            this.list.remove(0);
            this.lock.notifyAll();
            return temp;
        }
    }
}