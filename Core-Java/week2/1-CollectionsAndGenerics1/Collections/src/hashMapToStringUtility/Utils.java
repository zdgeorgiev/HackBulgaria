package hashMapToStringUtility;

import java.util.HashMap;
import java.util.Map.Entry;

public class Utils {
    public static String MapToString(HashMap<? extends Object, ? extends Object> map) {
        StringBuilder output = new StringBuilder();

        output.append("{ ");

        for (Entry<? extends Object, ? extends Object> entry : map.entrySet()) {
            output.append(entry.getKey() + ":" + entry.getValue() + " ");
        }

        output.append("}");

        return output.toString();
    }
}