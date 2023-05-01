package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class BotTest {
    @Test
    void createBotTest() {
        Coin c = new Coin("x");
        Bot b = new Bot("Bob", c);
        Assertions.assertTrue(true);
    }

    @Test
    void isNumericTrueTest() {
        Coin c = new Coin("x");
        Bot b = new Bot("Bob", c);
        Boolean check = true;
        Boolean actual = b.isNumeric("123");
        Assertions.assertEquals(check, actual);
    }

    @Test
    void isNumericFalseTest() {
        Coin c = new Coin("x");
        Bot b = new Bot("Bob", c);
        Boolean check = false;
        Boolean actual = b.isNumeric("dave");
        Assertions.assertEquals(check, actual);
    }

    @Test
    void intCountTest() {
        Coin c = new Coin("x");
        Bot b = new Bot("Bob", c);
        Integer check = 3;
        Integer actual = b.intCount("555", 5);
        Assertions.assertEquals(check, actual);
    }

    @Test
    void getMoveNegativeTest() {
        C4Board c4 = new C4Board();
        Coin c1 = new Coin("x");
        c4.acceptCoin(c1, 0);
        c4.acceptCoin(c1, 0);
        c4.acceptCoin(c1, 0);
        Coin c2 = new Coin("o");
        Bot b = new Bot("bot", c2);
        Assertions.assertEquals(0,b.getMove("17171"));
    }

    @Test
    void getMovePositiveTest() {
        C4Board c4 = new C4Board();
        Coin c1 = new Coin("x");
        c4.acceptCoin(c1, 0);
        c4.acceptCoin(c1, 0);
        Coin c2 = new Coin("o");
        c4.acceptCoin(c2, 5);
        Bot b = new Bot("bot", c2);
        Assertions.assertEquals(3,b.getMove("171"));
    }

    @Test
    void getMoveZeroTest() {
        C4Board c4 = new C4Board();
        Coin c1 = new Coin("x");
        c4.acceptCoin(c1, 0);
        c4.acceptCoin(c1, 0);
        Coin c2 = new Coin("o");
        c4.acceptCoin(c2, 5);
        c4.acceptCoin(c2, 1);
        Bot b = new Bot("bot", c2);
        Assertions.assertEquals(1,b.getMove("17124"));
    }
}

