package LTCA.Entity;

import LTCA.Converter.AbstractConverter;

public class Sentence extends Component {
    private String sentence;

    public Sentence(int lineNumber, String content) {
        super(lineNumber, new AbstractConverter("", false) {});
        this.content = content.trim();
        this.sentence = this.content;
    }

    public String getSentence() {
        return this.sentence;
    }

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        return;
    }
}
