/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors:
 * Samuel Sovi
 * Ian Myers
 * Connor Jones
 * 
 * Copyright: 2023
 */
package edu.gonzaga;


/** Main program class for launching your team's program. */
public class MainGame 
{
    public static void main(String[] args) throws Exception
    {
        // Your code here. Good luck!
        MusicPlayer mp = new MusicPlayer();
        mp.loopSound("resources/music/Botique.wav");
        Menu m1 = new Menu(mp);
        m1.displayOptions();
    }
}
