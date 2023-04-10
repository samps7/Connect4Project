package edu.gonzaga;

import java.util.Scanner;
import java.lang.Math;

public class C4Game 
{
    //private Player p1;
    //private Player p2;
    private Player[] players = new Player[2];
    private int mode; // 0 = ez bot, 1 = medium bot, 2 = hard bot, 3 = pvp
    private int moveCount = 0; // for while loop
    
    // these are here for bot matches mostly
    private boolean p1Win = false;
    private boolean p2Win = false;
    
    private int playerTurn = 1;


    public C4Game(int mode1)
    {
        mode = mode1;
        Scanner scan1 = new Scanner(System.in);
        //note, we will have some code duplication here (since 2p will have different screen)

        if(mode == 3)
        {
            // 2 player mode
            System.out.println("Enter P1 name");
            // get name from UI textbox here
            // get coin from combobox here
            players[0] = new Player(scan1.nextLine(), new Coin("X"));

            System.out.println("Enter P2 name");
            // get name from UI textbox here
            // get coin from combobox here
            players[1] = new Player(scan1.nextLine(), new Coin("O"));
            
        }
        else
        {
            System.out.println("Enter P1 name");
            // get from UI textbox here
            // get coin from combobox here
            players[0] = new Player(scan1.nextLine(), new Coin("X"));

            if(mode == 0)
            {
                // init ez bot here
            }
            else if(mode == 1)
            {
                // init med bot here
            }
            else if(mode == 2)
            {
                // init hard bot here
            }
        }
    }

    public void startGame()
    {
        Scanner scan1 = new Scanner(System.in); // remove this once UI working
        C4Board grid = new C4Board();

        //modifiers applied here (will be used in 1P games)
        if(mode == 0)
        {
            // intro ez bot if needed
        }
        else if(mode == 1)
        {
            // intro med bot if needed
        }
        else if(mode == 2)
        {
            // init hard bot if needed
        }
        
        //Coin flip for who starts
        playerTurn = (int) Math.random()*2;
        
        while(!p1Win && !p2Win && moveCount < 42)
        {
            System.out.println(players[playerTurn].getName() + "'s turn");

            System.out.println();
            System.out.println(grid.boardDisplay());
            System.out.println();
            System.out.println("Which column do you want to place a piece?");

            while(!grid.acceptCoin(players[playerTurn].getCoin(), scan1.nextInt()))
            {
                System.out.println("invalid  column");
            }

            if(mode == 3) // if pvp
            {
                if(grid.checkWinner()) // <--- update winning board UI in here
                {
                    System.out.println(players[playerTurn].getName()+ " wins!!!!");
                    System.out.println();
                    System.out.println(grid.boardDisplay());

                    moveCount = 1000; // (to break from loop)
                }
            }
            else // if bot match
            {
                //use p1win and p2win variables
            }

            playerTurn++;
            playerTurn = playerTurn % 2;

            moveCount++;
        }

        if(moveCount < 50)
        {
            System.out.println("Game Resulted In A Draw");
        }
       
        // soft reset for playing again
        moveCount = 0;
        p1Win = false;
        p2Win = false;
    }


}
