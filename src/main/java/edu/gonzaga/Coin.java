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

    /**
     * The function returns a string representing a coin letter.
     * 
     * @return The method is returning a String value which is stored in the variable `coinLetter`.
     */
    public String getLetter()
    {
        return coinLetter;
    }

    /**
     * This Java function checks if a given coin object has the same letter as the current coin object.
     * 
     * @param c2 The parameter `c2` is an object of the `Coin` class that is being compared to the
     * current object.
     * @return The method is returning a boolean value. If the letter of the coin passed as a parameter
     * is equal to the letter of the current coin object, then the method returns true. Otherwise, it
     * returns false.
     */
    public boolean equals(Coin c2)
    {
        if(c2.getLetter() == coinLetter)
        {
            return true;
        }
        return false;
    }
}
