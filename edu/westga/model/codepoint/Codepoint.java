package edu.westga.model.codepoint;

public class Codepoint {

    public String codepoint;

    public Codepoint(String codepoint) {
        codepoint = codepoint.replace("U+", "");
        codepoint = codepoint.replace("0x", "");
        if (codepoint == null) {
            throw new NullPointerException("Codepoint cannot be null");
        }

        if (codepoint.isEmpty()) {
            throw new IllegalArgumentException("Please enter in a value for codepoint");
        }

        try {
            if (Integer.parseInt(codepoint, 16) > 0x10FFFF) {
                throw new IllegalArgumentException("Codepoint must be less than 0x10FFFF");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please enter in a codepoint in Hexadecimal form. E.g: U+24F3 or 2BE8");
        }

        this.codepoint = codepoint;
    }

    /**
     * Convert the codepoint to UTF-8 Hexcode
     * 
     * @return codepoint In UTF8 Format
     */
    public String toUTF8() {
        int codepoint8 = Integer.parseInt(codepoint, 16);
        if (codepoint8 <= 0x007F) {
            return String.format("%02X", codepoint8);
        } else if (codepoint8 <= 0x07FF) {
            return String.format("%02X%02X", 0xC0 | (codepoint8 >> 6), 0x80 | (codepoint8 & 0x3F));
        } else if (codepoint8 <= 0xFFFF) {
            return String.format("%02X%02X%02X", 0xE0 | (codepoint8 >> 12), 0x80 | ((codepoint8 >> 6) & 0x3F),
                    0x80 | (codepoint8 & 0x3F));
        } else if (codepoint8 <= 0x10FFFF) {
            return String.format("%02X%02X%02X%02X", 0xF0 | (codepoint8 >> 18), 0x80 | ((codepoint8 >> 12) & 0x3F),
                    0x80 | ((codepoint8 >> 6) & 0x3F), 0x80 | (codepoint8 & 0x3F));
        }

        return "Invalid Codepoint";
    }

    /**
     * Converts the codepoint to UTF-16 Format
     * 
     * @return The codepoint in UTF-16 Format
     */
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
        codepoint16Binary = String.format("%20s", codepoint16Binary).replace(' ', '0');
        String highSurrogateBinary = codepoint16Binary.substring(0, 10);
        String lowSurrogateBinary = codepoint16Binary.substring(10);

        int highSurrogate = Integer.parseInt(highSurrogateBinary, 2) + 0xD800;
        int lowSurrogate = Integer.parseInt(lowSurrogateBinary, 2) + 0xDC00;

        String UTF16 = Integer.toHexString(highSurrogate) + "" + Integer.toHexString(lowSurrogate);

        return UTF16;
    }

    /**
     * Converts the codepoint to UTF-32 Format
     * 
     * @return The codepoint in UTF-32 Format
     */
    public String toUTF32() {
        while (this.codepoint.length() < 8) {
            this.codepoint = "0" + this.codepoint;
        }
        return this.codepoint;
    }
}
