package edu.westga;

import edu.Codepoint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCodepoint {

    @Test
    public void test16() {
        assertEquals("D823DFFF".toLowerCase(), new Codepoint("18FFF").toUTF16().toLowerCase());
    }

    @Test
    public void test32() {
        assertEquals("00000005", new Codepoint("5").toUTF32());
    }

    @Test
    public void test8() {
        assertEquals("OO4D", new Codepoint("M").toUTF8());
    }
    
}
