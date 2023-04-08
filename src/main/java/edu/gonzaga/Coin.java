package edu.gonzaga;

public class Coin 
{
    private String coinLetter; // for UI we will replace this with an image URL
    
    public Coin(String letter)
    {
        coinLetter = letter;
    }

    public Coin(Coin c1) // copy constructor (used by Players)
    {
        coinLetter = c1.getLetter(); 
    }

    public String getLetter()
    {
        return coinLetter;
    }
}
