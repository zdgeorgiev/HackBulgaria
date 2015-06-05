package brackets;

public class BracketsHolder {
    public boolean isRoundBracketAvaible;
    public boolean isSquareBracketAvaible;
    public boolean isCurlyBracketAvaible;

    public int roundBracketsCount = 0;
    public int squareBracketsCount = 0;
    public int curlyBracketsCount = 0;

    public BracketsHolder(boolean roundBracketAvailable, boolean squareBracketAvailabel, boolean curclyBracketAvailable) {
        this.isRoundBracketAvaible = roundBracketAvailable;
        this.isSquareBracketAvaible = squareBracketAvailabel;
        this.isCurlyBracketAvaible = curclyBracketAvailable;
    }

    public boolean isClean() {
        return this.squareBracketsCount == 0 && this.roundBracketsCount == 0 && this.curlyBracketsCount == 0;
    }
}
