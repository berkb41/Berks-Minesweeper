package model;

import util.GamePlayUtil;

public class GamePlay {

    final private Board gameBoard;
    private int gameCount;
    private boolean isGameGoing;

    public GamePlay(final int selectedSize, final int mineCount) {
        this.gameBoard = new Board(selectedSize, GamePlayUtil.createMineCoordinates(mineCount,selectedSize));
        gameCount = 0;
        isGameGoing = false;
    }

    public boolean isGameGoing() {
        return isGameGoing;
    }

    public void startGame() {
        isGameGoing = true;
        gameBoard.initializeBoard();
    }

    // Increase game round by 1
    public void increaseRoundCount() {
        gameCount += 1;
    }


    // Evaluate each step after player made move
    public void makeMove(final int x_Axis, final int y_Axis) {
        Board.cellCheckingStatusBoard[x_Axis][y_Axis] = true;
        checkGameStatus(x_Axis, y_Axis);
    }

    // Update game status based on recent move
    private void checkGameStatus(final int x_Axis, final int y_Axis) {
        isGameGoing = Board.gameBoard[x_Axis][y_Axis] != -1;
    }



}