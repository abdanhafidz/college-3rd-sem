package id.its.pbo;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Catch the Stars");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            try {
                frame.add(new GamePanel());
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            frame.setVisible(true);
        });
    }
}