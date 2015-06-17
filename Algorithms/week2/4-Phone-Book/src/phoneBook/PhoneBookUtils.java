package phoneBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBookUtils {

    public static List<ArrayList<String>> lookupNames(ArrayList<Person> phoneBook, List<Integer> numbers) {

        phoneBook.sort(new Comparator<Person>() {
            @Override
            public int compare(Person first, Person second) {
                return first.getNumber().compareTo(second.getNumber());
            }
        });

        List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for (Integer number : numbers) {
            ArrayList<String> currentPerson = new ArrayList<String>();
            currentPerson.add(number.toString());

            String currentPersonNumber = binarySearch(phoneBook, number);
            currentPerson.add(currentPersonNumber.equals("") ? "Not exist" : currentPersonNumber);

            result.add(currentPerson);
        }

        return result;
    }

    private static String binarySearch(ArrayList<Person> phoneBook, Integer number) {

        int low = 0;
        int high = phoneBook.size() - 1;

        while (low <= high) {

            int middle = low + (high - low) / 2;
            int currentMiddleNumber = phoneBook.get(middle).getNumber();

            if (currentMiddleNumber == number) {
                return phoneBook.get(middle).getName();
            } else if (currentMiddleNumber > number) {
                high = middle - 1;
            } else if (currentMiddleNumber < number) {
                low = middle + 1;
            }
        }

        return "";
    }
}
