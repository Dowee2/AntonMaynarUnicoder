package edu.westga.tests.model.codepoint;

import org.junit.jupiter.api.Test;

import edu.westga.model.codepoint.Codepoint;

import static org.junit.jupiter.api.Assertions.*;

public class TestCodepoint {


    @Test
    public void test32() {
        assertEquals("00000005", new Codepoint("U+5").toUTF32());
    }

    
    
}
