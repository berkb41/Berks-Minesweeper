package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board {

    public static int[][] gameBoard;
    private final HashSet<Cell> mineCells;
    private final List<Cell> checkedCells;
    private final int size;


    public Board(final int size) {
        this.size = size;
        gameBoard = new int[size][size];
        mineCells = new HashSet<>();
        checkedCells = new ArrayList<>();
    }

    public HashSet<Cell> getMineCells() {
        return  mineCells;
    }

    public List<Cell> getCheckedCells() {
        return checkedCells;
    }

    public void checkCell(Cell checkedCell) {
        checkedCells.add(checkedCell);
    }

    public int getSizeOfTheBoard() {
        return size;
    }

    //TODO
    public boolean isMineCell(int x_Axis, int y_Axis) {
        return false;
    }

    public void insertNewMineCell(Cell newCell) {
        mineCells.add(newCell);
    }

}
