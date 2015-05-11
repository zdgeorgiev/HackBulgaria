package blockQueue;

import java.util.PriorityQueue;

public class BlockQueue<T> extends PriorityQueue<T> {

    @Override
    public T poll() {
        synchronized (this) {
            if (this.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.notify();
                return super.poll();
            }

            return null;
        }
    }
}
