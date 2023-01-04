package Model.component;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioP {

    private String p;
    private static AudioP i;

    private AudioP(String p) {
        this.p = p;
    }

    public static AudioP getInstance(String p) {
        if (i == null) {
            i = new AudioP(p);
        } else {
            i.p = p;
        }
        return i;
    }

    public void play() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(p).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        //Plays audio once
        clip.start();

    }
}

//                //////////////////////////////////////////////////////////////////////////////
//                AudioP audio = AudioP.getInstance("res/AudioName.wav");
//                audio.play();
//                //////////////////////////////////////////////////////////////////////////////
