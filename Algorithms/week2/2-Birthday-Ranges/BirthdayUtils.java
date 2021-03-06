import java.util.ArrayList;
import java.util.List;

public class BirthdayUtils {

    public static List<Integer> birthdayCount(List<Integer> birthdays, List<BirthdayRanges.Pair> ranges) {

        CountSort.sort(birthdays);
        List<Integer> result = new ArrayList<Integer>();

        for (BirthdayRanges.Pair range : ranges) {
            result.add(countInRange(birthdays, range));
        }

        return result;
    }

    public static int countInRange(List<Integer> birthdays, BirthdayRanges.Pair range) {

        int upperBound = binarySearch(birthdays, range.end + 1);
        int lowerBound = binarySearch(birthdays, range.start);

        return upperBound - lowerBound;
    }

    /**
     * @return the lowest index where the number is found or the index where
     *         should be placed but the number doesn't exist
     */
    private static int binarySearch(List<Integer> birthdays, int number) {

        int low = 0;
        int high = birthdays.size() - 1;

        int searchedIndex = -1;

        while (low <= high) {

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