package edu.gonzaga;

// import java.util.ArrayList;

public class Player 
{
    private String name;
    private Coin coin;

    public Player(String name1, Coin c1)
    {
        name = name1;
        coin = c1;
    }

    public String getName()
    {
        return name;
    }

    public Coin getCoin()
    {
        return new Coin(coin);
    }
    
}
