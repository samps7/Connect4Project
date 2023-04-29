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

    /**
     * The function plays a sound file in a continuous loop.
     * 
     * @param str The parameter "str" is a String variable that represents the file name of a .wav
     * audio file that will be played in a loop using the Java Sound API.
     */
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
     * This function plays a sound file in a new thread using the Java AudioSystem and Clip classes.
     * 
     * @param sound The parameter "sound" is a String that represents the file path or name of the
     * audio file that needs to be played. It is used to retrieve the audio file using the
     * getResourceAsStream() method.
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
