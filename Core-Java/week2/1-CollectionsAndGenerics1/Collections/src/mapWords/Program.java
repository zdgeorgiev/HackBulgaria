package mapWords;

import java.util.LinkedHashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        String input = "Ninjas are all over the place! We are all going to die!";

        System.out.println(mapWords(input));
    }

    public static Map<String, Integer> mapWords(String input) {
        Map<String, Integer> wordsMap = new LinkedHashMap<String, Integer>();
        String[] words = input.split(" ");

        for (String s : words) {
            if (wordsMap.containsKey(s)) {
                wordsMap.replace(s, wordsMap.get(s), wordsMap.get(s) + 1);
            } else {
                wordsMap.put(s, 1);
            }
        }

        return wordsMap;
    }
}