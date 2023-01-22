import utils.Note;
import utils.PlayEngine;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AfterTouch {
    JFrame frame;
    JPanel panel;
    JTextArea song;
    JButton button;
    JTextPane helpPane;

    public AfterTouch() throws IOException, BadLocationException {
        String helpText = """
                <html><h1> AfterTouch - A Music Language with a Soul</h1>
                <br> <h2>Music in AfterTouch is written as sequence of <b>notes.</b></h2>
                There are three components to writing a note. They are
                <ul>
                  <li><b>Octave</b> - This controls the pitch of the Music. There are 8 octaves in AfterTouch, and are defined as <b> 1, 2, 3, 4, 5, 6, 7, 8.</b> </li>
                  <li><b>Note</b> - The note or the frequency of the music you want to play. The notes in AfterTouch are <b>
                  "C", "C#", "Db", "D", "D#", "E", "Eb", "F", "F#", "G","G#","Gb", "A", "A#", "Ab", "B", "Bb"</b></li>
                  <li><b>Duration</b> - The duration you want to play the note for. whole numbers or numbers as fraction can be entered. <b>1, 2 or /4 /8</b> are examples</li>
                </ul>
                """;
        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new BorderLayout());
        song = new JTextArea();
        song.setPreferredSize(new Dimension(500, 500));
        song.setText("4D1 4D1 4D/2 4E/4 4F#/2 4F#/2 4E/4 4F#/2 4G/4 4A2   4D1 4D1 4D/2 4E/4 4F#/2 4F#/2 4E/4 4F#/2 4G/4 4A2 ");
        song.setLineWrap(true);
        panel.add(song, BorderLayout.WEST);
        helpPane = new JTextPane();
        helpPane.setText(helpText);
        helpPane.setContentType("text/html");
        helpPane.setEditable(false);
        HTMLDocument doc = (HTMLDocument) helpPane.getDocument();
        HTMLEditorKit editorKit = (HTMLEditorKit) helpPane.getEditorKit();

        editorKit.insertHTML(doc, doc.getLength(), helpText, 0, 0, null);
        helpPane.setPreferredSize(new Dimension(500, 500));
        panel.add(helpPane, BorderLayout.EAST);
        button = new JButton("Play Song");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });
        panel.add(button, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("After Touch - A new way to compose music.");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void play() {
        String notes = song.getText();
        String[] noteArray = notes.split(" ");
        PlayEngine playEngine = new PlayEngine();
        for (int x = 0; x < noteArray.length; x++) {
            String currentNote = noteArray[x].strip();
            if (!currentNote.isEmpty()) {
                Note note = Note.parseNote(currentNote);
                playEngine.play(note);
            }
        }
        playEngine.close();
    }

    public static void main(String[] args) throws IOException, BadLocationException {
        new AfterTouch();
    }

}
