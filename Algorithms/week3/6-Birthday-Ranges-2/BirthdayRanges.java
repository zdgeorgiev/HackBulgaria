import java.util.ArrayList;

public class BirthdayRanges {

    private BinaryIndexedTree data;

    public BirthdayRanges(ArrayList<Integer> birthdays, int totalLeafs) {

        ArrayList<Integer> birthdaysHistogram = new ArrayList<Integer>();
        CountSort.getHistogram(birthdays);

        for (int i = 0; i < totalLeafs; i++) {
            birthdaysHistogram.add(CountSort.numbers[i]);
        }

        this.data = new BinaryIndexedTree(birthdaysHistogram, totalLeafs);
    }

    // adds people who are born on a specific day
    public void add(int day, int numberOfPeople) {
        this.data.add(day, numberOfPeople);
    }

    // removes people who are born on a specific day
    public void remove(int day, int numberOfPeople) {
        this.data.remove(day, numberOfPeople);
    }

    // returns the number of people born in a range
    public int count(int startDay, int endDay) {
        return this.data.count(endDay) - this.data.count(startDay - 1);
    }
}
