package wcCommand;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class WordCountTest {

    @Test
    public void test() {
        WordCountResult actual = null;

        try {
            actual = Utils.wordCount(new File("../testData/testData/p2.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(areEqual(actual, new WordCountResult(1, 3, 9)), true);
    }

    private boolean areEqual(WordCountResult actual, WordCountResult res) {
        if (actual.getCharsCount() != res.getCharsCount()) {
            return false;
        }

        if (actual.getLinesCount() != res.getLinesCount()) {
            return false;
        }

        if (actual.getWordsCount() != res.getWordsCount()) {
            return false;
        }

        return true;
    }
}
