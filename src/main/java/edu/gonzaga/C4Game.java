package edu.gonzaga;

import java.util.Scanner;

public class C4Game 
{
    private Player p1;
    private Player p2;
    private int mode; // 0 = ez bot, 1 = medium bot, 2 = hard bot, 3 = pvp
    private int moveCount = 0; // for while loop
    private boolean p1Win = false;
    private boolean p2Win = false;


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
            p1 = new Player(scan1.nextLine(), new Coin("1"));
            

            System.out.println("Enter P2 name");
            // get name from UI textbox here
            // get coin from combobox here
            p2 = new Player(scan1.nextLine(), new Coin("2"));
            
        }
        else
        {
            System.out.println("Enter P1 name");
            // get from UI textbox here
            // get coin from combobox here
            p1 = new Player(scan1.nextLine(), new Coin("1"));

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
        //Coin flip for who starts

        while(!p1Win && !p2Win && moveCount < 42)
        {
            

            moveCount++;
        }
    }


}
