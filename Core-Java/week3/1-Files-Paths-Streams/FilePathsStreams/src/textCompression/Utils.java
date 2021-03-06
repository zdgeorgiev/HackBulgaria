package textCompression;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import readAndWriteUtils.FileUtils;

public class Utils {

    public static void compressFile(Path source, Path destination) throws IOException {
        if (!destination.toFile().exists()) {
            destination.toFile().createNewFile();
        }

        String sourceContent = FileUtils.getInstance().readFrom(source);

        // Contains all the words stored in word:index pair for easier search
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        int wordIndex = 0;
        int symbolIndex = 1;

        Pattern p = Pattern.compile("\\w+");
        Matcher words = p.matcher(sourceContent);
        // Storing all of the spaces or .,? etc symbols
        String[] betweenWords = sourceContent.split("\\w+");
        StringBuilder destContent = new StringBuilder();

        while (words.find()) {
            String currentWord = sourceContent.substring(words.start(), words.end());

            if (!map.containsKey(currentWord)) {
                map.put(currentWord, wordIndex);
                destContent.append("~" + (wordIndex++));
            } else {
                destContent.append("~" + map.get(currentWord));
            }

            // Add the symbol after the word
            destContent.append(betweenWords[symbolIndex++]);
        }

        StringBuilder wordsLegend = new StringBuilder();
        int wordCount = 1;

        // Add the hash map legend before the compressed text
        for (Entry<String, Integer> entry : map.entrySet()) {
            wordsLegend.append(entry.getKey());

            if (wordCount++ < map.size()) {
                wordsLegend.append(",");
            }
        }

        // Delimiter delegates the end of the hash map
        wordsLegend.append("|");

        FileUtils.getInstance().writeTo(destination, wordsLegend.append(destContent).toString());
    }

    public static void decompressFile(Path source, Path destination) throws IOException {
        if (!destination.toFile().exists()) {
            destination.toFile().createNewFile();
        }

        String sourceContent = FileUtils.getInstance().readFrom(source);

        // Split the legend and the compressed part
        String legend = sourceContent.substring(0, sourceContent.indexOf('|'));
        String compressedPart = sourceContent.substring(sourceContent.indexOf('|') + 1);

        LinkedHashMap<Integer, String> words = new LinkedHashMap<Integer, String>();
        String[] legendWords = legend.split(",");

        for (int i = 0; i < legendWords.length; i++) {
            words.put(i, legendWords[i]);
        }

        String[] betweenWords = compressedPart.split("~[0-9]+");
        Pattern p = Pattern.compile("~[0-9]+");

        Matcher m = p.matcher(compressedPart.toString());

        int betweenWordsIndex = 0;

        if (betweenWords[0].compareTo("") == 0) {
            betweenWordsIndex++;
        }

        StringBuilder decompressed = new StringBuilder();

        while (m.find()) {
            // Don't count the symbol ~ in the begging
            String index = compressedPart.substring(m.start() + 1, m.end());

            decompressed.append(words.get(Integer.parseInt(index)));
            decompressed.append(betweenWords[betweenWordsIndex++]);
        }

        FileUtils.getInstance().writeTo(destination, decompressed.toString());
    }
}