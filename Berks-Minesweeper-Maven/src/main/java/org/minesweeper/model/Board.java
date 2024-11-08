package org.minesweeper.model;

import org.minesweeper.util.GamePlayUtil;

import java.util.HashSet;

public class Board {

    public static int[][] gameBoard;
    private final HashSet<Coordinate> mineCells;
    private final int size;

    public Board(final int size, HashSet<Coordinate> mineCells) {
        this.size = size;
        gameBoard = new int[size][size];
        this.mineCells = mineCells;
    }

    public void initializeBoard() {
        placeMines();
        initializeBoards();
    }

    private void placeMines() {
        mineCells.forEach(s -> gameBoard[s.getX_Axis()][s.getY_Axis()] = -1);
    }

    private void initializeBoards() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameBoard[i][j] = gameBoard[i][j] != -1 ? GamePlayUtil.getAdjacentCount(new Coordinate(i,j), size) : -1;
            }
        }
    }


}
