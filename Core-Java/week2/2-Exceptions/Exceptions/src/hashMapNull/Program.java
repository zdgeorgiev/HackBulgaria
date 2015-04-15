package hashMapNull;

public class Program {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> my = new MyHashMap<Integer, Integer>(true);
        MyHashMap<Integer, Integer> my2 = new MyHashMap<Integer, Integer>();

        try {
            my.put(null, 5);
            my2.put(null, 5);
        } catch (NullHashMapKey e) {
            System.out.println(e.getMessage());
        }
    }
}