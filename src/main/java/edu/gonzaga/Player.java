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

    /**
     * The function returns the name.
     * 
     * @return The method `getName()` is returning the value of the `name` variable, which is a
     * `String`.
     */
    public String getName()
    {
        return name;
    }

    /**
     * The function "getMove" in Java returns -2.
     * 
     * @param s The parameter "s" is a String that represents the current state of the game board or
     * the game itself. 
     * @return The method is returning the integer value of -2.
     */
    public int getMove(String s)
    {
        return -2;
    }

    /**
     * The function returns a new instance of the Coin object.
     * 
     * @return A new instance of the Coin class with the same value as the instance variable "coin".
     */
    public Coin getCoin()
    {
        return new Coin(coin);
    }
    
}
