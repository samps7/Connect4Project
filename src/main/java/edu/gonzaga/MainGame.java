/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors:
 * 
 * 
 * Copyright: 2023
 */
package edu.gonzaga;


/** Main program class for launching your team's program. */
public class MainGame 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello Team Game");
        // Your code here. Good luck!
        C4Game game = new C4Game(3); // note for UI: we will do this in a separate class
        game.startGame(); //note for UI: we will do this in a separate class
    }
}
