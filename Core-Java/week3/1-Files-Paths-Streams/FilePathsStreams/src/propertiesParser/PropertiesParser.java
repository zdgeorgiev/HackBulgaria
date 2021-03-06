package propertiesParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import readAndWriteUtils.FileUtils;

public class PropertiesParser {

    public PropertiesParser() {

    }

    public Map<String, String> parseProperties(File file) throws IOException {
        ArrayList<String> prop = new ArrayList<String>();

        FileUtils f = FileUtils.getInstance();
        String[] allLines = f.readFrom(file).split(System.lineSeparator());

        for (String line : allLines) {
            prop.add(line);
        }

        return this.parseProperties(prop);
    }

    public Map<String, String> parseProperties(ArrayList<String> props) {
        Map<String, String> map = new HashMap<String, String>();

        for (String str : props) {
            String trimmedCpy = str.trim();

            if (trimmedCpy.charAt(0) == '#') {
                continue;
            }

            int equalSignIndex = trimmedCpy.indexOf("=");
            String key = trimmedCpy.substring(0, equalSignIndex).trim();
            String value = trimmedCpy.substring(equalSignIndex + 1).trim();
            map.put(key, value);
        }

        return map;
    }
}
