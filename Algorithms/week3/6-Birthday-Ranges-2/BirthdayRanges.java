import java.util.ArrayList;

public class BirthdayRanges {

    private BinaryIndexedTree data;
    private int[] birthday = new int[366];

    public BirthdayRanges(ArrayList<Integer> birthdays) {

        ArrayList<Integer> birthdaysHistogram = this.getHistogram(birthdays);
        this.data = new BinaryIndexedTree(birthdaysHistogram, this.birthday.length);
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

    private ArrayList<Integer> getHistogram(ArrayList<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            this.birthday[data.get(i)]++;
        }

        ArrayList<Integer> histogram = new ArrayList<Integer>();

        for (int i = 0; i < this.birthday.length; i++) {
            histogram.add(this.birthday[i]);
        }

        return histogram;
    }
}
