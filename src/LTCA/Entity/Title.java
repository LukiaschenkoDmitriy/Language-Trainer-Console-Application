package LTCA.Entity;

import LTCA.Converter.TitleConverter;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotTitleException;

public class Title extends Component{
    private String title;
    public Title(int lineNumber, String content) {
        super(lineNumber, TitleConverter.getSingleton());
        this.content = content.trim();

        checkOnException(content, "content", "constructor");

        this.title = this.converter.getWithoutSubString(this.content).trim();
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        IsNotExceptionInfo info = new IsNotExceptionInfo(nameArgument, "title", nameOperation, content);
        try {
            if (!this.converter.validate(content))
                throw new IsNotTitleException(info);
        } catch (IsNotTitleException e) {
            throw new RuntimeException(e);
        }
    }
}
