package dev.lpa.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities utilities;
    @BeforeEach
    void setUp() {
        utilities = new Utilities();
    }

    @Test
    void everyNthInt() {
    }

    @Test
    void removePairs_threeRepeatedPairs() {
        String source = "AABCDDEFF";
        String actual = utilities.removePairs(source);
        String expected = "ABCDEF";
        assertEquals(expected,actual);
    }

    @Test
    void removePairs_twoRepeatedPairs() {
        String source = "ABCCABDEEF";
        String actual = utilities.removePairs(source);
        String expected = "ABCABDEF";
        assertEquals(expected,actual);
    }
    @Test
    void removePairs_sourceLengthLessThanTwo(){
        String source = "A";
        String actual = utilities.removePairs(source);
        String expected = "A";
        assertEquals(expected,actual);
    }

    @Test
    void converter() {
    }

    @Test
    void nullIfOddLength() {
    }
}