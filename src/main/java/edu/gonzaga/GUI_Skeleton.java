package edu.gonzaga;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * TODO: Change the JButtons to JLabels and make them clickable
 */
public class GUI_Skeleton extends JFrame
{
    //At the moment focusing on the home screen
    JFrame mainWindow;
    JPanel titlePanel;
    JPanel gameModeSelectPanel;


    public static void main(String[] args)
    {
        GUI_Skeleton app = new GUI_Skeleton();
        app.runGUI();
    }
    void runGUI()
    {
        System.out.println("Starting GUI Connect4");
        setupGUI();

        this.mainWindow.setVisible(true);
        System.out.println("Done in GUI app");
    }

    void setupGUI()
    {
        this.mainWindow = new JFrame("Connect4");
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWindow.setSize(400,400);
        this.mainWindow.setLocation(100,100);

        this.titlePanel = new JPanel();
        this.gameModeSelectPanel = new JPanel();

        this.titlePanel = getTitlePanel();
        this.mainWindow.add(this.titlePanel);
    }

    //Ideally this gives us the main screen.
    //Doing this allows us the ability to turn off its visibility once
    //  the player has made their decision
    private JPanel getTitlePanel()
    {
        JPanel newTitlePanel = new JPanel();
        JLabel gameTitle =  new JLabel("Connect4");
        JLabel onePlayer = new JLabel("One Player");
        JLabel twoPlayer = new JLabel("Two Player");

        //Adding mouse listener to make the JLabel clickable
        onePlayer.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //Place holder for the actual part that would be going to the next page
                onePlayer.setText("Starting One Player Game");
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                //Place holder for the actual part that would be going to the next page
                onePlayer.setText("Starting One Player Game");
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        //Added mouse listener to make the JLabel Clickable
        twoPlayer.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //Place holder for the actual part that would be going to the next page
                twoPlayer.setText("Starting One Player Game");
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                //Place holder for the actual part that would be going to the next page
                twoPlayer.setText("Starting One Player Game");
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
        newTitlePanel.add(gameTitle);
        newTitlePanel.add(onePlayer);
        newTitlePanel.add(twoPlayer);

        return newTitlePanel;
    }
}
