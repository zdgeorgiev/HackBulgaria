package threads;

public class MyRunnable implements Runnable {
    public String name;
    public MyInteger myInt;

    public MyRunnable(String name, MyInteger myInt) {
        this.name = name;
        this.myInt = myInt;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + name + ": " + MyInteger.counter);
            myInt.increment();
        }

        System.out.println("Thread " + name + ": " + MyInteger.counter);
    }
}