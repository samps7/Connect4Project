package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class CoinTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void getLetterTest() {
        Coin c = new Coin("x");
        String check = "x";
        String actual = c.getLetter();
        Assertions.assertEquals(check, actual);
    }

    @Test
    void coinEqualsTrueTest() {
        Coin c1 = new Coin("x");
        Coin c2 = new Coin("x");
        Boolean actual = true;
        Assertions.assertEquals(c1.equals(c2), actual);
    }

    @Test
    void coinEqualsFalseTest() {
        Coin c1 = new Coin("x");
        Coin c2 = new Coin("y");
        Boolean actual = false;
        Assertions.assertEquals(c1.equals(c2), actual);
    }
}
