package utils;

/**
 * Note is written as [Octave][MusicalNote][Duration]
 * Octave is always a single character.
 * MusicalNote can be one or two characters. The second character is either # (sharp) or b (flat)
 * Duration can be one or two characters. It is either a single number like 1, 2, 4 or it is /2, /3, /4, /8
 * <p>
 * So the length of a note can be one of these.
 * <p>
 * 1. octave (1) + MusicalNote(1) + Duration (1) = 3 e.g. 2C2
 * 2. octave (1) + MusicalNote(2) + Duration (1) = 4 e.g. 4C#4
 * 3. octave (1) + MusicalNote(1) + Duration (2) = 4 e.g. 4E/2
 * 4. octave (1) + MusicalNote(2) + Duration (2) = 5 e.g. 5C#/4
 * <p>
 * So using the length of the note, we can determine how we should parse a note.
 * To differentiate between the cases of 2 and 3, we will check if the [2] char
 * is a modifier that is a Sharp(#) or a flat(6).
 * <p>
 * TODO: Deal with handling Rest.
 */
public class Note {
    private int octave;
    private String musicalNote;
    private float duration;

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public String getMusicalNote() {
        return musicalNote;
    }

    public void setMusicalNote(String musicalNote) {
        this.musicalNote = musicalNote;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public static Note parseNote(String noteStr) throws IllegalStateException {

        if (noteStr.length() == 3) {
            return parse3CharNote(noteStr);
        }

        if (noteStr.length() == 4)  {
            if(noteStr.charAt(2) == '/') {
                // This is note with two duration letters - For example, 4E/2
                return parse4CharDoubleDuration(noteStr);
            } else {
                return parse4CharDoubleMusicalNote(noteStr);
            }
        }

        if(noteStr.length() == 5) {
            return parse5CharNote(noteStr);
        }

   return null;
    }

    // 5C#/4
    private static Note parse5CharNote(String noteStr) {
        Note newNote = new Note();
        //TODO: Handle the rest note case here.
        if (!Octave.isOctave((noteStr.charAt(0)))) {
            throw new IllegalStateException("Octave Expected. Found ==> " + noteStr.charAt(0) + " at Note: " + noteStr);
        }
        newNote.setOctave(Octave.parseOctave(noteStr.charAt(0)));

        if (!MusicalNote.isMusicalNote(noteStr.substring(1,3))) {
            throw new IllegalStateException("Musical Note Expected. Found ==> " + noteStr.substring(1,3) + " at Note: " + noteStr);
        }
        newNote.setMusicalNote(noteStr.substring(1,3));

        if (!Duration.isDuration(noteStr.substring(3))) {
            throw new IllegalStateException("Duration Expected. Found ==> " + noteStr.charAt(2) + " at Note: " + noteStr);
        }
        newNote.setDuration(Duration.parseDuration(noteStr.substring(3)));
        return newNote;

    }

    private static Note parse4CharDoubleDuration(String noteStr) {
        Note newNote = new Note();
        //TODO: Handle the rest note case here.
        if (!Octave.isOctave((noteStr.charAt(0)))) {
            throw new IllegalStateException("Octave Expected. Found ==> " + noteStr.charAt(0) + " at Note: " + noteStr);
        }
        newNote.setOctave(Octave.parseOctave(noteStr.charAt(0)));

        if (!MusicalNote.isMusicalNote(String.valueOf(noteStr.charAt(1)))) {
            throw new IllegalStateException("Musical Note Expected. Found ==> " + noteStr.charAt(1) + " at Note: " + noteStr);
        }
        newNote.setMusicalNote(String.valueOf(noteStr.charAt(1)));

        if (!Duration.isDuration(noteStr.substring(2))) {
            throw new IllegalStateException("Duration Expected. Found ==> " + noteStr.charAt(2) + " at Note: " + noteStr);
        }
        newNote.setDuration(Duration.parseDuration(noteStr.substring(2)));
        return newNote;
    }

    private static Note parse4CharDoubleMusicalNote(String noteStr) {
        Note newNote = new Note();
        //TODO: Handle the rest note case here.
        if (!Octave.isOctave((noteStr.charAt(0)))) {
            throw new IllegalStateException("Octave Expected. Found ==> " + noteStr.charAt(0) + " at Note: " + noteStr);
        }
        newNote.setOctave(Octave.parseOctave(noteStr.charAt(0)));
        // 4C#2 -> this will return C#
        if (!MusicalNote.isMusicalNote(noteStr.substring(1,3))) {
            throw new IllegalStateException("Musical Note Expected. Found ==> " + noteStr.substring(1,3) + " at Note: " + noteStr);
        }
        newNote.setMusicalNote(noteStr.substring(1,3));

        if (!Duration.isDuration(String.valueOf(noteStr.charAt(3)))) {
            throw new IllegalStateException("Duration Expected. Found ==> " + noteStr.charAt(3) + " at Note: " + noteStr);
        }
        newNote.setDuration(Duration.parseDuration(String.valueOf(noteStr.charAt(3))));
        return newNote;
    }

    /**
     * Parse a note in the following format - octave (1) + MusicalNote(1) + Duration (1) = 3
     *
     * @param noteStr - String argument like 4C2
     * @return Note class with octave, MusicalNote and Duration seperated as member variables.
     */
    private static Note parse3CharNote(String noteStr) {
        Note newNote = new Note();
        //TODO: Handle the rest note case here.
        if (!Octave.isOctave((noteStr.charAt(0)))) {
            throw new IllegalStateException("Octave Expected. Found ==> " + noteStr.charAt(0) + " at Note: " + noteStr);
        }
        newNote.setOctave(Octave.parseOctave(noteStr.charAt(0)));

        if (!MusicalNote.isMusicalNote(String.valueOf(noteStr.charAt(1)))) {
            throw new IllegalStateException("Musical Note Expected. Found ==> " + noteStr.charAt(1) + " at Note: " + noteStr);
        }
        newNote.setMusicalNote(String.valueOf(noteStr.charAt(1)));

        if (!Duration.isDuration(String.valueOf(noteStr.charAt(2)))) {
            throw new IllegalStateException("Duration Expected. Found ==> " + noteStr.charAt(2) + " at Note: " + noteStr);
        }
        newNote.setDuration(Duration.parseDuration(String.valueOf(noteStr.charAt(2))));
        return newNote;
    }

    @Override
    public String toString() {
        return "Note{" +
                "octave=" + octave +
                ", musicalNote='" + musicalNote + '\'' +
                ", duration=" + duration +
                '}';
    }
}
