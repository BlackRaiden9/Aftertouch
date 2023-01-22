package utils;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;


public class PlayEngine {
    private int QTRNOTE = 500;
    private static MidiChannel[] channels;
    private static int INSTRUMENT = 0; // 0 is a piano, 9 is percussion, other channels are for other instruments
    private static int VOLUME = 80; // between 0 et 127
    Synthesizer synth;

    public PlayEngine() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        synth.close();
    }

    public void play(Note note)  {
        // * start playing a note
        int octave = note.getOctave();
        int midi = Octave.getBaseMidi(octave) + MusicalNote.getOffsetForMidi(note.getMusicalNote());
        try {
            channels[INSTRUMENT].noteOn(midi, VOLUME );
            // * wait
            Thread.sleep((long) (QTRNOTE * note.getDuration()));
            // * stop playing a note
            channels[INSTRUMENT].noteOff(midi);
        } catch (InterruptedException e) {

        }

    }
}
