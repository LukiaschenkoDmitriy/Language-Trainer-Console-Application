package LTCA.App.Exception;

import LTCA.App.Converter.TranslateSentenceConverter;

public class IsNotTranslateSentenceException extends AbstractIsNotException {
    private static String MESSAGE = "is not translate sentence";
    private static String SUB_STRING = TranslateSentenceConverter.SUB_STRING;
    private static String COMPONENT_NAME = "TranslateSentence";
    private static boolean IN_END = TranslateSentenceConverter.IN_END;
    public IsNotTranslateSentenceException(IsNotExceptionInfo info) {
        super(info, MESSAGE, COMPONENT_NAME, SUB_STRING, IN_END);
    }
}
