package model;

import java.util.HashSet;

public class GamePlay {

    private final int selectedSize;
    private final int mineCount;
    final Board gameBoard;

    public GamePlay(final int selectedSize, final int mineCount) {
        this.selectedSize = selectedSize;
        this.mineCount = mineCount;
        this.gameBoard = new Board(selectedSize);
    }


    /* For initial fill operation on the board with adjacent mine counts
    Each cell has to be evaluated with the count of mine they are next to
    Also edge cases shall be considered such as for the top left cell
    Method shall not try to control any cell left then that
    Otherwise index out of bound error can be faced
     */

    public int getAdjacentCount(Cell givenCell, HashSet<Cell> mineCells, int size) {

        int count = 0;

        // If there is no cell on the left or / and right
        int minControlXAxis = givenCell.getCoordinate().getX_Axis() > 0 ? (givenCell.getCoordinate().getX_Axis()-1) : 0;
        int maxControlXAxis = givenCell.getCoordinate().getX_Axis() < (size-1) ? (givenCell.getCoordinate().getX_Axis() + 1) : (size-1);

        // If there is no cell on the up or / and down
        int minControlYAxis = givenCell.getCoordinate().getY_Axis() > 0 ? (givenCell.getCoordinate().getY_Axis()-1) : 0;
        int maxControlYAxis = givenCell.getCoordinate().getY_Axis() < (size-1) ? (givenCell.getCoordinate().getY_Axis() + 1) : (size-1);

        for(int i = minControlXAxis; i <= maxControlXAxis; i++) {
            for(int j = minControlYAxis; j < maxControlYAxis; j++) {
                count = gameBoard.isMineCell(i,j) ? (count + 1) : count;
            }
        }

        return count;
    }

    public void fillMines() {
        //TODO
        //Complete that part using stream and lambda
        //GamePlayUtil.createMineCoordinates(mineCount, selectedSize);
    }


}
