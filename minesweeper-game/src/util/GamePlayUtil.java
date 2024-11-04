package util;

import model.Board;
import model.Coordinate;

import java.util.HashSet;
import java.util.Random;

public class GamePlayUtil {

    public static HashSet<Coordinate> createMineCoordinates(int mineCount, int size) {
        Random rand = new Random();
        HashSet<Coordinate> mineCoordinates = new HashSet<>();

        do {

            int x_Axis = rand.nextInt(size);
            int y_Axis = rand.nextInt(size);
            Coordinate newCoordinate = new Coordinate(x_Axis,y_Axis);
            mineCoordinates.add(newCoordinate);

        } while(mineCoordinates.size() < mineCount);

        return mineCoordinates;
    }

    public static int getAdjacentCount(Coordinate givenCell, int selectedSize) {

        int count = 0;

        int x = givenCell.getX_Axis();
        int y = givenCell.getY_Axis();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                // Skip the cell itself
                if (i == x && j == y) { continue; }

                // Check if indices are within bounds
                if (i >= 0 && i < selectedSize && j >= 0 && j < selectedSize) {
                    if (Board.gameBoard[i][j] == -1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
