package edu.gonzaga;

import java.util.Scanner;
import java.lang.Math;

public class C4Game 
{
    private Player p1;
    private Player p2;
    private int mode; // 0 = ez bot, 1 = medium bot, 2 = hard bot, 3 = pvp
    private int moveCount = 0; // for while loop
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
            p1 = new Player(scan1.nextLine(), new Coin("X"));

            System.out.println("Enter P2 name");
            // get name from UI textbox here
            // get coin from combobox here
            p2 = new Player(scan1.nextLine(), new Coin("O"));
            
        }
        else
        {
            System.out.println("Enter P1 name");
            // get from UI textbox here
            // get coin from combobox here
            p1 = new Player(scan1.nextLine(), new Coin("X"));

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
            if(playerTurn == 0)
            {
                System.out.println(p1.getName() + "'s turn");
            }
            else
            {
                System.out.println(p2.getName() + "'s turn");
            }

            System.out.println();
            System.out.println(grid.boardDisplay());
            System.out.println();
            System.out.println("Which column do you want to place a piece?");

            if(playerTurn == 0)
            {
                while(!grid.acceptCoin(p1.getCoin(), scan1.nextInt()))
                {
                    System.out.println("invalid  column");
                }
            }
            else
            {
                while(!grid.acceptCoin(p2.getCoin(), scan1.nextInt()))
                {
                    System.out.println("invalid  column");
                }
            }
            playerTurn++;
            playerTurn = playerTurn % 2;

            moveCount++;
        }
    }


}
