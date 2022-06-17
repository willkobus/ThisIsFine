package game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

class MusicPlayer {
    static final String filename = "/music/Fire.wav";
    static final String doorCloseFile = "/music/DoorClosing.wav";
    static Clip clip = null;

    public static void playFireMusic(){
        try (InputStream in = MusicPlayer.class.getResourceAsStream(filename)) {
            InputStream bufferedIn = new BufferedInputStream(in);
            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn)) {
                clip = AudioSystem.getClip();
                clip.open(audioIn);

                // Loop fire music to play it continuously throughout the game.
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopFireMusic(){
        clip.stop();
    }

    public static void playDoorCloseMusic() {
        try (InputStream inputStream = MusicPlayer.class.getResourceAsStream(doorCloseFile)){
            InputStream bufferedInput = new BufferedInputStream(inputStream);
            try(AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInput)){
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}