package LTCA.Entity;

import LTCA.Exception.IsNotCommentException;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Converter.CommentConverter;

public class Comment extends Component {
    private String comment;

    public Comment(int lineNumber, String content) {
        super(lineNumber, CommentConverter.getSingleton());
        this.content = content;

        checkOnException(content, "content", "constructor");

        this.comment = this.converter.getWithoutSubString(content);
    }

    public String getComment() {
        return this.comment;
    }

    @Override
    public void checkOnException(String content, String nameArgument, String nameOperation) {
        try {
            if (this.converter.validate(content)) return;
            IsNotExceptionInfo info = new IsNotExceptionInfo(nameArgument, "comment", nameOperation, content);
            throw new IsNotCommentException(info);
        } catch (IsNotCommentException e) {
            throw new RuntimeException(e);
        }
    }
}
