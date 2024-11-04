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
    private JButton quit;
    private JPanel gamePanel = new JPanel();

    // Game logic
    private GamePlay gamePlay;
    private String selectedMode;

    public MinesweeperGui() {
        createAndShowGUI();
        selectedMode = "N/A";
    }

    private void createAndShowGUI() {
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
        JPanel settingsPane = new JPanel(new FlowLayout());
        settingsPane.setPreferredSize(new Dimension(900, 900));
        settingsPane.setBackground(Color.LIGHT_GRAY);
        settingsPane.setOpaque(true);
        frame.getContentPane().add(settingsPane, BorderLayout.CENTER);

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
        settingsPane.add(beginner);
        settingsPane.add(medium);
        settingsPane.add(expert);

        //
        quit = new JButton("Quit");
        quit.setPreferredSize(new Dimension(300, 30));
        quit.setBackground(Color.ORANGE);
        quit.addActionListener(this);



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
            case "medium":
                gamePlay = new GamePlay(GameConstant.MEDIUM_BOARD_SIZE, GameConstant.MEDIUM_MINE_COUNT);
                break;
            case "expert":
                gamePlay = new GamePlay(GameConstant.EXPERT_BOARD_SIZE, GameConstant.EXPERT_MINE_COUNT);
                break;
            default:
                gamePlay = new GamePlay(GameConstant.BEGINNER_BOARD_SIZE, GameConstant.BEGINNER_MINE_COUNT);
        }
    }

    private void hideLevelButtons() {
        beginner.setVisible(false);
        medium.setVisible(false);
        expert.setVisible(false);
    }

    private void showQuitButton() {

    }


}
