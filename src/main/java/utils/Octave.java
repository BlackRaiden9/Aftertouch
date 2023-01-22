package utils;

/**
 * This class represents an octave. This class has two main functions.
 * IsOctave, that checks if a given character is Octave.
 * parseOctave - That returns the Octave that has been detected.
 * <p>
 * An octave is a number that is between 1 - 8, inclusive of both numbers.
 */
public class Octave {
    /**
     * Returns true if a char represents an octave. False otherwise.
     *
     * @param octave - A char between 1 - 8
     * @return true if it is a valid octave, false otherwise.
     */
    public static boolean isOctave(char octave) {
        switch (octave) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
                return true;
            default:
                return false;
        }
    }

    /**
     * Returns the Octave as a number.
     *
     * @param octave - Char that represents the Octave.
     * @return - int
     */
    public static int parseOctave(char octave) throws NumberFormatException {
        return Integer.parseInt(String.valueOf(octave));
    }

    /**
     * Returns the Base MIDI number where this octave starts.
     * This is based on the official Midi spec.
     * @param octave - int
     * @return return the base number where the octave starts
     */
    public static int getBaseMidi(int octave) {
        return 12 * octave + 12;
   }

}
