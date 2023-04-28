package edu.gonzaga;

import java.util.Scanner;

import org.apache.xalan.templates.ElemSort;

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

    private MusicPlayer mp;



    public C4Game(int mode1, MusicPlayer mp1,GUI_Skeleton gui1)
    {
        gui = gui1;
        mode = mode1;
        Scanner scan1 = new Scanner(System.in);
        mp = mp1;
        //note, we will have some code duplication here (since 2p will have different screen)

        if(mode == 3)
        {
            // 2 player mode
            System.out.println("Enter P1 name");
            // get name from UI textbox here
            // get coin from combobox here

            while(true)
            {
                if(gui.getPlayerOneName() == null && gui.getPlayerTwoName() == null)
                {
                    System.out.println("Player One Name Blank");
                    System.out.println("Player Two Name Blank");
                }
                else if(gui.getPlayerOneName() != null && gui.getPlayerTwoName() != null)
                {
                    System.out.println("Waiting on names");
                    break;
                }
                else
                {
                    System.out.println("Here are the names");
                    System.out.println(gui.getPlayerOneName());
                    System.out.println(gui.getPlayerTwoName());
                }
            }
            players[0] = new Player(gui.getPlayerOneName(), new Coin("X"));

            //System.out.println("Enter P2 name");
            // get name from UI textbox here
            // get coin from combobox here
            players[1] = new Player(gui.getPlayerTwoName(), new Coin("O"));

        }
        else
        {
            System.out.println("Enter P1 name");
            // get from UI textbox here
            // get coin from combobox here
            while(true)
            {
                if(gui.getPlayerOneName() != null)
                {
                    System.out.println("Player 1 Name: " + gui.getPlayerOneName());
                    break;
                }
                else
                    System.out.println("Waiting on player 1 name");
            }
            players[0] = new Player(gui.getPlayerOneName(), new Coin("X"));

            if(mode == 0)
            {
                players[1] = new WorstBot("Easy Bot", new Coin("0"));
            }
            else if(mode == 1)
            {
                players[1] = new BadBot("Medium Bot", new Coin("0"));
            }
            else if(mode == 2)
            {
                players[1] = new Bot("Hard Bot", new Coin("0"));
            }
        }
    }

    public void startGame() throws Exception
    {
        Scanner scan1 = new Scanner(System.in); // remove this once UI working
        C4Board grid = new C4Board();

        //modifiers applied here (will be used in 1P games)
        if(mode == 0)
        {
            // intro ez bot if needed
            mp.loopSound("resources/music/Bramble.wav");
        }
        else if(mode == 1)
        {
            // intro med bot if needed
            mp.loopSound("resources/music/Castle.wav");
        }
        else if(mode == 2)
        {
            // intro hard bot if needed
            mp.loopSound("resources/music/Zen.wav");
        }
        else
        {
            mp.loopSound("resources/music/PVP.wav");
        }

        //Coin flip for who starts
        playerTurn = (int) Math.random()*2;
        if(mode < 3)
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
                while(true)
                {
                    if(gui.getMove()>0 && gui.getMove()<7)
                        break;
                    else
                        System.out.println("Waiting for move");
                }
                int currMove = gui.getMove();
                boolean valid = grid.acceptCoin(players[playerTurn].getCoin(), currMove);
                while(!valid)
                {
                    System.out.println("invalid  column");
                    while(true)
                    {
                        if(gui.getMove()>0 && gui.getMove()<7)
                            break;
                        else
                            System.out.println("Waiting for move");
                    }
                    currMove = gui.getMove();
                    valid = grid.acceptCoin(players[playerTurn].getCoin(), currMove);
                }
                currMove++; // change from 0-6 -> 1-7 (for moveChain)
                moveChain += currMove;

                gui.resetMoveInt();
            }
            else
            {
                System.out.println("Bot is deciding on a move...");
                if(mode < 3)
                {

                    int currMove =  players[1].getMove(moveChain);

                    System.out.println("Bot went " + currMove);
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
                    mp.loopSound("resources/music/Results.wav");
                    
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
                    mp.loopSound("resources/music/Results.wav");

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
            if(mode == 2)
            {
                System.out.println("Hard Bot Wins By Draw");
            }
            else
            {
                System.out.println("Game Resulted In A Draw");
            }
            
        }

        // soft reset for playing again
        moveChain = "";
        moveCount = 0;
    }


}
