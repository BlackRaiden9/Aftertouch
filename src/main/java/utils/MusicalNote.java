package utils;

public class MusicalNote {

    private static String[] supportedNotes = {"C", "C#", "Db", "D", "D#", "E", "Eb", "F", "F#", "G",
            "G#", "Gb", "A", "A#", "Ab", "B", "Bb"};


    public static boolean isMusicalNote(String frq) {
        for (int x = 0; x < supportedNotes.length; x++) {
            if (supportedNotes[x].equals(frq)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isModifier(char modifier) {
        if((modifier == '#') || (modifier =='b')) {
            return true;
        }
        return false;
    }

    public static int getOffsetForMidi(String frq) throws IllegalStateException {
        switch (frq) {
            case "C":
                return 0;
            case "C#":
            case "Db":
                return 1;
            case "D":
                return 2;
            case "D#":
            case "Eb":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "F#":
            case "Gb":
                return 6;
            case "G":
                return 7;
            case "G#":
            case "Ab":
                return 8;
            case "A":
                return 9;
            case "A#":
            case "Bb":
                return 10;
            case "B":
                return 11;
        }
        throw new IllegalStateException("Invalid frequency translation requested.");
    }
}

