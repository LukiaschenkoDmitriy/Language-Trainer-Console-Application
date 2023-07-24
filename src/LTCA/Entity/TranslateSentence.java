package LTCA.Entity;

import LTCA.Converter.TranslateSentenceConverter;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotTranslateSentenceException;

public class TranslateSentence extends Component {
    private String translate;
    public TranslateSentence(int lineNumber, String content) {
        super(lineNumber, TranslateSentenceConverter.getSingleton());
        this.content = content.trim();

        checkOnException(this.content, "content", "constructor");

        this.translate = this.converter.getWithoutSubString(this.content).trim();
    }

    public String getTranslate() {
        return this.translate;
    }

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        IsNotExceptionInfo info = this.getIsNotExceptionInfo(content, nameArgument, nameOperation);
        try {
            if (!this.converter.validate(content))
                throw new IsNotTranslateSentenceException(info);
        } catch (IsNotTranslateSentenceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IsNotExceptionInfo getIsNotExceptionInfo(String content, String nameArgument, String nameOperation) {
        return new IsNotExceptionInfo(nameArgument, "translateSentence", nameOperation, content);
    }
}
