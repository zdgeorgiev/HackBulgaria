package propertiesParser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class PropertiesParserTest {
    private PropertiesParser p;

    @Before
    public void init() {
        p = new PropertiesParser();
    }

    @Test
    public void testExample() {
        ArrayList<String> prop = new ArrayList<String>();

        prop.add("#this is comment");
        prop.add("a1=b1");
        prop.add("a2 =b2");
        prop.add("a3    =    b3");
        prop.add("   a4 = b4");
        prop.add("a5=b6=b7=b8");
        prop.add("a6=b9 #comment");
        prop.add("a7==b10");

        Map<String, String> actual = p.parseProperties(prop);
        Map<String, String> expected = new HashMap<String, String>();

        expected.put("a1", "b1");
        expected.put("a2", "b2");
        expected.put("a3", "b3");
        expected.put("a4", "b4");
        expected.put("a5", "b6=b7=b8");
        expected.put("a6", "b9 #comment");
        expected.put("a7", "=b10");

        assertEquals(areEqual(actual, expected), true);
    }

    @Test
    public void readFromFile() {
        Map<String, String> actual = null;

        try {
            actual = p.parseProperties(new File("../testData/testData/p.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Map<String, String> expected = new HashMap<String, String>();

        expected.put("a1", "b1");
        expected.put("a2", "b2");
        expected.put("a3", "b3");
        expected.put("a4", "b4");
        expected.put("a5", "b6=b7=b8");
        expected.put("a6", "b9 #comment");
        expected.put("a7", "=b10");

        assertEquals(areEqual(actual, expected), true);
    }

    private boolean areEqual(Map<String, String> first, Map<String, String> second) {

        for (Entry<String, String> entry : second.entrySet()) {
            if (!first.containsKey(entry.getKey())) {
                return false;
            } else {
                if (!first.get(entry.getKey()).equals(entry.getValue())) {
                    return false;
                }
            }
        }

        return true;
    }
}
