package edu.gonzaga;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI_Skeleton extends JFrame
{
    JFrame mainWindow;
    JLayeredPane gameModeSelectPane;
    JLayeredPane playerOneCustomizationPane;
    JLayeredPane twoPlayerCustomizationPane;
    JLayeredPane titlePane;
    JLayeredPane gamePane;

    String player1Name;
    String player2Name;


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
        this.gameModeSelectPane = new JLayeredPane();
        this.playerOneCustomizationPane = new JLayeredPane();
        this.playerOneCustomizationPane.setVisible(false);
        this.twoPlayerCustomizationPane = new JLayeredPane();
        this.twoPlayerCustomizationPane.setVisible(false);
        this.gameModeSelectPane = new JLayeredPane();
        this.gameModeSelectPane.setVisible(false);
        this.gamePane = new JLayeredPane();
        this.gamePane.setVisible(false);



        this.playerOneCustomizationPane = getOnePlayerCustomizePane();
        this.twoPlayerCustomizationPane = getTwoPlayerCustomizationPane();
        this.gameModeSelectPane = getGameModeSelectPane();
        this.gamePane = getGame();
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
                mainWindow.add(playerOneCustomizationPane);
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
                mainWindow.add(twoPlayerCustomizationPane);
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
        newPane.add(gameTitle,1);
        newPane.add(onePlayer,1);
        newPane.add(twoPlayer,1);

        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getOnePlayerCustomizePane()
    {
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow", "Orange"};
        JLayeredPane newPane = new JLayeredPane();
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

                playerOneCustomizationPane.setVisible(false);
                mainWindow.add(gameModeSelectPane);

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

        newPane.add(playerOne,1);
        newPane.add(playerOneInput,1);
        newPane.add(playerOneColor,1);
        newPane.add(playerChoices,1);
        newPane.add(startGame,1);


        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getTwoPlayerCustomizationPane()
    {
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow", "Orange"};
        JLayeredPane newPane = new JLayeredPane();
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

                twoPlayerCustomizationPane.setVisible(false);
                mainWindow.add(gamePane);
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

        newPane.add(playerOne,1);
        newPane.add(playerOneInput,1);
        newPane.add(playerOneColor,1);
        newPane.add(playerChoices,1);

        newPane.add(playerTwo,1);
        newPane.add(playerTwoInput,1);
        newPane.add(playerTwoColor,1);
        newPane.add(playerTwoChoices,1);

        newPane.add(startGame,1);


        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getGameModeSelectPane()
    {
        JLayeredPane newPane = new JLayeredPane();
        JLabel gameModeText = new JLabel("Select Game Mode");
        JLabel easy = new JLabel("Easy");
        JLabel medium = new JLabel("Medium");
        JLabel hard = new JLabel("Hard");

        easy.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Easy Mode Selected");
                gameModeSelectPane.setVisible(false);
                mainWindow.add(gamePane);
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

        medium.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Medium Mode Selected");
                gameModeSelectPane.setVisible(false);
                mainWindow.add(gamePane);
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

        hard.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Hard Mode Selected");
                gameModeSelectPane.setVisible(false);
                mainWindow.add(gamePane);
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

        gameModeText.setBounds(250,50,125,75);
        easy.setBounds(175,250,50,25);
        medium.setBounds(290,250,50,25);
        hard.setBounds(405,250,50,25);

        newPane.add(gameModeText,1);
        newPane.add(easy,1);
        newPane.add(medium,1);
        newPane.add(hard,1);

        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getGame()
    {
        JLayeredPane gamePane = new JLayeredPane();
        JPanel containedPanel = new JPanel();

        int cols = 7, rows = 6, counter = 0;
        JLabel[][] slots = new JLabel[cols][rows];

        for(int i = 0; i<cols; i++)
        {
            for(int k = 0; k<rows; k++)
            {
                slots[i][k] = new JLabel();
                slots[i][k].setText(String.valueOf(counter));

                int finalCounter = counter;
                counter++;

                slots[i][k].addMouseListener(new MouseListener()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        System.out.println("Clicked: " + finalCounter);
                        System.out.println(player1Name + " " + player2Name);
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

                slots[i][k].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1),
                        BorderFactory.createEmptyBorder(1,1,1,1)));
                containedPanel.add(slots[i][k]);
            }
        }

        containedPanel.setLayout(new GridLayout(rows, cols));
        containedPanel.setBounds(25,25,400,400);

        gamePane.add(containedPanel, 1);

        gamePane.setLayout(null);
        return gamePane;
    }

}
