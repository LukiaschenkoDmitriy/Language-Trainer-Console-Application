package LTCA.Converter;

public abstract class AbstractConverter {
    private final String subString;
    private boolean inEnd = false;

    public AbstractConverter(String subString, boolean inEnd) {
        this(subString);
        this.inEnd = inEnd;
    }

    public AbstractConverter(String subString) {
        this.subString = subString;
    }
    public String getSubString() { return this.subString; }
    public boolean isInEnd() { return this.inEnd; }
    public boolean validate(String line) {
        line = line.trim();
        if (this.inEnd) return line.endsWith(this.subString);
        else return line.startsWith(this.subString);
    }

    public String getWithoutSubString(String line) {
        return line.replaceAll("["+subString+"]", "").trim();
    }

    public String getWithSubString(String content) {
        String replaceAll = this.getWithoutSubString(content);
        return subString.concat(" ").concat(replaceAll);
    }

    public String[] splitOnSymbol(String content, String symbol) {
        return content.split(symbol);
    }

    public boolean contentContainsSubString(String content, String subString) {
        return content.contains(subString);
    }
}
