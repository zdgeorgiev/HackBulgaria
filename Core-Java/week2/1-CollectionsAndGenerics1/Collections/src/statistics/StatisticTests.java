package statistics;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StatisticTests {
    private StatisticImpl s;

    @Before
    public void initialize() {
        s = new StatisticImpl();

        s.addNumber(13);
        s.addNumber(18);
        s.addNumber(13);
        s.addNumber(14);
        s.addNumber(13);
        s.addNumber(16);
        s.addNumber(14);
        s.addNumber(21);
        s.addNumber(13);
    }

    @Test
    public void testMean() {
        assertEquals(s.getMean(), 15, 0.1);
    }

    @Test
    public void testMedian() {
        assertEquals(s.getMedian(), 14, 0.1);
    }

    @Test
    public void testMode() {
        assertEquals(s.getMode().contains(13), true);
        assertEquals(s.getMode().size(), 1);
    }

    @Test
    public void testRange() {
        assertEquals(s.getRange(), 8, 0.1);
    }
}
