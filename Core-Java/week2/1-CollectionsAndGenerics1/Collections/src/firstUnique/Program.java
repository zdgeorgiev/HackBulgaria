package firstUnique;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Program {
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);

        System.out.println(firstUnique(ints));
    }

    public static Integer firstUnique(Collection<Integer> collection) {
        LinkedHashMap<Integer, Integer> numbers = new LinkedHashMap<Integer, Integer>();

        for (Integer i : collection) {
            if (numbers.containsKey(i)) {
                numbers.replace(i, numbers.get(i), numbers.get(i) + 1);
            } else {
                numbers.put(i, 1);
            }
        }

        for (Entry<Integer, Integer> number : numbers.entrySet()) {
            if (number.getValue() == 1) {
                return number.getKey();
            }
        }

        return null;
    }
}