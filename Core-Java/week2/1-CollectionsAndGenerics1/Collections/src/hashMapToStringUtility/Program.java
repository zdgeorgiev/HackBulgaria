package hashMapToStringUtility;

import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < 10; i++) {
            map.put("Pesho" + i, i);
        }

        System.out.println(Utils.MapToString(map));
    }
}