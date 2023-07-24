package LTCA.Test.Entity;

import LTCA.Entity.Comment;
import LTCA.Exception.IsNotCommentException;
import LTCA.Exception.IsNotExceptionInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Comment Test")
class CommentTest {
    @ParameterizedTest(name = "Comment with argument \"{0}\"")
    @DisplayName("Exception test")
    @ValueSource(strings = {"hello world", "!hello world", "*hello world", "$hello world", "h#ello world", "@hello world", "//hello world"})
    void checkOnException(String content) {
        Comment rightComment = new Comment(1, "#hello world");
        IsNotExceptionInfo info = rightComment.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new Comment(1, content);
        }, (new IsNotCommentException(info)).getMessage());
    }
}