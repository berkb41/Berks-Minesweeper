package org.minesweeper.view;



import org.minesweeper.constant.GameConstant;
import org.minesweeper.model.GamePlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGui implements ActionListener {

    // Level buttons
    private JButton beginner, medium, expert;
    // Control buttons
    private JButton quit, newGame;
    // Game board
    private JButton[][] gameButtons;
    // Cell size since layout differs due to number of buttons
    private int cellSize;
    private JLabel roundCounter;

    // Game panels
    private JPanel mainPane;
    private JPanel gamePane;
    private JPanel levelSelectionPane;

    // Main frame
    private JFrame frame;

    // Game logic
    private GamePlay gamePlay;
    private String selectedMode;

    public MinesweeperGui() {
        selectedMode = "N/A";
    }

    public void createAndShowGUI() {
        frame = new JFrame("Berk's Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a title in the beginning section
        JLabel title = new JLabel("Select Game Level", SwingConstants.CENTER);
        Font heading = new Font("Times Roman", Font.BOLD, 20);
        title.setFont(heading);
        title.setPreferredSize(new Dimension(300, 50));
        title.setOpaque(true);
        title.setBackground(Color.decode("#FF6200"));
        frame.getContentPane().add(title, BorderLayout.PAGE_START);

        // Main pane with BorderLayout
        mainPane = new JPanel(new BorderLayout());
        mainPane.setPreferredSize(new Dimension(900, 900));
        mainPane.setBackground(Color.LIGHT_GRAY);
        mainPane.setOpaque(true);
        frame.getContentPane().add(mainPane, BorderLayout.CENTER);

        // Level selection panel
        levelSelectionPane = new JPanel(new FlowLayout());
        levelSelectionPane.setOpaque(false);

        // Add two buttons to our pane
        beginner = new JButton("Beginner");
        medium = new JButton("Medium");
        expert = new JButton("Expert");

        // Level selection buttons optimized
        Dimension buttonSize = new Dimension(200, 30);
        Color buttonColor = Color.ORANGE;

        beginner.setPreferredSize(buttonSize);
        beginner.setBackground(buttonColor);
        medium.setPreferredSize(buttonSize);
        medium.setBackground(buttonColor);
        expert.setPreferredSize(buttonSize);
        expert.setBackground(buttonColor);

        // Add the button event handlers
        beginner.addActionListener(this);
        medium.addActionListener(this);
        expert.addActionListener(this);

        // Add level selection buttons to levelSelectionPane
        levelSelectionPane.add(beginner);
        levelSelectionPane.add(medium);
        levelSelectionPane.add(expert);

        mainPane.add(levelSelectionPane, BorderLayout.CENTER);

        // Initialize quit and new game buttons
        quit = new JButton("Quit");
        quit.setPreferredSize(new Dimension(100, 30));
        quit.setBackground(Color.ORANGE);
        quit.addActionListener(this);

        newGame = new JButton("New Game");
        newGame.setPreferredSize(new Dimension(100, 30));
        newGame.setBackground(Color.ORANGE);
        newGame.addActionListener(this);

        // Create gamePane
        gamePane = new JPanel();
        gamePane.setOpaque(false);
        gamePane.setVisible(false);


        // Show the Frame
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Action event method to handle events from buttons
     */
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        // Check if the beginner mode selected
        if (source == beginner) {
            selectedMode = "beginner";
            initializeGamePlay();
        }
        // Check if the medium mode selected
        else if (source == medium) {
            selectedMode = "medium";
            initializeGamePlay();
        }
        // Check if the expert mode selected
        else if (source == expert) {
            selectedMode = "expert";
            initializeGamePlay();
        }
        // Check if quit button clicked
        else if (source == quit) {
            System.exit(0);
        }
        // check if new game requested
        else if (source == newGame) {
            // Restart the game with the same settings
            // Changing status of game not finished
            gamePlay.changeGameStatus();
            // Increase round and move count for checking end condition
            gamePlay.increaseRoundCount();
            gamePlay.resetMoveCount();
            // Resetting game board
            resetGameBoard();
        }
        // Handle board clicks based on CELL:X:Y convention
        else if (e.getActionCommand() != null && e.getActionCommand().startsWith("CELL:")) {
            String[] parts = e.getActionCommand().split(":");
            int i = Integer.parseInt(parts[1]);
            int j = Integer.parseInt(parts[2]);
            handleBoardClick(i, j);
        }

    }

    private void handleBoardClick(int x_Axis, int y_Axis) {

        // Increasing move count to determine in case of game won
        gamePlay.increaseMoveCount();


        // Check whether game is going on
        if (!gamePlay.isGameGoing()) {
            return;
        }


        // If the cell is mine the integer value is -1 if anything else will be either just open it or put number of adjacent mines
        int boardValue = gamePlay.getCellValue(x_Axis,y_Axis);

        if (boardValue < 0) {

            gameButtons[x_Axis][y_Axis].setText("M");
            gameButtons[x_Axis][y_Axis].setBackground(Color.ORANGE);
            gameButtons[x_Axis][y_Axis].setEnabled(false);
            gamePlay.changeGameStatus();

            //Show mines but preserve location
            makeMinesVisible();

            JOptionPane.showMessageDialog(frame, "Game Over! You can start new game by clicking new game button.");

        } else if (boardValue == 0) {

            gameButtons[x_Axis][y_Axis].setEnabled(false);

        } else {

            gameButtons[x_Axis][y_Axis].setText(String.valueOf(boardValue));
            gameButtons[x_Axis][y_Axis].setEnabled(false);

        }

        if (gamePlay.isGameWon()) {
            gamePlay.changeGameStatus();
            JOptionPane.showMessageDialog(frame, "Congratulations! You've won! You can start new game by clicking the button");
        }
    }

    private void initializeGamePlay() {

        // We will remove every component exist and re-draw
        mainPane.remove(levelSelectionPane);
        mainPane.remove(gamePane);

        switch(selectedMode) {
            case "medium": // Medium level 16*16
                gamePlay = new GamePlay(GameConstant.MEDIUM_BOARD_SIZE, GameConstant.MEDIUM_MINE_COUNT);
                cellSize = GameConstant.MEDIUM_CELL_SIZE;
                break;
            case "expert": // Expert level 30*30
                gamePlay = new GamePlay(GameConstant.EXPERT_BOARD_SIZE, GameConstant.EXPERT_MINE_COUNT);
                cellSize = GameConstant.EXPERT_CELL_SIZE;
                break;
            default: // This is for beginner but set as default to be able to start game in parameter error (9*9)
                gamePlay = new GamePlay(GameConstant.BEGINNER_BOARD_SIZE, GameConstant.BEGINNER_MINE_COUNT);
                cellSize = GameConstant.BEGINNER_CELL_SIZE;
        }

        gamePlay.startGame();

        // Game panel added to application as game will be starting
        mainPane.add(gamePane, BorderLayout.CENTER);
        gamePane.setVisible(true);

        // Draw the game board
        drawGameBoard();

        // Refresh board
        mainPane.revalidate();
        mainPane.repaint();
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }


    private void drawGameBoard() {
        gamePlay.increaseRoundCount();
        int boardSize = gamePlay.getBoardSize();

        // Initialize the gameButtons array
        gameButtons = new JButton[boardSize][boardSize];

        // Remove any existing components from game panel
        gamePane.removeAll();
        gamePane.setLayout(new BorderLayout());

        // Create the control panel for Quit and new game buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        // Adjust the size and color of the quit and new game buttons
        quit.setPreferredSize(new Dimension(300, 30));
        quit.setBackground(Color.ORANGE);
        newGame.setPreferredSize(new Dimension(300, 30));
        newGame.setBackground(Color.ORANGE);

        roundCounter = new JLabel();
        updateGameRoundLabel();

        // Add buttons to control panel
        controlPanel.add(quit);
        controlPanel.add(roundCounter);
        controlPanel.add(newGame);

        // Add control panel to the top of game panel
        gamePane.add(controlPanel, BorderLayout.NORTH);

        // Create the panel for the game buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(boardSize, boardSize));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(cellSize, cellSize)); // Adjust size as needed
                gameButtons[i][j] = button;

                // Action listener that will parse coordinate
                button.addActionListener(this);

                // Action command with convention of CELL:X:Y
                button.setActionCommand("CELL:" + i + ":" + j);

                // Add the button to the buttonPanel
                buttonPanel.add(button);
            }
        }

        gamePane.add(buttonPanel, BorderLayout.CENTER);

        gamePane.revalidate();
        gamePane.repaint();
    }

    private void makeMinesVisible() {
        int size = gamePlay.getBoardSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gamePlay.getCellValue(i, j) == -1) {
                    gameButtons[i][j].setText("M");
                    gameButtons[i][j].setBackground(Color.ORANGE);
                }
            }
        }
    }

    private void resetGameBoard() {
        updateGameRoundLabel();
        for (int i = 0; i < gamePlay.getBoardSize(); i++) {
            for (int j = 0; j < gamePlay.getBoardSize(); j++) {
                gameButtons[i][j].setText("");
                gameButtons[i][j].setEnabled(true);
                gameButtons[i][j].setBackground(null);
            }
        }
    }

    private void updateGameRoundLabel() {
        roundCounter.setText("Round: " + gamePlay.getRoundCount());
    }

}
