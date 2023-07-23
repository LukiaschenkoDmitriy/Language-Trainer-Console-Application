package LTCA.App.Exception;

import LTCA.App.Converter.CommentConverter;
import LTCA.App.Converter.WordConverter;

public class IsNotWordException extends AbstractIsNotException {
    private static String MESSAGE = "is not word";
    private static String SUB_STRING = WordConverter.SUB_STRING;
    private static String COMPONENT_NAME = "word";
    private static boolean IN_END = CommentConverter.IN_END;
    public IsNotWordException(IsNotExceptionInfo info) {
        super(info, MESSAGE, COMPONENT_NAME, SUB_STRING, IN_END);
    }
}
