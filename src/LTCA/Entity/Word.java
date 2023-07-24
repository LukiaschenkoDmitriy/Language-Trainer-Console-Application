package LTCA.Entity;

import LTCA.Converter.WordConverter;
import LTCA.Exception.HaventSeparateSymbolException;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotWordException;

public class Word extends Component {
    private static String SPLIT_SYMBOL = "-";
    private String word;
    private String translateWord;

    public Word(int lineNumber, String content) {
        super(lineNumber, WordConverter.getSingleton());

        checkOnException(content, "content", "constructor");

        this.content = content.trim();
        String[] splitContent = this.converter.splitOnSymbol(this.converter.getWithoutSubString(content), SPLIT_SYMBOL);

        this.word = splitContent[0].trim();
        this.translateWord = splitContent[1].trim();
    }

    public String getWord() {
        return this.word;
    }

    public String getTranslateWord() {
        return this.translateWord;
    }

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        IsNotExceptionInfo info = this.getIsNotExceptionInfo(content, nameArgument, nameOperation);
        try {
            if (!this.converter.validate(content))
                throw new IsNotWordException(info);
            if (!this.converter.contentContainsSubString(content, SPLIT_SYMBOL))
                throw new HaventSeparateSymbolException(content, SPLIT_SYMBOL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IsNotExceptionInfo getIsNotExceptionInfo(String content, String nameArgument, String nameOperation) {
        return new IsNotExceptionInfo(nameArgument, "word", nameOperation, content);
    }
}
