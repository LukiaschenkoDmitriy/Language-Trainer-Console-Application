package LTCA.Test.Converter;

import org.junit.jupiter.api.Test;
import LTCA.Converter.TranslateSentenceConverter;
import static org.junit.jupiter.api.Assertions.*;

class TranslateSentenceConverterTest {
    private static final TranslateSentenceConverter cc = TranslateSentenceConverter.getSingleton();
    @Test
    void validate() {
        assertTrue(cc.validate("$ hello world"));
        assertTrue(cc.validate("$hello world"));
        assertTrue(cc.validate("$    hello world"));
        assertFalse(cc.validate("*hello world"));
        assertFalse(cc.validate("hello # world"));
        assertFalse(cc.validate("hello world #"));
    }

    @Test
    void getWithoutSubString() {
        assertEquals("hello world", cc.getWithoutSubString("$hello world"));
        assertEquals("hello world", cc.getWithoutSubString("$hello world"));
        assertEquals("hello world", cc.getWithoutSubString("hello world"));
        assertEquals("hello world", cc.getWithoutSubString("hello world $"));
        assertEquals("hello  world", cc.getWithoutSubString("hello $ world"));
    }

    @Test
    void getWithSubString() {
        assertEquals("$ hello world", cc.getWithSubString("hello world"));
        assertEquals("$ hello world", cc.getWithSubString("$ hello world"));
        assertEquals("$ hello world", cc.getWithSubString("$$$ hello world"));
        assertEquals("$ hello  world", cc.getWithSubString("$ hello $ world"));
        assertEquals("$ hello  world", cc.getWithSubString("hello $ world $"));
    }
}