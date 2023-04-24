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

    
}
