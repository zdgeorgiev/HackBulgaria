package rotateCollection;

import java.util.ArrayList;
import java.util.Collection;

public class Program {
    public static void main(String[] args) {
        Collection<Integer> myCollection = new ArrayList<Integer>();

        for (int i = 0; i < 7; i++) {
            myCollection.add(i + 1);
        }

        System.out.println(myCollection);

        // rotate(myCollection, -1);
        // System.out.println(myCollection);
        rotate(myCollection, 8);
        System.out.println(myCollection);
    }

    public static void rotate(Collection<Integer> collection, int step) {

        int index = 0;
        step = step % collection.size();
        Integer reversed[] = new Integer[collection.size()];

        for (Integer number : collection) {
            int nextIndex = (index + step + collection.size()) % collection.size();
            reversed[nextIndex] = number;
            index++;
        }

        collection.clear();

        for (Integer number : reversed) {
            collection.add(number);
        }
    }
}