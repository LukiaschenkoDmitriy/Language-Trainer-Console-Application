package LTCA.App.Converter;

public class HardSentenceConverter extends AbstractConverter {
    private static HardSentenceConverter SINGLETON = null;
    public final static String SUB_STRING = "!";
    public final static boolean IN_END = false;
    private HardSentenceConverter() {
        super(SUB_STRING, IN_END);
    }
    public static HardSentenceConverter getSingleton() {
        if (SINGLETON == null) SINGLETON = new HardSentenceConverter();
        return SINGLETON;
    }
}
