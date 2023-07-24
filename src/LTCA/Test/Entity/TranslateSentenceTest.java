package LTCA.Test.Entity;

import LTCA.Entity.TranslateSentence;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotTranslateSentenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TranslateSentence Test")
class TranslateSentenceTest {

    @DisplayName("Exception test")
    @ParameterizedTest(name = "TranslateSentence width argument \"{0}\"")
    @ValueSource(strings = {"hello world", "#hello world", "*hello world", "!hello world", "h#ello world", "@hello world", "//hello world"})
    void checkOnException(String content) {
        TranslateSentence rightTranslateSentence = new TranslateSentence(1, "$hello world");
        IsNotExceptionInfo info = rightTranslateSentence.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new TranslateSentence(1, content);
        }, (new IsNotTranslateSentenceException(info)).getMessage());
    }
}