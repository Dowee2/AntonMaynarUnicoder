package edu;

public class Codepoint {

    public String codepoint;

    public Codepoint(String codepoint) {
        this.codepoint = codepoint.replace("U+", "");
        this.codepoint = codepoint.replace("0x", "");
    }

    /**
     * Convert the codepoint to UTF-8 Hexcode  (e.g. U+0000)
     * @return codepoint In UTF8 Format
     */
    public String toUTF8() {
        int codePointAsInt = Integer.parseInt(this.codepoint, 16);
        
        return "";
    }

    public String toUTF16() {
        int codepoint16 = +Integer.parseInt(codepoint, 16);
        //ranges for codepoints U+0000 to U+D7FF and U+E000 to U+FFFF (note the gap!)

        if(this.codepoint )
        

        return "codepoint16";

    }
    
    public String toUTF32() {
        while (this.codepoint.length() < 8) {
            this.codepoint = "0" + this.codepoint;
        }
        return this.codepoint;
    }
}
