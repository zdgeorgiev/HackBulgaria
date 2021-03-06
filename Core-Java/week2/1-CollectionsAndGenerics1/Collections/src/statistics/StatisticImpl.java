package statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class StatisticImpl implements Statistic {
    private ArrayList<Integer> arr;

    public StatisticImpl() {
        this.arr = new ArrayList<Integer>();
    }

    public void addNumber(int number) {
        this.arr.add(number);
    }

    public float getMean() {
        float mean = 0;

        for (Integer i : this.arr) {
            mean += i;
        }

        return mean / this.arr.size();
    }

    public float getMedian() {
        Collections.sort(this.arr);
        int rightNumberIndex = this.arr.size() / 2;
        int leftNumberIndex = this.arr.size() / 2 - 1;

        boolean isEven = false;
        if ((this.arr.size() & 1) == 0) {
            isEven = true;
        }

        float median = 0;
        int index = 0;
        for (Integer i : this.arr) {
            if (index == leftNumberIndex && isEven) {
                median += i;
            } else if (index == rightNumberIndex) {
                median += i;
            }

            index++;
        }

        if (isEven) {
            return median / 2;
        }

        return median;
    }

    public HashSet<Integer> getMode() {
        HashSet<Integer> modes = new HashSet<Integer>();
        Collections.sort(this.arr);

        int currentCount = 1;
        int maxCount = Integer.MIN_VALUE;
        int previousNumber = Integer.MAX_VALUE;
        int index = 0;

        for (Integer i : this.arr) {
            if (i == previousNumber) {
                currentCount++;
            } else {
                if (index == 0) {
                    previousNumber = i;
                    index++;
                    continue;
                }

                if (maxCount < currentCount) {
                    maxCount = currentCount;
                    currentCount = 1;
                    modes.add(previousNumber);
                } else if (maxCount == currentCount) {
                    modes.add(previousNumber);
                }

                previousNumber = i;
            }

            index++;
        }

        return modes;
    }

    public int getRange() {
        int minNumber = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (Integer i : this.arr) {
            if (i > maxValue) {
                maxValue = i;
            }
            if (i < minNumber) {
                minNumber = i;
            }
        }

        return maxValue - minNumber;
    }
}