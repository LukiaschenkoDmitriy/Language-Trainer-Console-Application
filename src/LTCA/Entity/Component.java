package LTCA.Entity;

import LTCA.Converter.AbstractConverter;

public abstract class Component {
    protected AbstractConverter converter;
    protected String content;
    protected int lineNumber;

    public Component(int lineNumber, AbstractConverter converter) {
        this.converter = converter;
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }
    public String getContent() {
        return this.content;
    }

    public AbstractConverter getConverter() {
        return this.converter;
    }

    public abstract void checkOnException(String content, String nameArgument, String nameOperation);
}
