package LTCA.App.Exception;

public class IsNotExceptionInfo {
    public String nameClass;
    public String nameOperation;
    public String nameArgument;
    public String content;

    public IsNotExceptionInfo(String nameArgument, String nameClass, String nameOperation, String content) {
        this.nameArgument = nameArgument;
        this.nameOperation = nameOperation;
        this.content = content;
        this.nameClass = nameClass;
    }
}
