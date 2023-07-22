package LTCA.Exception;

public abstract class AbstractIsNotException extends Exception {
    private static final String FORMAT_MESSAGE = "Argument \"%s\" in %s \"%s\" %s \n\"%s\" %s \n%s";
    private static final String FORMAT_HELP_MESSAGE = "The %s must have the \"%s\" character on the %s of the line";

    public AbstractIsNotException(
            IsNotExceptionInfo info,
            String message,
            String componentName,
            String componentSubString,
            boolean inEnd)
    {
        super(String.format(
                FORMAT_MESSAGE,
                info.nameArgument,
                info.nameOperation,
                info.nameClass,
                message,
                info.content,
                message,
                String.format(FORMAT_HELP_MESSAGE, componentName, componentSubString, inEnd ? "beginning" : "end3"))
        );
    }
}

