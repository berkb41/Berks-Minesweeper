package model;

final public class Cell {
    final private byte x_Axis;
    final private byte y_Axis;
    private byte adjacentMineCount;

    public Cell(byte x_Axis, byte y_Axis) {
        this.x_Axis = x_Axis;
        this.y_Axis = y_Axis;
        this.adjacentMineCount = 0;
    }

    public byte getX_Axis() {
        return x_Axis;
    }

    public byte getY_Axis() {
        return y_Axis;
    }

    public byte getAdjacentMineCount() {
        return  adjacentMineCount;
    }

    public void increaseAdjacentMineCount() {
        adjacentMineCount+=1;
    }
}
