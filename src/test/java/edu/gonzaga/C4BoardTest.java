package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;


public class C4BoardTest {
    @Test
    void createC4BoardTest() {
        C4Board c = new C4Board();
        Assertions.assertTrue(true);
    }

    @Test
    void acceptCoinTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 0);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 0));
    }

    @Test
    void boardDisplayTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 0);
        System.out.println(c4.boardDisplay());
        //Assertions.assertEquals("x", (c4.boardDisplay()).substring(10, 11));
    }
}
