package LTCA.Test.Entity;

import LTCA.Entity.HardSentence;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotHardSentenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HardSentence Test")
class HardSentenceTest {

    @DisplayName("Exception test")
    @ParameterizedTest(name = "HardSentence width argument \"{0}\"")
    @ValueSource(strings = {"hello world", "#hello world", "*hello world", "$hello world", "h#ello world", "@hello world", "//hello world"})
    void checkOnException(String content) {
        HardSentence rightHardSentence = new HardSentence(1, "!hello world");
        IsNotExceptionInfo info = rightHardSentence.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new HardSentence(1, content);
        }, (new IsNotHardSentenceException(info)).getMessage());
    }
}