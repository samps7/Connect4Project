package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class MainGameTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void display() {
        Menu m1 = new Menu();
        m1.displayOptions();

        Assertions.assertTrue(true);
    }
}
