package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;


public class MenuTest {
    @Test
    void displayTest() {
        Menu m1 = new Menu();
        m1.displayOptions();
        Assertions.assertTrue(true);
    }
}
