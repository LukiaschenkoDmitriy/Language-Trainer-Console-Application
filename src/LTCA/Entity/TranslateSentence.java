package LTCA.App.Entity;

import LTCA.App.Converter.TranslateSentenceConverter;
import LTCA.App.Exception.IsNotExceptionInfo;
import LTCA.App.Exception.IsNotTranslateSentenceException;

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
        IsNotExceptionInfo info = new IsNotExceptionInfo(nameArgument, "translateSentence", nameOperation, content);
        try {
            if (!this.converter.validate(content))
                throw new IsNotTranslateSentenceException(info);
        } catch (IsNotTranslateSentenceException e) {
            throw new RuntimeException(e);
        }
    }
}
