package game;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

class MusicPlayer {
    static final String filename = "/music/Fire.wav";
    static Clip clip = null;

    public static void playFireMusic(){
        try (InputStream in = MusicPlayer.class.getResourceAsStream(filename)) {
            InputStream bufferedIn = new BufferedInputStream(in);
            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn)) {
                clip = AudioSystem.getClip();
                clip.open(audioIn);

                // Loop fire music to play it continuously throughout the game
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopFireMusic(){
        clip.stop();
    }

}