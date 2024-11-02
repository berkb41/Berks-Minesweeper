package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static Byte[][] gameBoard;
    private final List<Cell> mineCells;
    private final List<Cell> checkedCells;
    private final byte size;


    public Board(final byte size) {
        this.size = size;
        gameBoard = new Byte[size][size];
        mineCells = new ArrayList<>();
        checkedCells = new ArrayList<>();
    }

    public List<Cell> getMineCells() {
        return  mineCells;
    }

    public List<Cell> getCheckedCells() {
        return checkedCells;
    }

    public void checkCell(Cell checkedCell) {
        checkedCells.add(checkedCell);
    }

    public byte getSizeOfTheBoard() {
        return size;
    }

}
