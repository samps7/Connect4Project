package edu.gonzaga;
import javax.swing.*;

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
        gameTitle.setBounds(200,75,100,50);
        JButton onePlayer = new JButton("One-Player");
        onePlayer.setBounds(100,150,50,25);
        JButton twoPlayer = new JButton("Two-Player");
        twoPlayer.setBounds(250,150,50,25);

        newTitlePanel.add(gameTitle);
        newTitlePanel.add(onePlayer);
        newTitlePanel.add(twoPlayer);

        return newTitlePanel;
    }
}
