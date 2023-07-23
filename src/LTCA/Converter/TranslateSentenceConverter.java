package LTCA.App.Converter;

public class TranslateSentenceConverter extends AbstractConverter {
    private static TranslateSentenceConverter SINGLETON = null;
    public final static String SUB_STRING = "$";
    public final static boolean IN_END = false;

    private TranslateSentenceConverter () {
        super(SUB_STRING, IN_END);
    }

    public static TranslateSentenceConverter getSingleton() {
        if (SINGLETON == null) SINGLETON = new TranslateSentenceConverter();
        return SINGLETON;
    }
}
