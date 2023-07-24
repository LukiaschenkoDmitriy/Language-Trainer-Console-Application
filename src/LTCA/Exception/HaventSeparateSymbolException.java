package LTCA.Exception;

public class HaventSeparateSymbolException extends Exception {
    public HaventSeparateSymbolException(String content, String expectedSeparate) {
        super(String.format("The content \"%s\" haven't \"%s\" separate", content, expectedSeparate));
    }
}
