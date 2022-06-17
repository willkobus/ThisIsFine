package game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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


                // loop music continuously
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                // turn music on and off
//                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//                gainControl.setValue(0);
//                JOptionPane.showMessageDialog(null, "Press OK to stop music");



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}