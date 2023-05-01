package edu.gonzaga;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MusicPlayer 
{
    public AudioInputStream audIn;
    public Clip clip;

    public void loopSound(String str) throws Exception
    {

        try
        {
            try
            {
                clip.close();
            }
            catch(Exception e)
            {
                // this is just for the first file tbh
            }
            //use a .wav file name for the string
            audIn = AudioSystem.getAudioInputStream(new File(str));
            clip = AudioSystem.getClip();
            clip.open(audIn);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(exception);
        }
    }

    /**
     plays the specified .wav file asynchronously
    */
    public static synchronized void playSound(String sound) {
        new Thread(
        new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Menu.class.getResourceAsStream(sound)); // might need to change this
                    clip.open(inputStream);
                    clip.start(); 
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }
}
