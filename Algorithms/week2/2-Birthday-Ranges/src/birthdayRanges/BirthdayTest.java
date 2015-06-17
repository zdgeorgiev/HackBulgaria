package birthdayRanges;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

import org.junit.Test;

public class BirthdayTest {

    private ArrayList<Integer> birthdays = new ArrayList<Integer>();

    @Test
    public void testCountSubRange() {

        this.birthdays.add(10);
        this.birthdays.add(9);
        this.birthdays.add(8);
        this.birthdays.add(6);
        this.birthdays.add(8);

        CountSort.sort(this.birthdays);
        int count = BirthdayUtils.countInRange(this.birthdays, Arrays.asList(7, 10));

        assertTrue(count == 4);
    }

    @Test
    public void testCountSubRange2() {

        this.birthdays.add(1);
        this.birthdays.add(2);
        this.birthdays.add(2);
        this.birthdays.add(2);
        this.birthdays.add(3);
        this.birthdays.add(4);
        this.birthdays.add(5);
        this.birthdays.add(6);
        this.birthdays.add(6);
        this.birthdays.add(7);
        this.birthdays.add(8);
        this.birthdays.add(9);

        CountSort.sort(this.birthdays);
        int count = BirthdayUtils.countInRange(this.birthdays, Arrays.asList(2, 5));

        assertTrue(count == 7);
    }

    @Test
    public void testCountFullRange() {

        this.birthdays.add(8);
        this.birthdays.add(9);
        this.birthdays.add(8);
        this.birthdays.add(15);
        this.birthdays.add(8);

        CountSort.sort(this.birthdays);
        int count = BirthdayUtils.countInRange(this.birthdays, Arrays.asList(0, 365));

        assertTrue(count == this.birthdays.size());
    }

    @Test
    public void testCountMultipleRange() {

        for (int i = 0; i < 366; i++) {
            this.birthdays.add(i);
        }

        CountSort.sort(this.birthdays);

        List<ArrayList<Integer>> ranges = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> firstRange = new ArrayList<Integer>();
        firstRange.add(0);
        firstRange.add(182);

        ArrayList<Integer> secondRange = new ArrayList<Integer>();
        secondRange.add(183);
        secondRange.add(365);

        ranges.add(firstRange);
        ranges.add(secondRange);

        List<Pair<List<Integer>, Integer>> res = BirthdayUtils.birthdayCount(this.birthdays, ranges);

        assertTrue(res.get(0).getValue() == 184 && res.get(1).getValue() == 183);
    }
}