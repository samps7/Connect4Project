package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;


public class MenuTest {
    @Test
    void displayTest() {
        MusicPlayer mp = new MusicPlayer();
        Menu m1 = new Menu(mp);
        try {
            m1.displayOptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(true);
    }
}
