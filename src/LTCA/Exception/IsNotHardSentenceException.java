package LTCA.App.Exception;

import LTCA.App.Converter.HardSentenceConverter;

public class IsNotHardSentenceException extends AbstractIsNotException {
    private static String MESSAGE = "is not hard sentence";
    private static String SUB_STRING = HardSentenceConverter.SUB_STRING;
    private static String COMPONENT_NAME = "hard sentence";
    private static boolean IN_END = HardSentenceConverter.IN_END;
    public IsNotHardSentenceException(IsNotExceptionInfo info) {
        super(info, MESSAGE, COMPONENT_NAME, SUB_STRING, IN_END);
    }
}
