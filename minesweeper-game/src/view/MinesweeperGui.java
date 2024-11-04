package view;

import constant.GameConstant;
import model.GamePlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGui implements ActionListener {

    // Level buttons
    private JButton beginner, medium, expert;
    private JButton quit, retry;
    private JButton[][] gameButtons;
    private int cellSize;
    private JPanel gamePane;

    // Game logic
    private GamePlay gamePlay;
    private String selectedMode;

    public MinesweeperGui() {
        selectedMode = "N/A";
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Berk's Minesweeper");

        // Add a title in the beginning section
        JLabel title = new JLabel("Select Game Level", SwingConstants.CENTER);
        Font heading = new Font("Times Roman", Font.BOLD, 20);
        title.setFont(heading);
        title.setPreferredSize(new Dimension(300, 50));
        title.setOpaque(true);
        title.setBackground(Color.decode("#FF6200"));
        frame.getContentPane().add(title, BorderLayout.PAGE_START);

        // Add a flow pane in the main center section
        JPanel mainPane = new JPanel(new FlowLayout());
        mainPane.setPreferredSize(new Dimension(900, 900));
        mainPane.setBackground(Color.LIGHT_GRAY);
        mainPane.setOpaque(true);
        frame.getContentPane().add(mainPane, BorderLayout.CENTER);

        // Add two buttons to our pane
        beginner = new JButton("Beginner");
        medium = new JButton("Medium");
        expert = new JButton("Expert");

        // Adjust the size and color of the beginner button
        beginner.setPreferredSize(new Dimension(200, 30));
        beginner.setBackground(Color.ORANGE);

        // Adjust the size and color of the medium button
        medium.setPreferredSize(new Dimension(200, 30));
        medium.setBackground(Color.ORANGE);

        // Adjust the size and color of the expert button
        expert.setPreferredSize(new Dimension(200, 30));
        expert.setBackground(Color.ORANGE);

        // Add the button listeners
        beginner.addActionListener(this);
        medium.addActionListener(this);
        expert.addActionListener(this);

        // Adding buttons to the pane
        mainPane.add(beginner);
        mainPane.add(medium);
        mainPane.add(expert);

        // Quit button
        quit = new JButton("Quit");
        quit.setPreferredSize(new Dimension(300, 30));
        quit.setBackground(Color.ORANGE);
        quit.addActionListener(this);

        // Retry button
        retry = new JButton("Retry");
        retry.setPreferredSize(new Dimension(300, 30));
        retry.setBackground(Color.ORANGE);
        retry.addActionListener(this);

        gamePane = new JPanel();
        gamePane.setOpaque(false);
        gamePane.setVisible(false);


        gamePane.add(quit);
        gamePane.add(retry);
        mainPane.add(gamePane);

        // Show the Frame
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Action event method to handle events from buttons
     */
    public void actionPerformed(ActionEvent e) {

        // Check if the beginner mode selected
        if (e.getSource() == beginner) {
            selectedMode = "beginner";
            initializeGamePlay();
        }
        // Check if the medium mode selected
        else if (e.getSource() == medium) {
            selectedMode = "medium";
            initializeGamePlay();
        }
        // Check if the expert mode selected
        else if (e.getSource() == expert) {
            selectedMode = "expert";
            initializeGamePlay();
        }

    }

    private void initializeGamePlay() {
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
        hideLevelButtons();
        showGameButtons();
        drawGameBoard();
    }

    private void hideLevelButtons() {
        beginner.setVisible(false);
        medium.setVisible(false);
        expert.setVisible(false);
    }

    private void showGameButtons() {
        gamePane.setVisible(true);
    }

    private void drawGameBoard() {
        int boardSize = gamePlay.getBoardSize();

        // Initialize the gameButtons array
        gameButtons = new JButton[boardSize][boardSize];

        // Remove any existing components from gamePane
        gamePane.removeAll();
        gamePane.setLayout(new GridLayout(boardSize, boardSize));
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(cellSize, cellSize)); // Adjust size as needed

                // Store the button in the array
                gameButtons[i][j] = button;

                // Add action listener to handle clicks
                button.addActionListener(this);

                // Use the button's action command to store its coordinates
                button.setActionCommand("CELL:" + i + ":" + j);

                // Add the button to the gamePane
                gamePane.add(button);
            }
        }

        // Refresh the gamePane to display the new buttons
        gamePane.revalidate();
        gamePane.repaint();
    }

}
