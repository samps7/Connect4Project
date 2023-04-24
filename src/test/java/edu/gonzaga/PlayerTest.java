package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class PlayerTest {


    @Test
    void createPlayerTest() {
        Coin c = new Coin("x");
        Player p = new Player("Ian", c);
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
        String actual = p.getCoin().getLetter();
        Assertions.assertEquals(checkCoin, actual);
    }

    @Test
    void getMoveTest() {
        Coin c = new Coin("x");
        Player p = new Player("Ian", c);
        Integer check = -2;
        Integer actual = p.getMove(p.getCoin().getLetter());
        Assertions.assertEquals(check, actual);
    }
}
