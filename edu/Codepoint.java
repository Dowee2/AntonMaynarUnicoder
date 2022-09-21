package edu;

public class Codepoint {

    public String codepoint;

    private final int codepoint16UpperUpperLimit = Integer.parseInt("FFFF",16);
    private final int codepoint16UpperLowerLimit = Integer.parseInt("E000",16);
    private final int codepoint16LowerUpperLimit = Integer.parseInt("D7FF",16);

    public Codepoint(String codepoint) {
        this.codepoint = codepoint.replace("U+", "");
       // this.codepoint = codepoint.replace("0\\x", "");
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
            codepoint16Binary = "0" +codepoint16Binary;
        }
        String  highSurrogateBinary = codepoint16Binary.substring(0,10);
        String lowSurrogateBinary = codepoint16Binary.substring(10);
        int highSurrogate = Integer.parseInt(highSurrogateBinary,2) + 0xD800;
        int lowSurrogate = Integer.parseInt(lowSurrogateBinary,2) + 0xDC00;
        System.out.println(Integer.toHexString(highSurrogate)); 
        System.out.println(Integer.toHexString(lowSurrogate));
        String test = Integer.toHexString(highSurrogate);
        String test2 = Integer.toHexString(lowSurrogate) ;
        String UTF16 = Integer.toHexString(highSurrogate) + "" + Integer.toHexString(lowSurrogate); 
    
        //Checks if codepoionts are ranges for codepoints U+0000 to U+D7FF and U+E000 to U+FFFF and returns the actual codepoint value
        // if(codepoint16 >= 0 && codepoint16 <= this.codepoint16LowerUpperLimit
        //     || codepoint16 >= this.codepoint16UpperLowerLimit && codepoint16 <= this.codepoint16UpperUpperLimit
        // ) {
        //     return "" + codepoint16;
        // }
        return UTF16;
    }
    
    public String toUTF32() {
        while (this.codepoint.length() < 8) {
            this.codepoint = "0" + this.codepoint;
        }
        return this.codepoint;
    }
}
