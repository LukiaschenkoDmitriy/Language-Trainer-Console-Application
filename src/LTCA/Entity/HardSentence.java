package LTCA.Entity;

import LTCA.Converter.HardSentenceConverter;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotHardSentenceException;

public class HardSentence extends Component {
    private String sentence;
    public HardSentence(int lineNumber, String content) {
        super(lineNumber, HardSentenceConverter.getSingleton());
        this.content = content.trim();

        checkOnException(this.content, "content", "constructor");

        this.sentence = this.converter.getWithoutSubString(this.content).trim();
    }

    public String getSentence() {return this.sentence;}

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        IsNotExceptionInfo info = getIsNotExceptionInfo(content, nameArgument, nameOperation);
        try {
            if (!this.converter.validate(content))
                throw new IsNotHardSentenceException(info);
        } catch (IsNotHardSentenceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IsNotExceptionInfo getIsNotExceptionInfo(String content, String nameArgument, String nameOperation) {
        return new IsNotExceptionInfo(nameArgument, "hardSentence", nameOperation, content);
    }
}
