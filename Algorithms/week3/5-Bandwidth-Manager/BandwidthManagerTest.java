import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BandwidthManagerTest {

    private BandwidthManager manager;

    @Before
    public void init() {
        this.manager = new BandwidthManager();
    }

    @Test
    public void test() {
        ArrayList<String> actual = new ArrayList<String>();
        this.manager.rcv("UDP", "zxchzrkljhklzrjlkhklzr", 0);
        this.manager.rcv("TCP", "ghljkajklhgjklare", 1);
        this.manager.rcv("ICMP", "ping87.129.54.123", 2);
        // actual.add(this.manager.send());
        // actual.add(this.manager.send());
        this.manager.rcv("DNS", "maps.google.com", 3);
        // actual.add(this.manager.send());
        this.manager.rcv("TCP", "aejkgjkaegaegae", 4);
        // actual.add(this.manager.send());
        // actual.add(this.manager.send());
        // actual.add(this.manager.send());

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("ping87.129.54.123");
        expected.add("zxchzrkljhklzrjlkhklzr");
        expected.add("maps.google.com");
        expected.add("ghljkajklhgjklare");
        expected.add("aejkgjkaegaegae");
        expected.add("Nothing to send!");

        System.out.println(actual);

        assertTrue(areEqual(actual, expected));
    }

    private boolean areEqual(ArrayList<String> first, ArrayList<String> second) {

        if (first.size() != second.size()) {
            return false;
        }

        for (int i = 0; i < first.size(); i++) {
            if (!first.get(i).equals(second.get(i))) {
                return false;
            }
        }

        return true;
    }
}