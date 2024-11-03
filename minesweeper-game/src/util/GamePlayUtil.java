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
        Coordinate testCoordinate = new Coordinate(-1,-1);

        // If there is no cell on the left or / and right
        int minControlXAxis = givenCell.getX_Axis() > 0 ? (givenCell.getX_Axis()-1) : 0;
        int maxControlXAxis = givenCell.getX_Axis() < (selectedSize-1) ? (givenCell.getX_Axis() + 1) : (selectedSize-1);

        // If there is no cell on the up or / and down
        int minControlYAxis = givenCell.getY_Axis() > 0 ? (givenCell.getY_Axis()-1) : 0;
        int maxControlYAxis = givenCell.getY_Axis() < (selectedSize-1) ? (givenCell.getY_Axis() + 1) : (selectedSize-1);

        for(int i = minControlXAxis; i <= maxControlXAxis; i++) {
            for(int j = minControlYAxis; j < maxControlYAxis; j++) {
                count = Board.gameBoard[i][j] == -1 ? (count + 1) : count;
            }
        }

        return count;
    }

}
