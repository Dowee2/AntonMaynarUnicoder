package edu.westga.tests.model.codepoint;
import org.junit.jupiter.api.Test;

import edu.westga.model.codepoint.Codepoint;

import static org.junit.jupiter.api.Assertions.*;

public class TestToUTC32 {

    @Test
    public void test32AllZero() {
        assertEquals("00000000", new Codepoint("U+0000").toUTF32());
    }

    @Test
    public void test32HighestCodePoint() {
        assertEquals("0010FFFF", new Codepoint("U+10FFFF").toUTF32());
    }

    @Test
    public void test32ValidInput() {
        assertEquals("0005EEEE", new Codepoint("U+5EEEE").toUTF32());
    }
}
