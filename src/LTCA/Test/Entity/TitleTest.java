package LTCA.Test.Entity;

import LTCA.Entity.Title;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotTitleException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Title Test")
class TitleTest {

    @DisplayName("Exception test")
    @ParameterizedTest(name = "Title width argument \"{0}\"")
    @ValueSource(strings = {"hello world", "#hello world", "!hello world", "$hello world", "h#ello world", "@hello world", "//hello world"})
    void checkOnException(String content) {
        Title rightHardSentence = new Title(1, "*hello world");
        IsNotExceptionInfo info = rightHardSentence.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new Title(1, content);
        }, (new IsNotTitleException(info)).getMessage());
    }
}