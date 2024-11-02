package model;

final public class Cell {
    final private int x_Axis;
    final private int y_Axis;
    private CellType cellType;
    private int adjacentMineCount;

    public Cell(int x_Axis, int y_Axis, CellType cellType) {
        this.x_Axis = x_Axis;
        this.y_Axis = y_Axis;
        this.adjacentMineCount = 0;
        this.cellType = cellType;
    }

    public int getX_Axis() {
        return x_Axis;
    }

    public int getY_Axis() {
        return y_Axis;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void changeCellType(CellType newState) {
        this.cellType = newState;
    }

    public int getAdjacentMineCount() {
        return  adjacentMineCount;
    }

    public void increaseAdjacentMineCount() {
        adjacentMineCount+=1;
    }

}
