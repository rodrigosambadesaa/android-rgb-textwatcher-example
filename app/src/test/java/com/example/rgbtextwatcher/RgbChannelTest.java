package com.example.rgbtextwatcher;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RgbChannelTest {
    @Test public void parsesAndClampsValues() {
        assertEquals(0, RgbChannel.parseClamped(null));
        assertEquals(0, RgbChannel.parseClamped(""));
        assertEquals(0, RgbChannel.parseClamped("bad"));
        assertEquals(0, RgbChannel.parseClamped("-3"));
        assertEquals(42, RgbChannel.parseClamped("42"));
        assertEquals(255, RgbChannel.parseClamped("255"));
        assertEquals(255, RgbChannel.parseClamped("999"));
    }
}
