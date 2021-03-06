import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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

        BirthdayRanges.Pair range = new BirthdayRanges.Pair();
        range.start = 7;
        range.end = 10;

        int count = BirthdayUtils.countInRange(this.birthdays, range);

        assertTrue(count == 4);
    }

    @Test
    public void testCountSubRange2() {

        this.birthdays.add(1);
        this.birthdays.add(2);
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

        BirthdayRanges.Pair range = new BirthdayRanges.Pair();
        range.start = 2;
        range.end = 5;

        int count = BirthdayUtils.countInRange(this.birthdays, range);

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

        BirthdayRanges.Pair range = new BirthdayRanges.Pair();
        range.start = 0;
        range.end = 365;

        int count = BirthdayUtils.countInRange(this.birthdays, range);

        assertTrue(count == this.birthdays.size());
    }

    @Test
    public void testCountMultipleRange() {

        for (int i = 0; i < 366; i++) {
            this.birthdays.add(i);
        }

        List<BirthdayRanges.Pair> ranges = new ArrayList<>();

        BirthdayRanges.Pair firstRange = new BirthdayRanges.Pair();
        firstRange.start = 0;
        firstRange.end = 182;

        BirthdayRanges.Pair secondRange = new BirthdayRanges.Pair();
        secondRange.start = 183;
        secondRange.end = 365;

        ranges.add(firstRange);
        ranges.add(secondRange);

        List<Integer> res = BirthdayUtils.birthdayCount(this.birthdays, ranges);

        assertTrue(res.get(0) == 183 && res.get(1) == 183);
    }

    @Test
    public void testAnotherCase() {

        this.birthdays.add(5);
        this.birthdays.add(10);
        this.birthdays.add(6);
        this.birthdays.add(7);
        this.birthdays.add(3);
        this.birthdays.add(4);
        this.birthdays.add(5);
        this.birthdays.add(11);
        this.birthdays.add(21);
        this.birthdays.add(300);
        this.birthdays.add(15);

        List<BirthdayRanges.Pair> ranges = new ArrayList<BirthdayRanges.Pair>();

        BirthdayRanges.Pair firstRange = new BirthdayRanges.Pair();
        firstRange.start = 4;
        firstRange.end = 9;

        BirthdayRanges.Pair secondRange = new BirthdayRanges.Pair();
        secondRange.start = 6;
        secondRange.end = 7;

        BirthdayRanges.Pair thirdRange = new BirthdayRanges.Pair();
        thirdRange.start = 200;
        thirdRange.end = 225;

        BirthdayRanges.Pair fourthRange = new BirthdayRanges.Pair();
        fourthRange.start = 300;
        fourthRange.end = 365;

        ranges.add(firstRange);
        ranges.add(secondRange);
        ranges.add(thirdRange);
        ranges.add(fourthRange);

        List<Integer> res = BirthdayUtils.birthdayCount(this.birthdays, ranges);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(2);
        expected.add(0);
        expected.add(1);

        boolean isEqual = true;

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) != expected.get(i)) {
                isEqual = false;
                break;
            }
        }

        assertTrue(isEqual);
    }
}