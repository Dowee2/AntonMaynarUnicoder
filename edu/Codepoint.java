package edu;

public class Codepoint {

    public String codepoint;


    public Codepoint(String codepoint) {
        codepoint = codepoint.replace("U+", "");
        if ( Integer.parseInt(codepoint, 16) > 0x10FFFF ) {
            throw new IllegalArgumentException("Codepoint must be less than 0x10FFFF");
        }
        
       this.codepoint = codepoint;
    }

    /**
     * Convert the codepoint to UTF-8 Hexcode  (e.g. U+0000)
     * @return codepoint In UTF8 Format
     */
    public String toUTF8() {
        int codepoint8 =  Integer.parseInt(codepoint, 16);
        if (codepoint8 < 0x007F) {
            return String.format("%02X", codepoint8);
        } else if (codepoint8 < 0x07FF) {
            return String.format("%02X%02X", 0xC0 | (codepoint8 >> 6), 0x80 | (codepoint8 & 0x3F));
        } else if (codepoint8 < 0xFFFF) {
            return String.format("%02X%02X%02X", 0xE0 | (codepoint8 >> 12), 0x80 | ((codepoint8 >> 6) & 0x3F), 0x80 | (codepoint8 & 0x3F));
        } else if (codepoint8 < 0x10FFFF) {
            return String.format("%02X%02X%02X%02X", 0xF0 | (codepoint8 >> 18), 0x80 | ((codepoint8 >> 12) & 0x3F), 0x80 | ((codepoint8 >> 6) & 0x3F), 0x80 | (codepoint8 & 0x3F));
        }
        
        return "Invalid Codepoint";
    }

    public String toUTF16() {

        if (this.codepoint.length() == 4) {
            return this.codepoint;
        }
        if (this.codepoint.length() < 4) {
            while (this.codepoint.length() < 4) {
                this.codepoint = "0" + this.codepoint;
            }
            return this.codepoint;
        }

        int codepoint16 = Integer.parseInt(codepoint, 16);
        codepoint16 -= 0x10000;
        String codepoint16Binary = Integer.toBinaryString(codepoint16);
        while (codepoint16Binary.length() < 20) {
            codepoint16Binary = "0" + codepoint16Binary;
        }
        String  highSurrogateBinary = codepoint16Binary.substring(0,10);
        String lowSurrogateBinary = codepoint16Binary.substring(10);

        int highSurrogate = Integer.parseInt(highSurrogateBinary,2) + 0xD800;
        int lowSurrogate = Integer.parseInt(lowSurrogateBinary,2) + 0xDC00;

        String UTF16 = Integer.toHexString(highSurrogate) + "" + Integer.toHexString(lowSurrogate); 
    
        return UTF16;
    }
    
    public String toUTF32() {
        while (this.codepoint.length() < 8) {
            this.codepoint = "0" + this.codepoint;
        }
        return this.codepoint;
    }
}
