package edu.gonzaga;

import java.util.Scanner;


public class Menu 
{
    //Setting up the game and making private member variables
    //  to start to make the game based around the GUI instead
    //  of the command line
    C4Game theGame;
    private int gameMode, playAgain, difficultySelect;
    private String[] playerName;

    //New function that will be called to begin the game once
    //  all of the variables have been given values
    //Most likely to be called when the player has hit the 'Start Game'
    //  or difficulty to start the game
    //Checks for PvP or PvE, then instantiates theGame getting a difficulty
    //  from getDifficultySelect()
    public void startGame()
    {
        if(getGameMode() == 1)
            this.theGame = new C4Game(3);
        else
            this.theGame = new C4Game(getDifficultySelect());
    }

    //Sam's original Text-based C4 game
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
    //End of Sam's original Text-Based C4 game


    //Getters and setters that will help with the integration of the game
    public void setGameMode(int numericGameMode)
    {
        //0 for PvE, 1 for PvP
        this.gameMode = numericGameMode;
    }

    public void setPlayAgain(int playAgain)
    {
        //0 for Quit, 1 for play again
        this.playAgain = playAgain;
    }

    public void setDifficulty(int difficulty)
    {
        //0 for Easy, 1 for Medium, 2 for Hard
        this.difficultySelect = difficulty;
    }

    public void setPlayerName(String name, int playerNumber)
    {
        //playerNumber = 0 for player1, playerNumber = 1 for player2
        this.playerName[playerNumber] = name;
    }

    private int getGameMode()
    {
        return this.gameMode;
    }

    private int getPlayAgain()
    {
        return this.playAgain;
    }

    private int getDifficultySelect()
    {
        return this.difficultySelect;
    }

    private String getPlayerName(int playerNumber)
    {
        return this.playerName[playerNumber];
    }



}
