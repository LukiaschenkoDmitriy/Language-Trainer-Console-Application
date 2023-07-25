package LTCA.Exception;

public class FileFormatException extends Exception {
    private static final String FORMAT_MESSAGE = "The expected file format is \"%s\", your file is \"%s\"";
    public FileFormatException(String actualFormat, String exceptedFormat) {
        super(String.format(FORMAT_MESSAGE, exceptedFormat, actualFormat));
    }
}
