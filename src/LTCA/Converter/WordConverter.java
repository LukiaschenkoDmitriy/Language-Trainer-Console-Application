package LTCA.Converter;

public class WordConverter extends AbstractConverter{

    private static WordConverter SINGLETON = null;
    public final static String SUB_STRING = "//";
    public final static boolean IN_END = false;

    private WordConverter() {
        super(SUB_STRING, IN_END);
    }

    public static WordConverter getSingleton() {
        if (SINGLETON == null) SINGLETON = new WordConverter();
        return SINGLETON;
    }
}
