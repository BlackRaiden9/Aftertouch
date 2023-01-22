package utils;

/**
 * A duration is either a single number or a /number, or slash followed by
 * a number.
 */
public class Duration {
    /**
     * Checks if this is a valid duration.
     * @param duration - Duration as String
     * @return True if Duration, false otherwise.
     */
    public static boolean isDuration(String duration) {
        try {
            if (duration.charAt(0) == '/') {
                Integer.parseInt(duration.substring(1));
            } else {
                Integer.parseInt(duration);
            }
        } catch (NumberFormatException nm) {
            return false;
        }
        return true;
    }

    /**
     * Gets the Duration as a weight to be applied to a quarter note.
     * @param duration - Duration as String
     * @return floating point weight to be applied to a quarter note to find the length of the note.
     * @throws NumberFormatException
     */
    public static float parseDuration(String duration) throws NumberFormatException {
        int number = 0;
        if (duration.charAt(0) == '/') {
            number = Integer.parseInt(duration.substring(1));
            return (float) (1.0 / number);
        } else {
            number = Integer.parseInt(duration);
            return (float) number;
        }
    }
}
