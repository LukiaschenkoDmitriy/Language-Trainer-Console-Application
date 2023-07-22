package LTCA.Entity;

import LTCA.Exception.IsNotCommentException;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Converter.CommentConverter;

public class Comment extends Component {
    private String comment;

    public Comment(int lineNumber, String content) {
        super(lineNumber, CommentConverter.getSingleton());
        this.content = content.trim();

        checkOnException(this.content, "content", "constructor");

        this.comment = this.converter.getWithoutSubString(this.content).trim();
    }

    public String getComment() {
        return this.comment;
    }

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        IsNotExceptionInfo info = new IsNotExceptionInfo(nameArgument, "comment", nameOperation, content);
        try {
            if (this.converter.validate(content)) return;
            throw new IsNotCommentException(info);
        } catch (IsNotCommentException e) {
            throw new RuntimeException(e);
        }
    }
}
