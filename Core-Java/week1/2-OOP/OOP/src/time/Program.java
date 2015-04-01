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

/*
 * class Factory { public static Base createBase() { //configuration data for
 * creation of Base //invariant check return new Base(); } }
 */

// immutable class - doesn't contains setters
// methods should return copy of the object not their references

// private final Object i, j;
// Pair(i, j) -> i, j wont change references
// it changes his state but doesn't change his reference

// java practicies.com

// effect implements the interface