package edu.westga.tests.model.codepoint;

import org.junit.jupiter.api.Test;

import edu.westga.model.codepoint.Codepoint;

import static org.junit.jupiter.api.Assertions.*;

public class TestCodepoint {

    @Test
    public void testValidConstructor() {
        Codepoint codepoint = new Codepoint("U+4F00");
        assertEquals("4f00".toLowerCase(), codepoint.codepoint.toLowerCase());
    }

    @Test
    public void testNullCodepoint() {
        assertThrows(NullPointerException.class, () -> {new Codepoint(null);});
    }

    @Test
    public void testEmptyInput() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Codepoint("");});
        
        assertEquals("Please enter in a value for codepoint",e.getMessage());
    }

    @Test
    public void testInputHigherThan10FFFF() {
       Exception e = assertThrows(IllegalArgumentException.class, () -> {new Codepoint("U+FFFFFFF");});
        
        assertEquals("Codepoint must be less than 0x10FFFF",e.getMessage());
    }

    @Test
    public void testInputNotANumber() {
       Exception e = assertThrows(IllegalArgumentException.class, () -> {new Codepoint("U+asda2f");});
        
        assertEquals("Please enter in a codepoint in Hexadecimal form. E.g: U+24F3 or 2BE8",e.getMessage());
    }
  
  
}
