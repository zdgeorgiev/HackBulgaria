package time;


public class Program {

    public static void main(String[] args) {
        System.out.println("CUSTOM");
        Time t1 = new Time(5, 10, 30, 15, 5, 13);

        System.out.print(t1);

        System.out.println("\nNOW");

        System.out.print(Time.now());
    }
}