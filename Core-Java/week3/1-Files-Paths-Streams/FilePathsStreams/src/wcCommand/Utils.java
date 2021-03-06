package wcCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import readAndWriteUtils.FileUtils;

public class Utils {

    public static WordCountResult wordCount(Path path) throws IOException {
        return wordCount(new File(path.toString()));
    }

    public static WordCountResult wordCount(File file) throws IOException {
        int words = 0;
        int chars = 0;

        String text = FileUtils.getInstance().readFrom(file);
        String[] allLines = text.split(System.lineSeparator());

        for (String str : allLines) {
            chars += str.length();

            words += str.split(" ").length;
        }

        return new WordCountResult(allLines.length, words, chars);
    }
}