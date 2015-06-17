package birthdayRanges;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class BirthdayUtils {

    public static List<Pair<List<Integer>, Integer>> birthdayCount(ArrayList<Integer> birthdays,
            List<ArrayList<Integer>> ranges) {

        List<Pair<List<Integer>, Integer>> result = new ArrayList<Pair<List<Integer>, Integer>>();

        for (List<Integer> range : ranges) {
            result.add(new Pair<List<Integer>, Integer>(range, countInRange(birthdays, range)));
        }

        return result;
    }

    public static int countInRange(List<Integer> birthdays, List<Integer> range) {

        int upperBound = binarySearch(birthdays, range.get(1) + 1);
        int lowerBound = binarySearch(birthdays, range.get(0));

        return upperBound - lowerBound + 1;
    }

    /**
     * @return the lowest index where the number is found or the index where
     *         should be placed but the number doesn't exist
     */
    private static int binarySearch(List<Integer> birthdays, int number) {

        int low = 0;
        int high = birthdays.size() - 1;

        int searchedIndex = -1;

        while (low < high) {

            int middle = low + (high - low) / 2;

            if (birthdays.get(middle) < number) {
                low = middle + 1;
            } else if (birthdays.get(middle) > number) {
                high = middle - 1;
            } else if (birthdays.get(middle) == number) {
                searchedIndex = middle;
                high = middle - 1;
            }
        }

        if (searchedIndex == -1) {
            return low;
        }

        return searchedIndex;
    }
}