package edu.gonzaga;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
//hello
public class GUI_Skeleton extends JFrame
{
    JFrame mainWindow;
    JLayeredPane gameModeSelectPane;
    JLayeredPane playerOneCustomizationPane;
    JLayeredPane twoPlayerCustomizationPane;
    JLayeredPane titlePane;
    JLayeredPane gamePane;
    JLayeredPane endPane;

    JLabel background;

    private C4Game game;
    private Integer turn = 0;
    private Integer oneCount = 6, twoCount = 6, threeCount = 6, fourCount = 6, fiveCount = 6, sixCount = 6, sevenCount = 6;
    private JLabel[] buttons;
    private String playerOneName, playerTwoName, winningPlayer;
    private int gameMode = -1, difficulty = -1;
    private final Color botColor = Color.orange;
    private Color player1Color, player2Color;
    private Color player1Hover, player2Hover;
    private final String ez_bg = "resources/img/easybot.gif";
    private final String med_bg = "resources/img/medbot.gif";
    private final String hard_bg = "resources/img/hardbot.gif";
    private final String pvp_bg = "resources/img/PVP.gif";
    private ImageIcon background_Theme_Used = new ImageIcon(new ImageIcon(pvp_bg).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
    private ImageIcon ez_background_Theme = new ImageIcon(new ImageIcon(ez_bg).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
    private ImageIcon med_background_Theme = new ImageIcon(new ImageIcon(med_bg).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
    private ImageIcon hard_background_Theme = new ImageIcon(new ImageIcon(hard_bg).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
    private int move = -1, botMove = -1;
    private boolean wait = false;



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
        this.mainWindow.setResizable(false);

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
        titlePane.setVisible(true);
        

    }

    void playAgain()
    {

        this.endPane.setVisible(false);
        wait = false;
        move = -1;
        botMove = -1;

        oneCount = 6;
        twoCount = 6;
        threeCount = 6;
        fourCount = 6;
        fiveCount = 6;
        sixCount = 6;
        sevenCount = 6;
        turn = 0;

        gamePane = getGame();
        mainWindow.add(gamePane);
        gamePane.setVisible(true);

        this.mainWindow.repaint();
        this.mainWindow.revalidate();
    }

    void menuGUI()
    {
        this.endPane.setVisible(false);
        playerOneName = null;
        playerTwoName = null;
        wait = false;
        move = -1;
        botMove = -1;
        gameMode = -1;
        difficulty = -1;

        oneCount = 6;
        twoCount = 6;
        threeCount = 6;
        fourCount = 6;
        fiveCount = 6;
        sixCount = 6;
        sevenCount = 6;
        turn = 0;

        System.out.println("Restarting GUI");

        this.titlePane = getTitlePane();
        this.mainWindow.add(this.titlePane);
        titlePane.setVisible(true);

        this.mainWindow.repaint();
        this.mainWindow.revalidate();

        this.playerOneCustomizationPane.repaint();
        this.playerOneCustomizationPane.revalidate();
        this.playerOneCustomizationPane = getOnePlayerCustomizePane();
        this.playerOneCustomizationPane.setVisible(false);

        this.twoPlayerCustomizationPane.repaint();
        this.twoPlayerCustomizationPane.revalidate();
        this.twoPlayerCustomizationPane = getTwoPlayerCustomizationPane();
        this.twoPlayerCustomizationPane.setVisible(false);

    }


    //Ideally this gives us the main screen.
    //Doing this allows us the ability to turn off its visibility once
    //  the player has made their decision
    private JLayeredPane getTitlePane()
    {
        JLayeredPane newPane = new JLayeredPane();

        JLabel titleBG = new JLabel(new ImageIcon(new ImageIcon("resources/img/Menu.gif").getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT)));

        ImageIcon logoIcon = new ImageIcon("resources/img/C4_Logo.png");
        JLabel gameTitle =  new JLabel(logoIcon);
        gameTitle.setOpaque(false);

        ImageIcon onePlayerIcon = new ImageIcon(new ImageIcon("resources/img/OnePlayerButton.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        JLabel onePlayer = new JLabel(onePlayerIcon);
        onePlayer.setOpaque(false);

        ImageIcon twoPlayerIcon = new ImageIcon(new ImageIcon("resources/img/MultiplaterButton.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        JLabel twoPlayer = new JLabel(twoPlayerIcon);
        twoPlayer.setOpaque(false);


        //Adding mouse listener to make the JLabel clickable
        onePlayer.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //placeholder for the actual part that would be going to the next page
                onePlayer.setText("Starting One Player Game");

                gameMode = 0;

                titlePane.setVisible(false);
                mainWindow.add(playerOneCustomizationPane);
                playerOneCustomizationPane.setVisible(true);
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

                gameMode = 1;

                titlePane.setVisible(false);
                mainWindow.add(twoPlayerCustomizationPane);
                twoPlayerCustomizationPane.setVisible(true);
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
        
        gameTitle.setBounds(50,50,500,150);
        onePlayer.setBounds(150,250, 300,100);
        twoPlayer.setBounds(150,350,300,100);
        titleBG.setBounds(0,0,600,520);
        newPane.add(titleBG, Integer.valueOf(0));

        newPane.add(gameTitle,Integer.valueOf(1));
        newPane.add(onePlayer,Integer.valueOf(1));
        newPane.add(twoPlayer,Integer.valueOf(1));


        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getOnePlayerCustomizePane()
    {
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow"};
        JLayeredPane newPane = new JLayeredPane();
        ImageIcon player1NameIcon = new ImageIcon(new ImageIcon("resources/img/player1NameBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel playerOne = new JLabel(player1NameIcon);

        ImageIcon player1ColorIcon = new ImageIcon(new ImageIcon("resources/img/player1ColorBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel playerOneColor = new JLabel(player1ColorIcon);

        final JComboBox<String> playerChoices = new JComboBox<>(colorChoices);
        JTextField playerOneInput = new JTextField(16);
        ImageIcon startIcon = new ImageIcon(new ImageIcon("resources/img/startBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel startGame = new JLabel(startIcon);

        JLabel background = new JLabel(new ImageIcon(new ImageIcon("resources/img/Menu.gif").getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT)));
        background.setBounds(0,0,600,520);

        startGame.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Player Name set to: " + playerOneInput.getText());
                System.out.println("Player color set to: " + playerChoices.getSelectedItem());


                playerOneName = playerOneInput.getText();
                setPlayer1Color(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                setPlayer1Hover(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                player2Color = botColor;

                playerOneCustomizationPane.setVisible(false);
                mainWindow.add(gameModeSelectPane);
                gameModeSelectPane.setVisible(true);

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

        playerOne.setBounds(75,150,150,50);
        playerOneInput.setBounds(250,160,175,25);
        playerOneColor.setBounds(75,250,150,50);
        playerChoices.setBounds(250,260,175,25);
        startGame.setBounds(225,400,150,50);

        newPane.add(playerOne,Integer.valueOf(1));
        newPane.add(playerOneInput,Integer.valueOf(1));
        newPane.add(playerOneColor,Integer.valueOf(1));
        newPane.add(playerChoices,Integer.valueOf(1));
        newPane.add(startGame,Integer.valueOf(1));
        newPane.add(background,Integer.valueOf(0));


        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getTwoPlayerCustomizationPane()
    {
        String[] colorChoices = {"Green", "Blue", "Red", "Purple", "Black", "Yellow"};
        JLayeredPane newPane = new JLayeredPane();
        //Player 1
        ImageIcon player1NameIcon = new ImageIcon(new ImageIcon("resources/img/player1NameBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel playerOne = new JLabel(player1NameIcon);
        ImageIcon player1ColorIcon = new ImageIcon(new ImageIcon("resources/img/player1ColorBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel playerOneColor = new JLabel(player1ColorIcon);
        final JComboBox<String> playerChoices = new JComboBox<>(colorChoices);
        JTextField playerOneInput = new JTextField(16);
        //Player 2
        ImageIcon player2NameIcon = new ImageIcon(new ImageIcon("resources/img/player2NameBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel playerTwo = new JLabel(player2NameIcon);
        ImageIcon player2ColorIcon = new ImageIcon(new ImageIcon("resources/img/player2ColorBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel playerTwoColor = new JLabel(player2ColorIcon);
        final JComboBox<String> playerTwoChoices = new JComboBox<>(colorChoices);
        JTextField playerTwoInput = new JTextField(16);
        ImageIcon startIcon = new ImageIcon(new ImageIcon("resources/img/startBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel startGame = new JLabel(startIcon);

        //background
        JLabel background = new JLabel(new ImageIcon(new ImageIcon("resources/img/Menu.gif").getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT)));
        background.setBounds(0,0,600,520);

        startGame.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Player One Name: " + playerOneInput.getText());
                System.out.println("Player One Color: " + playerChoices.getSelectedItem());
                System.out.println("Player Two Name: " + playerTwoInput.getText());
                System.out.println("Player Two Color: " + playerTwoChoices.getSelectedItem());


                playerOneName = playerOneInput.getText();
                playerTwoName = playerTwoInput.getText();


                setPlayer1Color(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                setPlayer1Hover(Objects.requireNonNull(playerChoices.getSelectedItem()).toString());
                setPlayer2Color(Objects.requireNonNull(playerTwoChoices.getSelectedItem()).toString());
                setPlayer2Hover(Objects.requireNonNull(playerTwoChoices.getSelectedItem()).toString());


                if(playerChoices.getSelectedItem().toString() != playerTwoChoices.getSelectedItem().toString())
                {
                    twoPlayerCustomizationPane.setVisible(false);
                    gamePane = getGame();
                    mainWindow.add(gamePane);
                    gamePane.setVisible(true);
                }
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

        playerOne.setBounds(25,75,150,50);
        playerOneInput.setBounds(180,85,125,25);
        playerOneColor.setBounds(25,130,150,50);
        playerChoices.setBounds(180,145,125,25);

        playerTwo.setBounds(310,75,150,50);
        playerTwoInput.setBounds(460,85,125,25);
        playerTwoColor.setBounds(310,130,150,50);
        playerTwoChoices.setBounds(460,145,125,25);

        startGame.setBounds(225,400,150,50);

        newPane.add(playerOne,Integer.valueOf(1));
        newPane.add(playerOneInput,1);
        newPane.add(playerOneColor,Integer.valueOf(1));
        newPane.add(playerChoices,1);

        newPane.add(playerTwo,Integer.valueOf(1));
        newPane.add(playerTwoInput,1);
        newPane.add(playerTwoColor,Integer.valueOf(1));
        newPane.add(playerTwoChoices,1);

        newPane.add(startGame,Integer.valueOf(1));
        newPane.add(background, Integer.valueOf(0));

        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getGameModeSelectPane()
    {
        JLayeredPane newPane = new JLayeredPane();
        JLabel gameModeText = new JLabel("Select Game Mode");

        ImageIcon easyIcon = new ImageIcon(new ImageIcon("resources/img/EasyBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel easy = new JLabel(easyIcon);

        ImageIcon mediumIcon = new ImageIcon(new ImageIcon("resources/img/MedBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel medium = new JLabel(mediumIcon);

        ImageIcon hardIcon = new ImageIcon(new ImageIcon("resources/img/hardBTN.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
        JLabel hard = new JLabel(hardIcon);

        JLabel background = new JLabel(new ImageIcon(new ImageIcon("resources/img/Menu.gif").getImage().getScaledInstance(600, 550, Image.SCALE_DEFAULT)));
        background.setBounds(0,0,600,520);

        easy.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Easy Mode Selected");

                difficulty = 0;
                setEz_bg();
                gamePane = getGame();
                gameModeSelectPane.setVisible(false);
                mainWindow.add(gamePane);
                gamePane.setVisible(true);
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
                setMed_bg();
                gamePane = getGame();
                gameModeSelectPane.setVisible(false);
                mainWindow.add(gamePane);
                gamePane.setVisible(true);
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
                gameModeSelectPane.setVisible(false);
                setHard_bg();
                gamePane = getGame();
                mainWindow.add(gamePane);
                gamePane.setVisible(true);
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
        easy.setBounds(75,250,150,50);
        medium.setBounds(225,250,150,50);
        hard.setBounds(375,250,150,50);

        newPane.add(gameModeText,1);
        newPane.add(easy,Integer.valueOf(1));
        newPane.add(medium,Integer.valueOf(1));
        newPane.add(hard,Integer.valueOf(1));
        newPane.add(background, Integer.valueOf(0));

        newPane.setLayout(null);
        return newPane;
    }

    private JLayeredPane getGame()
    {
        JLayeredPane gamePane = new JLayeredPane();
        JPanel containedPanel = new JPanel();
        containedPanel.setBackground(new Color(0,0,0,0));
        ImageIcon background_Theme = background_Theme_Used;


        this.background = new JLabel(background_Theme);
        background.setBounds(0,0,600,600);



        int cols = 7, rows = 6, counter = 0;
        this.buttons = new JLabel[42];
        for(int i = 0; i<42; i++)
        {
            buttons[i] = new JLabel();
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
                    if(turn%2==1)
                    {
                        while(getWait())
                        {
                            System.out.println("Waiting on bot");
                        }
                    }

                    System.out.println("Column located: " + getCol_Located(finalCounter));
                    if(finalI%7==0 && oneCount>0)
                    {
                        oneClicked();
                        turn++;
                    }
                    if(finalI%7==1 && twoCount>0)
                    {
                        twoClicked();
                        turn++;
                    }
                    if(finalI%7==2 && threeCount>0)
                    {
                        threeClicked();
                        turn++;
                    }
                    if(finalI%7==3 && fourCount>0)
                    {
                        fourClicked();
                        turn++;
                    }
                    if(finalI%7==4 && fiveCount>0)
                    {
                        fiveClicked();
                        turn++;
                    }
                    if(finalI%7==5 && sixCount>0)
                    {
                        sixClicked();
                        turn++;
                    }
                    if(finalI%7==6 && sevenCount>0)
                    {
                        sevenClicked();
                        turn++;
                    }


                    makeMove(finalI);
                    ImageIcon image  = new ImageIcon(new ImageIcon("resources/img/Connect4Board.png").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
                    JLabel grid = new JLabel(image);

                    grid.setBounds(100,160,400,300);

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
        containedPanel.setBounds(100,160,400,300);

        //containedPanel.setVisible(false);

        ImageIcon image  = new ImageIcon(new ImageIcon("resources/img/Connect4Board.png").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
        JLabel grid = new JLabel(image);

        grid.setBounds(100,160,400,300);
        //grid.setOpaque(true);

        background.setBounds(0,0,600,600);

        gamePane.add(background,Integer.valueOf(0));
        gamePane.add(containedPanel, Integer.valueOf(1));
        gamePane.add(grid, Integer.valueOf(2));

        gamePane.setLayout(null);
        return gamePane;
    }

    private JLayeredPane winScreen()
    {
        JLayeredPane endPane = new JLayeredPane();
        JPanel containedPanel = new JPanel();
        JLabel winnerName = new JLabel(this.winningPlayer + " Wins!");

        winnerName.setBounds(225,25,125,25);

        containedPanel.setLayout(new GridLayout(6, 7));
        for(int i = 0; i<42; i++)
            containedPanel.add(this.buttons[i]);
        ImageIcon image  = new ImageIcon(new ImageIcon("resources/img/Connect4Board.png").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
        JLabel grid = new JLabel(image);

        ImageIcon background_Theme = background_Theme_Used;
        this.background = new JLabel(background_Theme);
        background.setBounds(0,0,600,600);

        containedPanel.setBounds(100,160,400,300);
        grid.setBounds(100,160,400,300);

        endPane.add(containedPanel,Integer.valueOf(1));
        endPane.add(grid,Integer.valueOf(2));
        endPane.add(winnerName,1);
        endPane.add(this.background);

        endPane.setLayout(null);
        return endPane;
    }

    public void gameEnd(String playerName)
    {
        this.winningPlayer = playerName;
        this.endPane = winScreen();

        this.gamePane.setVisible(false);

        this.mainWindow.add(this.endPane);
        endPane.setVisible(true);
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
        this.buttons[(oneCount+1)*7 - 7].setOpaque(true); // Note: ordering is very intentional

    }

    private void twoClicked()
    {
        if(turn%2==0)
            this.buttons[twoCount*7 - (6)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[twoCount*7 - (6)].setBackground(player2Color);
        twoCount--;
        this.buttons[(twoCount+1)*7 - (6)].setOpaque(true);
    }

    private void threeClicked()
    {
        if(turn%2==0)
            this.buttons[threeCount*7 - (5)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[threeCount*7 - (5)].setBackground(player2Color);
        threeCount--;
        this.buttons[(threeCount+1)*7 - (5)].setOpaque(true);
    }

    private void fourClicked()
    {
        if(turn%2==0)
            this.buttons[fourCount*7 - (4)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[fourCount*7 - (4)].setBackground(player2Color);
        fourCount--;
        this.buttons[(fourCount+1)*7 - (4)].setOpaque(true);
    }

    private void fiveClicked()
    {
        if(turn%2==0)
            this.buttons[fiveCount*7 - (3)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[fiveCount*7 - (3)].setBackground(player2Color);
        fiveCount--;
        this.buttons[(fiveCount+1)*7 - (3)].setOpaque(true);
    }

    private void sixClicked()
    {
        if(turn%2==0)
            this.buttons[sixCount*7 - (2)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[sixCount*7 - (2)].setBackground(player2Color);
        sixCount--;
        this.buttons[(sixCount+1)*7 - (2)].setOpaque(true);
    }

    private void sevenClicked()
    {
        if(turn%2==0)
            this.buttons[sevenCount*7 - (1)].setBackground(player1Color);
        if(turn%2==1)
            this.buttons[sevenCount*7 - (1)].setBackground(player2Color);
        sevenCount--;
        this.buttons[(sevenCount+1)*7 - (1)].setOpaque(true);
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

    public void resetMoveInt()
    {
        this.move = -1;
    }

    private void makeMove(int column)
    {
        this.move = column%7;
    }

    public int getMove()
    {
        return this.move;
    }

    public void setBotNextMove(int move)
    {
        if(move == 0)
            oneClicked();
        if(move == 1)
            twoClicked();
        if(move == 2)
            threeClicked();
        if(move == 3)
            fourClicked();
        if(move == 4)
            fiveClicked();
        if(move == 5)
            sixClicked();
        if(move == 6)
            sevenClicked();
        this.turn++;
    }


    public void botMovesFirst()
    {
        this.turn++;
    }

    public int getBotMove()
    {
        return this.botMove;
    }

    public void gameEnd()
    {
        oneCount = 0;
        twoCount = 0;
        threeCount = 0;
        fourCount = 0;
        fiveCount = 0;
        sixCount = 0;
        sevenCount = 0;
    }

    public void setWaitTrue()
    {
        this.wait = true;
    }

    public void setWaitFalse()
    {
        this.wait = false;
    }

    private boolean getWait()
    {
        return this.wait;
    }

    public void setEz_bg()
    {
        background_Theme_Used = ez_background_Theme;
        gamePane.repaint();
        gamePane.revalidate();
    }

    public void setMed_bg()
    {
        background_Theme_Used = med_background_Theme;
    }

    public void setHard_bg()
    {
        background_Theme_Used = hard_background_Theme;
    }
}