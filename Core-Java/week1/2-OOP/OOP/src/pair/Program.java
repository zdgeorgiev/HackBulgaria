package pair;

public class Program {

    public static void main(String[] args) {
        String first = new String("eqwqe");
        Integer second = new Integer(30);

        Pair p = new Pair(first, second);

        System.out.println(p);

        String first2 = new String("eqwqe");
        Integer second2 = new Integer(30);

        Pair p2 = new Pair(first2, second2);

        System.out.println(p2);

        System.out.println(p.equals(p2));
    }
}