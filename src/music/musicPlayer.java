package music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class musicPlayer {
    private File file;
    AudioInputStream as;
    Clip clip;

    public musicPlayer() {
        file = new File("./music/music.wav");
        try {
            as = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(as);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null,"Could not play music", "Music error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void playSong() {
        clip.start();
    }
}
