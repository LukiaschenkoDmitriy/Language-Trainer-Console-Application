package LTCA.Test.Converter;

import org.junit.jupiter.api.Test;
import LTCA.Converter.WordConverter;
import static org.junit.jupiter.api.Assertions.*;

class WordConverterTest {
    private static final WordConverter cc = WordConverter.getSingleton();
    @Test
    void validate() {
        assertTrue(cc.validate("// hello world"));
        assertTrue(cc.validate("//hello world"));
        assertTrue(cc.validate("//   hello world"));
        assertFalse(cc.validate("*hello world"));
        assertFalse(cc.validate("hello # world"));
        assertFalse(cc.validate("hello world #"));
        assertFalse(cc.validate("/hello world"));
    }

    @Test
    void getWithoutSubString() {
        assertEquals("hello world", cc.getWithoutSubString("//hello world"));
        assertEquals("hello world", cc.getWithoutSubString("//hello world"));
        assertEquals("hello world", cc.getWithoutSubString("hello world"));
        assertEquals("hello world", cc.getWithoutSubString("hello world //"));
        assertEquals("hello  world", cc.getWithoutSubString("hello // world"));
    }

    @Test
    void getWithSubString() {
        assertEquals("// hello world", cc.getWithSubString("hello world"));
        assertEquals("// hello world", cc.getWithSubString("// hello world"));
        assertEquals("// hello world", cc.getWithSubString("////// hello world"));
        assertEquals("// hello  world", cc.getWithSubString("// hello // world"));
        assertEquals("// hello  world", cc.getWithSubString("hello // world //"));
    }
}