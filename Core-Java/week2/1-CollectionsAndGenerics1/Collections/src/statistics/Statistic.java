package statistics;

import java.util.HashSet;

public interface Statistic {
    float getMean();

    float getMedian();

    HashSet<Integer> getMode();

    int getRange();
}