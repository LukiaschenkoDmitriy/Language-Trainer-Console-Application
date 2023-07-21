package LTCA.Converter;

public final class CommentConverter extends AbstractConverter {
    private static CommentConverter SINGLETON = null;
    public final static String SUB_STRING = "#";
    public final static boolean IN_END = false;

    private CommentConverter() {
        super(SUB_STRING, IN_END);
    }

    public static CommentConverter getSingleton() {
        if (SINGLETON == null) SINGLETON = new CommentConverter();
        return SINGLETON;
    }
}
