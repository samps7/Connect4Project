package edu.gonzaga;

import java.io.*;
import java.util.Scanner;


public class Menu 
{
    GUI_Skeleton gui = new GUI_Skeleton();
    private MusicPlayer mp;

    public Menu(MusicPlayer mp1)
    {
        mp = mp1;
        gui.runGUI();
    }
    //Sam's original Text-based C4 game
    /**
     * This function displays options for the user to choose from, including game mode and difficulty,
     * and starts a Connect Four game based on the user's choices.
     */
    public void displayOptions() throws Exception
    {
        mp.loopSound("resources/music/Botique.wav");
        int playing = 1;
        Scanner scan1 = new Scanner(System.in);
        


        //System.out.println("Type 0 for Bot Match | Type 1 for PVP | Type 2 to Quit");

        while(true)
        {
            if(gui.getGameMode() == 0)
            {
                //System.out.println(gui.getGameMode());
                break;
            }
            else if(gui.getGameMode() == 1)
            {
                //System.out.println(gui.getGameMode());
                break;
            }
            else if(gui.getGameMode() == 2)
            {
                //System.out.println(gui.getGameMode());
                break;
            }
            else
                System.out.print("");
        }
        int mode = gui.getGameMode();

        if(mode == 1)
        {
            C4Game game = new C4Game(3, mp, gui);
            while(playing == 1)
            {
                gui.setC4Game(game);
                game.startGame();
                //System.out.println("");
                //System.out.println("Play again?");
                //System.out.println("0: Main Menu | 1: Play Again");
                //playing = scan1.nextInt();
                while(gui.getPlayAgainNum() == -1)
                {
                    System.out.print("");
                }
                playing = gui.getPlayAgainNum();
                if(playing == 1)
                {
                    gui.setC4Game(game);
                    gui.playAgain();
                }
            }
            gui.menuGUI();
            displayOptions();
        }
        else if( mode == 0)
        {
            //System.out.println("Type 0 for Easy | Type 1 for Medium | Type 2 for Hard");
            while(true)
            {
                if(gui.getDifficulty() == 0)
                {
                    //System.out.println(gui.getDifficulty());
                    break;
                }

                else if(gui.getDifficulty() == 1)
                {
                    //System.out.println(gui.getDifficulty());
                    break;
                }
                else if(gui.getDifficulty() == 2)
                {
                    //System.out.println(gui.getDifficulty());
                    break;
                }
                else
                    System.out.print("");
            }
            mode = gui.getDifficulty();
            if(mode == 0)
            {
                // easy bots stuff here

                C4Game game = new C4Game(0, mp, gui);
                
                
                while(playing == 1)
                {
                    gui.setC4Game(game);
                    game.startGame();
                    //System.out.println("");
                    //System.out.println("Play again?");
                    //System.out.println("0: Main Menu | 1: Play Again");
                    //playing = scan1.nextInt();
                    while(gui.getPlayAgainNum() == -1)
                    {
                        System.out.print("");
                    }
                    playing = gui.getPlayAgainNum();
                    if(playing == 1)
                    {
                        gui.setC4Game(game);
                        gui.playAgain();
                    }
                }
                gui.menuGUI();
                displayOptions();
            }
            else if(mode == 1)
            {
                // medium bots stuff here

                C4Game game = new C4Game(1, mp, gui);
                
                
                while(playing == 1)
                {
                    gui.setC4Game(game);
                    game.startGame();
                    //System.out.println("");
                    //System.out.println("Play again?");
                    //System.out.println("0: Main Menu | 1: Play Again");
                    //playing = scan1.nextInt();
                    while(gui.getPlayAgainNum() == -1)
                    {
                        System.out.print("");
                    }
                    playing = gui.getPlayAgainNum();
                    if(playing == 1)
                    {
                        gui.setC4Game(game);
                        gui.playAgain();
                    }
                }
                gui.menuGUI();
                displayOptions();
            }
            else if(mode == 2)
            {
                // hard bots stuff here


                C4Game game = new C4Game(2, mp, gui);
                
                while(playing == 1)
                {
                    gui.setC4Game(game);
                    game.startGame();
                    //System.out.println("");
                    //System.out.println("Play again?");
                    //System.out.println("0: Main Menu | 1: Play Again");
                    //playing = scan1.nextInt();
                    while(gui.getPlayAgainNum() == -1)
                    {
                        System.out.print("");
                    }
                    playing = gui.getPlayAgainNum();
                    if(playing == 1)
                    {
                        gui.setC4Game(game);
                        gui.playAgain();
                    }
                }
                gui.menuGUI();
                displayOptions();
                
            }
        }
    }
    //End of Sam's original Text-Based C4 game



}
