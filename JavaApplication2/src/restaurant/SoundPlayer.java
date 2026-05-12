package restaurant;

import javax.sound.sampled.*;
import java.net.URL;

public class SoundPlayer {

    private static Clip bgMusic; 
private static boolean muted = false;
    //  Play sound effect (click, button, etc.)
    public static void playEffect(String soundPath) {
        try {
            URL url = SoundPlayer.class.getResource(soundPath);
            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🎵 Background music (ALWAYS playing)
    public static void playBackgroundMusic() {
        if (bgMusic != null && bgMusic.isRunning()) return; // already playing

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                SoundPlayer.class.getResource("/restaurant/The Rake Hornpipe.wav")
            );

            bgMusic = AudioSystem.getClip();
            bgMusic.open(audio);
            bgMusic.loop(Clip.LOOP_CONTINUOUSLY);
            bgMusic.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Stop music
    public static void stopBackgroundMusic() {
        if (bgMusic != null) {
            bgMusic.stop();
            bgMusic.close();
            bgMusic = null;
        }
    }
    public static void toggleMute() {
        if (bgMusic == null) return;

        if (muted) {
            bgMusic.start();
            bgMusic.loop(Clip.LOOP_CONTINUOUSLY);
            muted = false;
        } else {
            bgMusic.stop();
            muted = true;
        }
    }

    public static boolean isMuted() {
        return muted;
    }
}
