package edu.gonzaga;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI_Skeleton extends JFrame
{
    JFrame mainWindow;
    JPanel gameModeSelectPanel;
    JPanel playerOneCustomizationScreen;
    JPanel twoPlayerCustomizationScreen;
    JLayeredPane titlePane;

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
        this.mainWindow.setSize(600,500);
        this.mainWindow.setLocation(100,100);

        this.titlePane = getTitlePane();
        this.gameModeSelectPanel = new JPanel();
        this.playerOneCustomizationScreen = new JPanel();
        this.playerOneCustomizationScreen.setVisible(false);
        this.twoPlayerCustomizationScreen = new JPanel();
        this.twoPlayerCustomizationScreen.setVisible(false);


        this.playerOneCustomizationScreen = getOnePlayerCustomizeScreen();
        this.twoPlayerCustomizationScreen = getTwoPlayerCustomizationScreen();
        this.mainWindow.add(this.titlePane);
    }

    //Ideally this gives us the main screen.
    //Doing this allows us the ability to turn off its visibility once
    //  the player has made their decision
    private JLayeredPane getTitlePane()
    {
        JLayeredPane newPane = new JLayeredPane();
        JLabel gameTitle =  new JLabel("Connect4");
        JLabel onePlayer = new JLabel("One Player");
        JLabel twoPlayer = new JLabel("Two Player");

        //Adding mouse listener to make the JLabel clickable
        onePlayer.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //placeholder for the actual part that would be going to the next page
                onePlayer.setText("Starting One Player Game");
                titlePane.setVisible(false);
                mainWindow.add(playerOneCustomizationScreen);

            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

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
                //placeholder for the actual part that would be going to the next page
                twoPlayer.setText("Starting Two Player Game");
                titlePane.setVisible(false);
                mainWindow.add(twoPlayerCustomizationScreen);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

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
        gameTitle.setBounds(250,50,125,75);
        onePlayer.setBounds(75,250,175,25);
        twoPlayer.setBounds(350,250,175,25);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        onePlayer.setBorder(border);
        twoPlayer.setBorder(border);
        newPane.add(gameTitle);
        newPane.add(onePlayer);
        newPane.add(twoPlayer);

        newPane.setLayout(null);
        return newPane;
    }

    private JPanel getOnePlayerCustomizeScreen()
    {
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow", "Orange"};
        JPanel newPanel = new JPanel();
        JLabel playerOne = new JLabel("Player One Name: ");
        JLabel playerOneColor = new JLabel("Color: ");
        final JComboBox<String> playerChoices = new JComboBox<>(colorChoices);
        JTextField playerOneInput = new JTextField(16);
        JLabel startGame = new JLabel("Start Game");
        startGame.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Player Name set to: " + playerOneInput.getText());
                System.out.println("Player color set to: " + playerChoices.getSelectedItem());
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

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

        playerOne.setBounds(75,150,175,25);
        playerOneInput.setBounds(250,150,175,25);
        playerOneColor.setBounds(75,250,175,25);
        playerChoices.setBounds(250,250,175,25);
        startGame.setBounds(250,400,175,25);

        newPanel.add(playerOne);
        newPanel.add(playerOneInput);
        newPanel.add(playerOneColor);
        newPanel.add(playerChoices);
        newPanel.add(startGame);


        newPanel.setLayout(null);
        return newPanel;
    }

    private JPanel getTwoPlayerCustomizationScreen()
    {
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow", "Orange"};
        JPanel newPanel = new JPanel();
        //Player 1
        JLabel playerOne = new JLabel("Player One Name: ");
        JLabel playerOneColor = new JLabel("Color: ");
        final JComboBox<String> playerChoices = new JComboBox<>(colorChoices);
        JTextField playerOneInput = new JTextField(16);
        //Player 2
        JLabel playerTwo = new JLabel("Player Two Name: ");
        JLabel playerTwoColor = new JLabel("Color: ");
        final JComboBox<String> playerTwoChoices = new JComboBox<>(colorChoices);
        JTextField playerTwoInput = new JTextField(16);
        JLabel startGame = new JLabel("Start Game");
        startGame.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Player One Name: " + playerOneInput.getText());
                System.out.println("Player One Color: " + playerChoices.getSelectedItem());
                System.out.println("Player Two Name: " + playerTwoInput.getText());
                System.out.println("Player Two Color: " + playerTwoChoices.getSelectedItem());
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

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

        playerOne.setBounds(25,75,125,25);
        playerOneInput.setBounds(155,75,125,25);
        playerOneColor.setBounds(25,100,50,25);
        playerChoices.setBounds(80,100,125,25);

        playerTwo.setBounds(300,75,125,25);
        playerTwoInput.setBounds(430,75,125,25);
        playerTwoColor.setBounds(300,100,50,25);
        playerTwoChoices.setBounds(355,100,125,25);

        startGame.setBounds(250,400,175,25);

        newPanel.add(playerOne);
        newPanel.add(playerOneInput);
        newPanel.add(playerOneColor);
        newPanel.add(playerChoices);

        newPanel.add(playerTwo);
        newPanel.add(playerTwoInput);
        newPanel.add(playerTwoColor);
        newPanel.add(playerTwoChoices);

        newPanel.add(startGame);


        newPanel.setLayout(null);
        return newPanel;
    }

}
