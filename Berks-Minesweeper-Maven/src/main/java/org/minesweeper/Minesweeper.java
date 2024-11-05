package org.minesweeper;

import org.minesweeper.view.MinesweeperGui;

import javax.swing.*;

public class Minesweeper
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MinesweeperGui minesweeperGui = new MinesweeperGui();
                minesweeperGui.createAndShowGUI();
            }
        });
    }
}
