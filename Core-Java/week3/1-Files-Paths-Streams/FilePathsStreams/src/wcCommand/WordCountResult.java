package wcCommand;

public class WordCountResult {
    private int linesCount;
    private int wordsCount;
    private int charsCount;

    public WordCountResult(int linesCount, int wordsCount, int charsCount) {
        this.setLinesCount(linesCount);
        this.setWordsCount(wordsCount);
        this.setCharsCount(charsCount);
    }

    public int getLinesCount() {
        return linesCount;
    }

    public void setLinesCount(int linesCount) {
        this.linesCount = linesCount;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getCharsCount() {
        return charsCount;
    }

    public void setCharsCount(int charsCount) {
        this.charsCount = charsCount;
    }
}