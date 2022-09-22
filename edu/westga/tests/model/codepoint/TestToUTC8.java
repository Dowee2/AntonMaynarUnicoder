package edu.westga.tests.model.codepoint;
import org.junit.jupiter.api.Test;

import edu.westga.model.codepoint.Codepoint;

import static org.junit.jupiter.api.Assertions.*;

public class TestToUTC8 {

    @Test
    public void testCodePointFrom0000To007ELowerBound() {
        assertEquals("00".toLowerCase(), new Codepoint("U+0000").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom0000To007F() {
        assertEquals("5A".toLowerCase(), new Codepoint("U+005A").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom0000To007FUpperBound() {
        assertEquals("7E".toLowerCase(), new Codepoint("U+007E").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom0080To07FFLowerBound() {
        assertEquals("C280".toLowerCase(), new Codepoint("U+0080").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom0080To07FF() {
        assertEquals("C6A0".toLowerCase(), new Codepoint("U+01A0").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom0080To07FFUpperBound() {
        assertEquals("DFBF".toLowerCase(), new Codepoint("U+07FF").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom0800ToFFFF() {
        assertEquals("E4B3A3".toLowerCase(), new Codepoint("U+4CE3").toUTF8().toLowerCase());
    }

    @Test
    public void testCodePointFrom10000To10FFFFLowerBound() {
        assertEquals("f4808080".toLowerCase(), new Codepoint("U+100000").toUTF8().toLowerCase());
    }  

    @Test
    public void testCodePointFrom10000To10FFFF() {
        assertEquals("F48B8D81".toLowerCase(), new Codepoint("U+10B341").toUTF8().toLowerCase());
    } 

    @Test
    public void testCodePointFrom10000To10FFFFUpperBound() {
        assertEquals("F48FBFBF".toLowerCase(), new Codepoint("U+10FFFF").toUTF8().toLowerCase());
    } 
}
