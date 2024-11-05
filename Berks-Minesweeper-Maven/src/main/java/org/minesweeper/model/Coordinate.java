package org.minesweeper.model;

import java.util.Objects;

public class Coordinate {
    private final int x_Axis;
    private final int y_Axis;

    public Coordinate(final int x_Axis, final int y_Axis) {
        this.x_Axis = x_Axis;
        this.y_Axis = y_Axis;
    }

    public int getX_Axis() {
        return x_Axis;
    }

    public int getY_Axis() {
        return y_Axis;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x_Axis == that.x_Axis && y_Axis == that.y_Axis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x_Axis, y_Axis);
    }

}
