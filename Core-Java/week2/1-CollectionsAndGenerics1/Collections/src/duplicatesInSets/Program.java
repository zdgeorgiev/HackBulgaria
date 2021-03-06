package duplicatesInSets;

import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        Set<Integer> first = new HashSet<Integer>();
        for (int i = 0; i < 5; i++) {
            first.add(i + 1);
        }

        Set<Integer> second = new HashSet<Integer>();
        for (int i = 3; i < 6; i++) {
            second.add(i + 1);
        }

        Set<Integer> third = new HashSet<Integer>();
        for (int i = 4; i < 8; i++) {
            third.add(i + 1);
        }

        System.out.println(duplicatesItems(first, second, third));
    }

    public static HashSet<Integer> duplicatesItems(Set<Integer>... hashSets) {
        int hashSetsCount = 0;
        int minSize = Integer.MAX_VALUE;
        Set<Integer> shortest = null;

        for (Set<Integer> hashSet : hashSets) {
            if (hashSet.size() < minSize) {
                minSize = hashSet.size();
                shortest = hashSet;
            }

            hashSetsCount++;
        }

        Set<Integer> duplicates = new HashSet<Integer>();

        for (Integer numb : shortest) {
            int occurs = 0;

            // Search in other sets
            for (Set<Integer> hashSet : hashSets) {
                if (hashSet == shortest) {
                    continue;
                }

                // Compare every number of the set
                for (Integer otherNumb : hashSet) {
                    if (numb == otherNumb) {
                        occurs++;
                        break;
                    }
                }
            }

            if (occurs == hashSetsCount - 1) {
                duplicates.add(numb);
            }
        }

        return (HashSet<Integer>) duplicates;
    }
}