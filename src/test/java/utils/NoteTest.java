package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void testParseNote() {
        // Validate 3 char note.
        Note note = Note.parseNote("3D4");
        assert note != null;
        assertEquals(3, note.getOctave());
        assertEquals("D", note.getMusicalNote());
        assertEquals(4.0, note.getDuration());

        // Validate 4 char note.
        note = Note.parseNote("3D/4");
        assert note != null;
        assertEquals(3, note.getOctave());
        assertEquals("D", note.getMusicalNote());
        assertEquals(0.25, note.getDuration());

        note = Note.parseNote("3F#4");
        assert note != null;
        assertEquals(3, note.getOctave());
        assertEquals("F#", note.getMusicalNote());
        assertEquals(4.0, note.getDuration());

        // Validate 5 char note.
        note = Note.parseNote("3G#/4");
        assert note != null;
        assertEquals(3, note.getOctave());
        assertEquals("G#", note.getMusicalNote());
        assertEquals(0.25, note.getDuration());
    }
}