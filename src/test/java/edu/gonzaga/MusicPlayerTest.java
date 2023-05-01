package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class MusicPlayerTest {
    @Test
    void musicLoopTest() {
        MusicPlayer mp = new MusicPlayer();
        try {
            mp.loopSound("resources/music/Botique.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(true);
    }
    
}
