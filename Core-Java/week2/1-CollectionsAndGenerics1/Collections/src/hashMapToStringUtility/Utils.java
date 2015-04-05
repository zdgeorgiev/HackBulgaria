package hashMapToStringUtility;

import java.util.HashMap;

public class Utils {
    public static String MapToString(HashMap<? extends Object, ? extends Object> map) {
        StringBuilder output = new StringBuilder();

        output.append("{ ");

        for (java.util.Map.Entry<? extends Object, ? extends Object> item : map.entrySet()) {
            output.append(item.getKey() + ":" + item.getValue() + " ");
        }
        output.append("}");

        return output.toString();
    }
}