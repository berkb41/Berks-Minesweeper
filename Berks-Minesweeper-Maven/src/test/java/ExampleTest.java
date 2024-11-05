import org.junit.Test;
import org.minesweeper.model.Board;
import org.minesweeper.model.Coordinate;
import org.minesweeper.util.GamePlayUtil;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    /*
    Testing whether created mines
    are in bound of game array or not
     */
    @Test
    public void testCreateMineCoordinates() {
        int mineCount = 25;
        int size = 9;
        HashSet<Coordinate> mines = GamePlayUtil.createMineCoordinates(mineCount, size);

        assertEquals(mineCount, mines.size(), "Should create exact number of mines");

        for (Coordinate mine : mines) {
            assertTrue(mine.getX_Axis() >= 0 && mine.getX_Axis() < size,
                    "X coordinate should be available on board");
            assertTrue(mine.getY_Axis() >= 0 && mine.getY_Axis() < size,
                    "Y coordinate should be available on board");
        }
    }


    /*
    At this test two mines are created next to each other
    And testing adjacent counting algorithm that has to detect two for a cell next to them
    But none for a cell which is irrelevant
     */
    @Test
    public void testGetAdjacentCount() {

        Board.gameBoard = new int[9][9];
        Board.gameBoard[0][0] = -1; // Place mine at (0,0)
        Board.gameBoard[0][1] = -1; // Place mine at (0,1)

        // Test adjacent count for coordinate (1,1)
        int count = GamePlayUtil.getAdjacentCount(new Coordinate(1, 1), 9);
        assertEquals(2, count, "Should detect 2 adjacent mines");

        // Test corner case
        count = GamePlayUtil.getAdjacentCount(new Coordinate(8, 8), 9);
        assertEquals(0, count, "Corner should have no adjacent mines");
    }
}
