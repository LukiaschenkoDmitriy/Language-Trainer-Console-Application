package LTCA.App.Converter;

public class TitleConverter extends AbstractConverter {
    private static TitleConverter SINGLETON = null;
    public final static String SUB_STRING = "*";
    public final static boolean IN_END = false;

    private TitleConverter() {
        super(SUB_STRING, IN_END);
    }

    public static TitleConverter getSingleton() {
        if (SINGLETON == null) SINGLETON = new TitleConverter();
        return SINGLETON;
    }
}
