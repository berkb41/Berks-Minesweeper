package model;

final public class Cell {
    final Coordinate coordinate;
    private CellType cellType;
    private int adjacentMineCount;
    private boolean isChecked;
    private boolean isMine;

    public Cell(final Coordinate coordinate) {
        this.coordinate = coordinate;
        this.adjacentMineCount = 0;
        this.cellType = CellType.ADJACENT_0;
        this.isChecked = false;
        this.isMine = false;
    }

    public Coordinate getCoordinate() {
        return coordinate;
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

    public void changeToMineCell() {
        isMine = true;
    }

    public void updateCellType() {
        //TODO
    }

    public void checkCell() {
        isChecked = true;
    }

}
