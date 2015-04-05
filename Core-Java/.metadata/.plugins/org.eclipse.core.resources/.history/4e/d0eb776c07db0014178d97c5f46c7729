package firstUnique;

import java.util.Arrays;
import java.util.Collection;

public class Program {
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);

        System.out.println(firstUnique(ints));
    }

    public static Integer firstUnique(Collection<Integer> collection) {
        Integer cpy[] = new Integer[collection.size()];
        cpy = collection.toArray(cpy);

        Arrays.sort(cpy);

        for (int i = 0; i < cpy.length - 1; i++) {
            if (cpy[i] != cpy[i + 1]) {
                return cpy[i];
            } else {
                i++;
            }
        }

        return null;
    }
}