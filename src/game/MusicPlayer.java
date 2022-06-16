package game;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

class MusicPlayer {
    public static void playFireMusic(){
        final String filename = "/music/Fire.wav";
        Clip clip = null;

        try (InputStream in = MusicPlayer.class.getResourceAsStream(filename)) {
            InputStream bufferedIn = new BufferedInputStream(in);
            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn)) {
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}