package edu.gonzaga;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class GUI_Skeleton extends JFrame
{
    JFrame mainWindow;
    JLayeredPane gameModeSelectPane;
    JLayeredPane playerOneCustomizationPane;
    JLayeredPane twoPlayerCustomizationPane;
    JLayeredPane titlePane;
    JLayeredPane gamePane;

    private C4Game game;
    private Integer turn = 0;
    private Integer oneCount = 6, twoCount = 6, threeCount = 6, fourCount = 6, fiveCount = 6, sixCount = 6, sevenCount = 6;
    private JLabel[] buttons;
    private String playerOneName, playerTwoName;
    private int gameMode = -1, difficulty = -1;
    private final Color botColor = Color.orange;
    private Color player1Color, player2Color;
    private Color player1Hover, player2Hover;
    private String background_image_path;
    private final String ez_bg = "resources/img/easybot.gif";
    private String medium_bg, hard_bg, pvp_bg;
    MessageBean mBean = new MessageBean();


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

                mBean.setValue("0");
                gameMode = 0;

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

                mBean.setValue("1");
                gameMode = 1;

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
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow"};
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

                mBean.setValue(playerOneInput.getText());

                playerOneName = playerOneInput.getText();
                setPlayer1Color(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                setPlayer1Hover(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                player2Color = botColor;

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
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow"};
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

                mBean.setValue(playerOneInput.getText());

                playerOneName = playerOneInput.getText();
                playerTwoName = playerTwoInput.getText();

                setBackground_image_path(-1); //-1 forces to default case, which is the pvp background

                setPlayer1Color(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                setPlayer1Hover(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                setPlayer2Color(Objects.requireNonNull(playerTwoChoices.getSelectedItem()).toString());
                setPlayer2Hover(Objects.requireNonNull(playerTwoChoices.getSelectedItem()).toString());


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

                difficulty = 0;
                setBackground_image_path(difficulty);

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

                difficulty = 1;
                setBackground_image_path(difficulty);
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
                difficulty = 2;
                setBackground_image_path(difficulty);
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
        containedPanel.setBackground(new Color(0,0,0,0));
        ImageIcon background_Theme = new ImageIcon(new ImageIcon(ez_bg).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
        JLabel background = new JLabel(background_Theme);
        background.setBounds(0,0,600,600);



        int cols = 7, rows = 6, counter = 0;
        this.buttons = new JLabel[42];
        for(int i = 0; i<42; i++)
        {
            buttons[i] = new JLabel();
            //buttons[i].setText(String.valueOf(counter));
            buttons[i].setOpaque(true);
            buttons[i].setBackground(new Color(0,0,0,0));

            int finalCounter = counter;
            counter++;
            int finalI = i;

            buttons[i].addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {

                    System.out.println("Column located: " + getCol_Located(finalCounter));
                    if(finalI%7==0 && oneCount>0)
                        oneClicked();
                    if(finalI%7==1 && twoCount>0)
                        twoClicked();
                    if(finalI%7==2 && threeCount>0)
                        threeClicked();
                    if(finalI%7==3 && fourCount>0)
                        fourClicked();
                    if(finalI%7==4 && fiveCount>0)
                        fiveClicked();
                    if(finalI%7==5 && sixCount>0)
                        sixClicked();
                    if(finalI%7==6 && sevenCount>0)
                        sevenClicked();
                    turn++;
                    ImageIcon image  = new ImageIcon(new ImageIcon("resources/img/Connect4Board.png").getImage().getScaledInstance(490, 490, Image.SCALE_DEFAULT));
                    JLabel grid = new JLabel(image);

                    grid.setBounds(25,25,400,400);

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
                    if(finalI%7==0 && oneCount>0)
                        oneHovered();
                    if(finalI%7==1 && twoCount>0)
                        twoHovered();
                    if(finalI%7==2 && threeCount>0)
                        threeHovered();
                    if(finalI%7==3 && fourCount>0)
                        fourHovered();
                    if(finalI%7==4 && fiveCount>0)
                        fiveHovered();
                    if(finalI%7==5 && sixCount>0)
                        sixHovered();
                    if(finalI%7==6 && sevenCount>0)
                        sevenHovered();
                }

                @Override
                public void mouseExited(MouseEvent e)
                {
                    if(finalI%7==0 && oneCount>0)
                        oneUnHovered();
                    if(finalI%7==1 && twoCount>0)
                        twoUnHovered();
                    if(finalI%7==2 && threeCount>0)
                        threeUnHovered();
                    if(finalI%7==3 && fourCount>0)
                        fourUnHovered();
                    if(finalI%7==4 && fiveCount>0)
                        fiveUnHovered();
                    if(finalI%7==5 && sixCount>0)
                        sixUnHovered();
                    if(finalI%7==6 && sevenCount>0)
                        sevenUnHovered();
                }
            });

            containedPanel.add(buttons[i]);
        }

        containedPanel.setLayout(new GridLayout(rows, cols));
        containedPanel.setBounds(25,25,400,400);

        //containedPanel.setVisible(false);

        ImageIcon image  = new ImageIcon(new ImageIcon("resources/img/Connect4Board.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        JLabel grid = new JLabel(image);

        grid.setBounds(25,25,400,400);
        //grid.setOpaque(true);

        background.setBounds(0,0,600,600);

        gamePane.add(background,0);
        gamePane.add(containedPanel, Integer.valueOf(1));
        gamePane.add(grid, Integer.valueOf(2));

        gamePane.setLayout(null);
        return gamePane;
    }

    public void setC4Game(C4Game game)
    {
        this.game = game;
    }

    private int getCol_Located(int panelNum)
    {
        return panelNum % 7;
    }

    private void oneClicked()
    {
        if(turn%2==0)
            this.buttons[oneCount*7 - (7)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[oneCount*7 - (7)].setBackground(player2Color);
        oneCount--;
    }

    private void twoClicked()
    {
        if(turn%2==0)
            this.buttons[twoCount*7 - (6)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[twoCount*7 - (6)].setBackground(player2Color);
        twoCount--;
    }

    private void threeClicked()
    {
        if(turn%2==0)
            this.buttons[threeCount*7 - (5)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[threeCount*7 - (5)].setBackground(player2Color);
        threeCount--;
    }

    private void fourClicked()
    {
        if(turn%2==0)
            this.buttons[fourCount*7 - (4)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[fourCount*7 - (4)].setBackground(player2Color);
        fourCount--;
    }

    private void fiveClicked()
    {
        if(turn%2==0)
            this.buttons[fiveCount*7 - (3)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[fiveCount*7 - (3)].setBackground(player2Color);
        fiveCount--;
    }

    private void sixClicked()
    {
        if(turn%2==0)
            this.buttons[sixCount*7 - (2)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[sixCount*7 - (2)].setBackground(player2Color);
        sixCount--;
    }

    private void sevenClicked()
    {
        if(turn%2==0)
            this.buttons[sevenCount*7 - (1)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[sevenCount*7 - (1)].setBackground(player2Color);
        sevenCount--;
    }

    public String getPlayerOneName()
    {
        return this.playerOneName;
    }

    public String getPlayerTwoName()
    {
        return this.playerTwoName;
    }

    //Here is the url for the grid
    //https://studio.code.org/v3/assets/qOrtceIfe4F4g3q5NDoLfm0GYaN2iuIJL0rN4cA_-hY/Connect4Board.png

    private void oneHovered()
    {
        if(turn%2 == 0)
            this.buttons[oneCount*7 - (7)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[oneCount*7 - (7)].setBackground(this.player2Hover);
        this.buttons[oneCount*7 - 7].setOpaque(true);
    }

    private void oneUnHovered()
    {
        this.buttons[oneCount*7 - 7].setOpaque(false);
    }

    private void twoHovered()
    {
        if(turn%2==0)
            this.buttons[twoCount*7 - (6)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[twoCount*7 - (6)].setBackground(this.player2Hover);
        this.buttons[twoCount*7 - (6)].setOpaque(true);
    }

    private void twoUnHovered()
    {
        this.buttons[twoCount*7 - (6)].setOpaque(false);
    }

    private void threeHovered()
    {
        if(turn%2==0)
            this.buttons[threeCount*7 - (5)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[threeCount*7 - (5)].setBackground(this.player2Hover);
        this.buttons[threeCount*7 - (5)].setOpaque(true);
    }

    private void threeUnHovered()
    {
        this.buttons[threeCount*7 - (5)].setOpaque(false);
    }

    private void fourHovered()
    {
        if(turn%2==0)
            this.buttons[fourCount*7 - (4)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[fourCount*7 - (4)].setBackground(this.player2Hover);
        this.buttons[fourCount*7 - (4)].setOpaque(true);
    }

    private void fourUnHovered()
    {
        this.buttons[fourCount*7 - (4)].setOpaque(false);
    }

    private void fiveHovered()
    {
        if(turn%2==0)
            this.buttons[fiveCount*7 - (3)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[fiveCount*7 - (3)].setBackground(this.player2Hover);
        this.buttons[fiveCount*7 - (3)].setOpaque(true);
    }

    private void fiveUnHovered()
    {
        this.buttons[fiveCount*7 - (3)].setOpaque(false);
    }

    private void sixHovered()
    {
        if(turn%2==0)
            this.buttons[sixCount*7 - (2)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[sixCount*7 - (2)].setBackground(this.player2Hover);
        this.buttons[sixCount*7 - (2)].setOpaque(true);
    }

    private void sixUnHovered()
    {
        this.buttons[sixCount*7 - (2)].setOpaque(false);
    }

    private void sevenHovered()
    {
        if(turn%2==0)
            this.buttons[sevenCount*7 - (1)].setBackground(this.player1Hover);
        if(turn%2==1)
            this.buttons[sevenCount*7 - (1)].setBackground(this.player2Hover);
        this.buttons[sevenCount*7 - (1)].setOpaque(true);
    }

    private void sevenUnHovered()
    {
        this.buttons[sevenCount*7 - (1)].setOpaque(false);
    }

    public int getGameMode()
    {
        return this.gameMode;
    }

    public int getDifficulty()
    {
        return this.difficulty;
    }

    private void resetGame()
    {
        this.turn = 0;
        this.oneCount = 6;
        this.twoCount = 6;
        this.threeCount = 6;
        this.fourCount = 6;
        this.fiveCount = 6;
        this.sixCount = 6;
        this.sevenCount = 6;

    }

    private void setPlayer1Color(String color)
    {
        //"Green", "Blue", "Red", "Purple", "Black", "Yellow"
        switch (color)
        {
            case "Yellow":
                this.player1Color = Color.yellow;
                break;
            case "Black":
                this.player1Color = Color.black;
                break;
            case "Purple":
                this.player1Color = new Color(128, 0, 128);
                break;
            case "Red":
                this.player1Color = Color.red;
                break;
            case "Blue":
                this.player1Color = Color.BLUE;
                break;
            default:
                this.player1Color = Color.green;
                break;
        }

    }

    private void setPlayer2Color(String color)
    {
        //"Green", "Blue", "Red", "Purple", "Black", "Yellow"
        switch (color)
        {
            case "Yellow":
                this.player2Color = Color.yellow;
                break;
            case "Black":
                this.player2Color = Color.black;
                break;
            case "Purple":
                this.player2Color = new Color(128, 0, 128);
                break;
            case "Red":
                this.player2Color = Color.red;
                break;
            case "Blue":
                this.player2Color = Color.BLUE;
                break;
            default:
                this.player2Color = Color.green;
                break;
        }

    }

    private void setPlayer1Hover(String color)
    {
        switch (color)
        {
            case "Yellow":
                this.player1Hover = new Color(255, 255, 0, 128);
                break;
            case "Black":
                this.player1Hover = new Color(105,105,105,128);
                break;
            case "Purple":
                this.player1Hover = new Color(128, 0, 128,128);
                break;
            case "Red":
                this.player1Hover = new Color(255,0,0,128);
                break;
            case "Blue":
                this.player1Hover = new Color(0,0,255,128);
                break;
            default:
                this.player1Hover = new Color(0,255,0,128);
                break;
        }
    }

    private void setPlayer2Hover(String color)
    {
        switch (color)
        {
            case "Yellow":
                this.player2Hover = new Color(255, 255, 0, 128);
                break;
            case "Black":
                this.player2Hover = new Color(105,105,105,128);
                break;
            case "Purple":
                this.player2Hover = new Color(128, 0, 128,128);
                break;
            case "Red":
                this.player2Hover = new Color(255,0,0,128);
                break;
            case "Blue":
                this.player2Hover = new Color(0,0,255,128);
                break;
            default:
                this.player2Hover = new Color(0,255,0,128);
                break;
        }
    }

    private void setBackground_image_path(int mode)
    {
        if(mode == 0)
            this.background_image_path = this.ez_bg;
        else
            this.background_image_path = this.ez_bg;
    }

    private String getBackground_image_path()
    {
        return this.background_image_path;
    }
}