package edu.gonzaga;

import java.io.*;
import java.util.Scanner;


public class Menu 
{
    GUI_Skeleton gui = new GUI_Skeleton();
    MessageBean mBean = new MessageBean();

    //Sam's original Text-based C4 game
    public void displayOptions() throws IOException
    {
        gui.runGUI();
        int playing = 1;
        Scanner scan1 = new Scanner(System.in);


        System.out.println("Type 0 for Bot Match | Type 1 for PVP | Type 2 to Quit");

        int mode = scan1.nextInt();
        /*
          Here lies our attempt to use BAOS
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  PrintStream old = System.out;
                  System.setOut(ps);
                  System.out.println("0");
                  System.out.flush();
                  System.setOut(old);
                  System.out.println("hi" + Integer.parseInt("" + baos.toString("UTF-8")));
                  int mode = Integer.parseInt(baos.toString());

         */
        //int mode = Integer.parseInt(mBean.getValue());
        System.out.println(mBean.getValue());
        if(mode == 1)
        {
            C4Game game = new C4Game(3);
            gui.setC4Game(game);
            while(playing == 1)
            {
                game.startGame();
                System.out.println("");
                System.out.println("Play again?");
                System.out.println("0: Main Menu | 1: Play Again");
                playing = scan1.nextInt();
            }
            displayOptions();
        }
        else if( mode == 0)
        {
            System.out.println("Type 0 for Easy | Type 1 for Medium | Type 2 for Hard");
            mode = scan1.nextInt();
            if(mode == 0)
            {
                // easy bots stuff here

                C4Game game = new C4Game(0);
                gui.setC4Game(game);
                while(playing == 1)
                {
                    //game.startGame();
                    System.out.println("");
                    System.out.println("Play again?");
                    System.out.println("0: Main Menu | 1: Play Again");
                    playing = scan1.nextInt();
                }
                displayOptions();
            }
            else if(mode == 1)
            {
                // medium bots stuff here

                C4Game game = new C4Game(1);
                gui.setC4Game(game);
                while(playing == 1)
                {
                    //game.startGame();
                    System.out.println("");
                    System.out.println("Play again?");
                    System.out.println("0: Main Menu | 1: Play Again");
                    playing = scan1.nextInt();
                }
                displayOptions();
            }
            else if(mode == 2)
            {
                // hard bots stuff here

                C4Game game = new C4Game(2);
                gui.setC4Game(game);
                while(playing == 1)
                {
                    game.startGame();
                    System.out.println("");
                    System.out.println("Play again?");
                    System.out.println("0: Main Menu | 1: Play Again");
                    playing = scan1.nextInt();
                }
                displayOptions();
            }
        }
    }
    //End of Sam's original Text-Based C4 game



}
