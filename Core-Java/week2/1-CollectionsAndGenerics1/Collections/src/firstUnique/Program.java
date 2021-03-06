package firstUnique;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);

        System.out.println(firstUnique(ints));
    }

    public static Integer firstUnique(Collection<Integer> collection) {
        TreeSet<Integer> numbers = new TreeSet<Integer>();

        for (Integer numb : collection) {
            if (numbers.contains(numb)) {
                numbers.remove(numb);
            } else {
                numbers.add(numb);
            }
        }

        return numbers.pollFirst();
    }
}