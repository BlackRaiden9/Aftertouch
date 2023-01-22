package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OctaveTest {

    @Test
    public void testIsOctave() {
        // True tests.
        assertTrue(Octave.isOctave('1'));
        assertTrue(Octave.isOctave('2'));
        assertTrue(Octave.isOctave('3'));
        assertTrue(Octave.isOctave('4'));
        assertTrue(Octave.isOctave('5'));
        assertTrue(Octave.isOctave('6'));
        assertTrue(Octave.isOctave('7'));
        assertTrue(Octave.isOctave('8'));


        // Now false tests.
        assertFalse(Octave.isOctave('#'));
        assertFalse(Octave.isOctave('A'));
        assertFalse(Octave.isOctave('~'));
        assertFalse(Octave.isOctave('_'));
        assertFalse(Octave.isOctave('b'));
        assertFalse(Octave.isOctave('<'));
        assertFalse(Octave.isOctave('}'));
    }

    @Test
    public void testParseOctave() {
        assertEquals(1, Octave.parseOctave('1'));
        assertEquals(2, Octave.parseOctave('2'));
        assertEquals(3, Octave.parseOctave('3'));
        assertEquals(4, Octave.parseOctave('4'));
        assertEquals(5, Octave.parseOctave('5'));
        assertEquals(6, Octave.parseOctave('6'));
        assertEquals(7, Octave.parseOctave('7'));
        assertEquals(8, Octave.parseOctave('8'));

        // Non number argument should throw.
        assertThrows(NumberFormatException.class, () -> Octave.parseOctave('#'));
        assertThrows(NumberFormatException.class, () -> Octave.parseOctave('@'));
        assertThrows(NumberFormatException.class, () -> Octave.parseOctave('A'));
        assertThrows(NumberFormatException.class, () -> Octave.parseOctave('B'));
        assertThrows(NumberFormatException.class, () -> Octave.parseOctave('}'));
    }

    @Test
    public void testMidi() {

        assertEquals(24, Octave.getBaseMidi(1));
        assertEquals(36, Octave.getBaseMidi(2));
        assertEquals(48, Octave.getBaseMidi(3));
        assertEquals(60, Octave.getBaseMidi(4));
        assertEquals(72, Octave.getBaseMidi(5));
        assertEquals(84, Octave.getBaseMidi(6));
        assertEquals(96, Octave.getBaseMidi(7));
        assertEquals(108, Octave.getBaseMidi(8));

    }
}