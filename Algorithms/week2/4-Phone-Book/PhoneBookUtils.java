import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBookUtils {

    public static List<String> lookupNames(ArrayList<PhoneBook.Contact> phoneBook, List<Integer> numbers) {

        phoneBook.sort(new Comparator<PhoneBook.Contact>() {
            @Override
            public int compare(PhoneBook.Contact first, PhoneBook.Contact second) {
                return new Integer(first.number).compareTo(second.number);

            }
        });

        List<String> result = new ArrayList<String>();

        for (Integer number : numbers) {

            String currentPersonName = binarySearch(phoneBook, number);
            result.add(currentPersonName);
        }

        return result;
    }

    private static String binarySearch(ArrayList<PhoneBook.Contact> phoneBook, Integer number) {

        int low = 0;
        int high = phoneBook.size() - 1;

        while (low <= high) {

            int middle = low + (high - low) / 2;
            int currentMiddleNumber = phoneBook.get(middle).number;

            if (currentMiddleNumber == number) {
                return phoneBook.get(middle).name;
            } else if (currentMiddleNumber > number) {
                high = middle - 1;
            } else if (currentMiddleNumber < number) {
                low = middle + 1;
            }
        }

        return "";
    }
}
