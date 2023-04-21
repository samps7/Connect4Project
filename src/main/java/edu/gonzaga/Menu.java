package edu.gonzaga;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Menu 
{
    public void displayOptions()
    {
        int playing = 1;
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Type 0 for Bot Match | Type 1 for PVP | Type 2 to Quit");
        int mode = scan1.nextInt();
        if(mode == 1)
        {
            C4Game game = new C4Game(3);
            
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
            else if(mode == 1)
            {
                // medium bots stuff here

                //C4Game game = new C4Game(1);
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
}
