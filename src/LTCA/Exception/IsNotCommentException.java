package LTCA.Exception;

import LTCA.Converter.CommentConverter;

public class IsNotCommentException extends AbstractIsNotException {
    private static String MESSAGE = "is not comment";
    private static String SUB_STRING = CommentConverter.SUB_STRING;
    private static String COMPONENT_NAME = "comment";
    private static boolean IN_END = CommentConverter.IN_END;
    public IsNotCommentException(IsNotExceptionInfo info) {
        super(info, MESSAGE, COMPONENT_NAME, SUB_STRING, IN_END);
    }
}
