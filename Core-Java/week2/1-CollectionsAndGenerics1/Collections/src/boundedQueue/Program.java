package boundedQueue;

public class Program {
    public static void main(String[] args) {
        BoundedQueue<Integer> myCollection = new BoundedQueue<Integer>(5);

        for (int i = 0; i < 10; i++) {
            myCollection.offer(i);
        }

        System.out.println(myCollection);

        BoundedQueue<Integer> boundedQueue = new BoundedQueue<Integer>(3);

        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);

        System.out.println(boundedQueue); // 3,4,5
    }
}
