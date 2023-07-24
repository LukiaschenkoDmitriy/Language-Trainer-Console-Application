package LTCA.Test.Entity;

import LTCA.Converter.WordConverter;
import LTCA.Entity.TranslateSentence;
import LTCA.Entity.Word;
import LTCA.Exception.HaventSeparateSymbolException;
import LTCA.Exception.IsNotExceptionInfo;
import LTCA.Exception.IsNotTranslateSentenceException;
import LTCA.Exception.IsNotWordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Word Test")
class WordTest {

    @DisplayName("IsNotWordException test")
    @ParameterizedTest(name = "Word width argument \"{0}\"")
    @ValueSource(strings = {"hello world", "#hello world", "*hello world", "!hello world", "h#ello world", "@hello world", "$hello world"})
    void checkOnException1(String content) {
        Word rightWord = new Word(1, "//hello world - world");
        IsNotExceptionInfo info = rightWord.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new Word(1, content);
        }, (new IsNotWordException(info)).getMessage());
    }

    @DisplayName("HaventSeparateSymbolException test")
    @ParameterizedTest(name = "Word width argument \"{0}\"")
    @ValueSource(strings = {"// hello ", "//#$ hello world", "// hello # world", "// hello _ world", "// hello "})
    void checkOnException2(String content) {
        Word rightWord = new Word(1, "//hello world - world");
        IsNotExceptionInfo info = rightWord.getIsNotExceptionInfo(content, "content", "constructor");

        assertThrows(RuntimeException.class, () -> {
            new Word(1, content);
        }, (new HaventSeparateSymbolException(content, WordConverter.SUB_STRING).getMessage()));
    }
}
