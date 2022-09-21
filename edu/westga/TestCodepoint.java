package edu.westga;

import edu.Codepoint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCodepoint {

    @Test
    public void test16() {
        assertEquals("U+0000", new Codepoint("5").toUTF16());
    }

    @Test
    public void test32() {
        assertEquals("U+0000", new Codepoint("5").toUTF32());
    }

    @Test
    public void test8() {
        assertEquals("OO4D", new Codepoint("M").toUTF8());
    }
    
}
