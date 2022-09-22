package edu.westga.tests.model.codepoint;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.model.codepoint.Codepoint;

public class TestToUTC16 {
    
    @Test
    public void test16From0000ToFFFF() {
        assertEquals("8FFF".toLowerCase(), new Codepoint("U+8FFF").toUTF16().toLowerCase());
    }

    @Test
    public void test16From10000To10FFFFLowerBound() {
        assertEquals("DBC0DC00".toLowerCase(), new Codepoint("U+100000").toUTF16().toLowerCase());
    }

    @Test
    public void test16From10000To10FFFF() {
        assertEquals("D823DFFF".toLowerCase(), new Codepoint("U+18FFF").toUTF16().toLowerCase());
    }

    @Test
    public void test16From10000To10FFFFUpperBound() {
        assertEquals("DBFFDFFF".toLowerCase(), new Codepoint("U+10FFFF").toUTF16().toLowerCase());
    }
}
