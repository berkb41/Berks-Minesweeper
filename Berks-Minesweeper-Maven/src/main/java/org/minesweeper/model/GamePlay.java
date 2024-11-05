package org.minesweeper.model;

import org.minesweeper.util.GamePlayUtil;

public class GamePlay {

    final private Board gameBoard;
    private int gameCount;
    private final int size;
    private int moveCount;
    private final int totalMoveCount;
    private boolean isGameGoing;

    public GamePlay(final int selectedSize, final int mineCount) {
        size = selectedSize;
        this.gameBoard = new Board(selectedSize, GamePlayUtil.createMineCoordinates(mineCount,selectedSize));
        gameCount = 0;
        moveCount = 0;
        totalMoveCount = (selectedSize*selectedSize) - mineCount;
        isGameGoing = false;
    }

    public boolean isGameGoing() {
        return isGameGoing;
    }

    public int getBoardSize() {
        return size;
    }

    public void startGame() {
        changeGameStatus();
        gameBoard.initializeBoard();
    }

    // Increase game round by 1
    public void increaseRoundCount() {
        gameCount += 1;
    }

    // Increase move count by 1
    public void increaseMoveCount() {
        moveCount += 1;
    }

    // Reset move count for each round
    public void resetMoveCount() {
        moveCount = 0;
    }

    // Finish condition for winning game
    public boolean isGameWon() {
        return totalMoveCount == moveCount;
    }

    public int getRoundCount() {
        return gameCount;
    }

    public void changeGameStatus() {
        isGameGoing = !isGameGoing;
    }

    public int getCellValue(int x_Axis, int y_Axis) {
        return Board.gameBoard[x_Axis][y_Axis];
    }



}
