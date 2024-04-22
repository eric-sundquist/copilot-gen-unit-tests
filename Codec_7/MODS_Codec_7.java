package org.apache.commons.codec.binary;

import junit.framework.TestCase;
import java.util.Arrays;

public class Base64Test extends TestCase {

    private Base64 base64;

    protected void setUp() {
        base64 = new Base64();
    }

    public void testEncodeBase64StringWithNullInput() {
        try {
            base64.encodeBase64String(null);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    public void testEncodeBase64StringWithEmptyInput() {
        byte[] input = new byte[0];
        String result = base64.encodeBase64String(input);
        assertEquals("", result);
    }

    public void testEncodeBase64StringWithSingleByte() {
        byte[] input = new byte[]{0x41}; // 'A'
        String result = base64.encodeBase64String(input);
        assertEquals("QQ==", result);
    }

    public void testEncodeBase64StringWithMultipleBytes() {
        byte[] input = new byte[]{0x41, 0x42, 0x43}; // 'ABC'
        String result = base64.encodeBase64String(input);
        assertEquals("QUJD", result);
    }

    public void testEncodeBase64StringWithNonAsciiBytes() {
        byte[] input = new byte[]{(byte) 0x80, (byte) 0xFF};
        String result = base64.encodeBase64String(input);
        assertEquals("gP8=", result);
    }

    public void testEncodeBase64StringWithLargeInput() {
        byte[] input = new byte[1024];
        Arrays.fill(input, (byte) 0x41); // 'A'
        String result = base64.encodeBase64String(input);
        assertTrue(result.startsWith("QUFB"));
        assertTrue(result.endsWith("QUFB"));
    }
}