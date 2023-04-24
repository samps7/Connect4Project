package edu.gonzaga;

import java.util.Scanner;
import java.lang.Math;

public class C4Game
{
    private Player[] players = new Player[2];
    private int mode; // 0 = ez bot, 1 = medium bot, 2 = hard bot, 3 = pvp
    private int moveCount = 0; // for while loop
    private GUI_Skeleton gui;
    // these are here for bot matches mostly

    private int playerTurn = 1;

    private String moveChain = "";


    public C4Game(int mode1,GUI_Skeleton gui1)
    {
        gui = gui1;
        mode = mode1;
        Scanner scan1 = new Scanner(System.in);
        //note, we will have some code duplication here (since 2p will have different screen)

        if(mode == 3)
        {
            // 2 player mode
            System.out.println("Enter P1 name");
            // get name from UI textbox here
            // get coin from combobox here

            while(!gui.getPlayerOneName().isEmpty() && !gui.getPlayerTwoName().isEmpty())
            {

            }
            players[0] = new Player(gui.getPlayerOneName(), new Coin("X"));

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
                players[1] = new Bot("Hard Bot", new Coin("0"));
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
            // intro hard bot if needed
        }

        //Coin flip for who starts
        playerTurn = (int) Math.random()*2;
        if(mode == 2)
        {
            playerTurn = 0;
        }

        while(moveCount < 42)
        {
            System.out.println(players[playerTurn].getName() + "'s turn");

            System.out.println();
            System.out.println(grid.boardDisplay());
            System.out.println();


            if(playerTurn == 0 || mode > 2) // player 1 turn or pvp (player 2 turn) fix this...
            {
                System.out.println("Which column do you want to place a piece?");
                int currMove = scan1.nextInt();
                boolean valid = grid.acceptCoin(players[playerTurn].getCoin(), currMove);
                while(!valid)
                {
                    System.out.println("invalid  column");
                    currMove = scan1.nextInt();
                    valid = grid.acceptCoin(players[playerTurn].getCoin(), currMove);
                }
                currMove++; // change from 0-6 -> 1-7 (for moveChain)
                moveChain += currMove;

            }
            else
            {
                System.out.println("Bot is deciding on a move...");
                if(mode == 2)
                {

                    int currMove =  players[1].getMove(moveChain);

                    // check for illegal move before next line and
                    // exit to menu with ("bad connection to server") msg << UI here
                    grid.acceptCoin(players[playerTurn].getCoin(), currMove);
                    currMove++; // change from 0-6 -> 1-7 (for moveChain)
                    moveChain += currMove;
                }

            }
            System.out.println("movechain: " + moveChain);

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
                if(grid.checkWinner()) // <--- update winning board UI in here
                {

                    if(playerTurn == 0)
                    {
                        System.out.println("you win!");
                    }
                    else
                    {
                        System.out.println("you lose!");
                    }

                    System.out.println(grid.boardDisplay());

                    moveCount = 1000; // (to break from loop)
                }
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
        moveChain = "";
        moveCount = 0;
    }


}
