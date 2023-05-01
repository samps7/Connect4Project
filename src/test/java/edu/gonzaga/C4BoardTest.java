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
    void acceptCoin0Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 0);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 0));
    }

    @Test
    void acceptCoin1Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 1);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 1));
    }

    @Test
    void acceptCoin2Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 2);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 2));
    }

    @Test
    void acceptCoin3Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 3);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 3));
    }

    @Test
    void acceptCoin4Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 4);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 4));
    }

    @Test
    void acceptCoin5Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 5);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 5));
    }

    @Test
    void acceptCoin6Test() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 6);
        Assertions.assertEquals(c, c4.returnArrayIndex(5, 6));
    }

    @Test
    void acceptCoin7FalseTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        Assertions.assertEquals(false, c4.acceptCoin(c, 7));
    }

    @Test
    void acceptCoinBoolTrueTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        Assertions.assertEquals(true, c4.acceptCoin(c, 0));
    }

    @Test
    void acceptCoinBoolFalseTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        Assertions.assertEquals(false, c4.acceptCoin(c, 0));
    }

    @Test
    void checkWinnerTrueTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        Assertions.assertEquals(true, c4.checkWinner());
    }

    @Test
    void checkWinnerFalseTest() {
        C4Board c4 = new C4Board();
        Coin c = new Coin("x");
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        c4.acceptCoin(c, 0);
        Assertions.assertEquals(false, c4.checkWinner());
    }

   
}
