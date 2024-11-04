package model;

import util.GamePlayUtil;

public class GamePlay {

    final private Board gameBoard;
    private int gameCount;
    private int size;
    private boolean isGameGoing;

    public GamePlay(final int selectedSize, final int mineCount) {
        size = selectedSize;
        this.gameBoard = new Board(selectedSize, GamePlayUtil.createMineCoordinates(mineCount,selectedSize));
        gameCount = 0;
        isGameGoing = false;
    }

    public boolean isGameGoing() {
        return isGameGoing;
    }

    public int getBoardSize() {
        return size;
    }

    public void startGame() {
        isGameGoing = true;
        gameBoard.initializeBoard();
    }

    // Increase game round by 1
    public void increaseRoundCount() {
        gameCount += 1;
    }


    // Update game status based on recent move
    private void checkGameStatus(final int x_Axis, final int y_Axis) {
        isGameGoing = Board.gameBoard[x_Axis][y_Axis] != -1;
    }

    public int getCellValue(int x_Axis, int y_Axis) {
        return Board.gameBoard[x_Axis][y_Axis];
    }



}
