package LTCA.App.Entity;

import LTCA.App.Converter.HardSentenceConverter;
import LTCA.App.Exception.IsNotExceptionInfo;
import LTCA.App.Exception.IsNotHardSentenceException;

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
        IsNotExceptionInfo info = new IsNotExceptionInfo(nameArgument, "hardSentence", nameOperation, content);
        try {
            if (!this.converter.validate(content))
                throw new IsNotHardSentenceException(info);
        } catch (IsNotHardSentenceException e) {
            throw new RuntimeException(e);
        }
    }
}
