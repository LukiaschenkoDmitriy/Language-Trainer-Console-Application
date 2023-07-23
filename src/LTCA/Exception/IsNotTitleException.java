package LTCA.App.Exception;

import LTCA.App.Converter.CommentConverter;
import LTCA.App.Converter.TitleConverter;

public class IsNotTitleException extends AbstractIsNotException {
    private static String MESSAGE = "is not title";
    private static String SUB_STRING = TitleConverter.SUB_STRING;
    private static String COMPONENT_NAME = "title";
    private static boolean IN_END = CommentConverter.IN_END;
    public IsNotTitleException(IsNotExceptionInfo info) {
        super(info, MESSAGE, COMPONENT_NAME, SUB_STRING, IN_END);
    }
}
