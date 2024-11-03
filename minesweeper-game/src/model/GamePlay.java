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


    public void startGame() {
        isGameGoing = true;
        gameBoard.initializeBoard();
    }

    public void increaseCount() {
        gameCount += 1;
    }

    public void makeMove(final int x_Axis, final int y_Axis) {
        Board.cellCheckingStatusBoard[x_Axis][y_Axis] = true;
        checkGameStatus(x_Axis, y_Axis);
        if(!isGameGoing) {

        }
    }

    private void checkGameStatus(final int x_Axis, final int y_Axis) {
        isGameGoing = Board.gameBoard[x_Axis][y_Axis] != -1;
    }



}
