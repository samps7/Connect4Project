package edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class PlayerTest {


    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void getNameTest() {
        Coin c = new Coin("x");
        Player p = new Player("Ian", c);
        String check = "Ian";
        String actual = p.getName();
        Assertions.assertEquals(check, actual);
    }

    @Test
    void getCoinTest() {
        Coin c = new Coin("x");
        Player p = new Player("Ian", c);
        String checkCoin = "x";
        String actual = p1.getCoin().getLetter();
        Assertions.assertEquals(check, actual);
    }
}
