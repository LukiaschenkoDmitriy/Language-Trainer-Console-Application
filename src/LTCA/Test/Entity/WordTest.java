package LTCA.Test.Entity;

import LTCA.Entity.TranslateSentence;
import LTCA.Entity.Word;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotTranslateSentenceException;
import LTCA.Exception.IsNotWordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Word Test")
class WordTest {

    @DisplayName("Exception test")
    @ParameterizedTest(name = "Word width argument \"{0}\"")
    @ValueSource(strings = {"hello world", "#hello world", "*hello world", "!hello world", "h#ello world", "@hello world", "$hello world"})
    void checkOnException(String content) {
        Word rightHardSentence = new Word(1, "//hello world");
        IsNotExceptionInfo info = rightHardSentence.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new Word(1, content);
        }, (new IsNotWordException(info)).getMessage());
    }
}