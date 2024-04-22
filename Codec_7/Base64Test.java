package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Base64Test {

    @Test
    public void testEncodeBase64StringWithValidInput() {
        byte[] input = "valid input".getBytes();
        String expected = "dmFsaWQgaW5wdXQ=";
        assertEquals(expected, Base64.encodeBase64String(input));
    }

    @Test
    public void testEncodeBase64StringWithEmptyInput() {
        byte[] input = "".getBytes();
        String expected = "";
        assertEquals(expected, Base64.encodeBase64String(input));
    }

    @Test
    public void testEncodeBase64StringWithNullInput() {
        byte[] input = null;
        String expected = null;
        assertEquals(expected, Base64.encodeBase64String(input));
    }

    @Test
    public void testEncodeBase64StringWithBoundaryInput() {
        byte[] input = new byte[76];
        assertNotNull(Base64.encodeBase64String(input));
    }

    @Test
    public void testEncodeBase64StringWithLargeInput() {
        byte[] input = new byte[10000];
        assertNotNull(Base64.encodeBase64String(input));
    }
}