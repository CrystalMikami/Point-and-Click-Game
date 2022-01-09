package Tests;

import Model.Board;
import Model.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board testBoardEasy;
    Board testBoardMedium;
    Board testBoardHard;

    @BeforeEach
    public void setup() {
        testBoardEasy = new Board(1, 0, 0);
        testBoardMedium = new Board(2, 0, 0);
        testBoardHard = new Board(3, 0, 0);
    }

    @Test
    public void testAddCards() {
        testBoardEasy.addCards();

        for (int i = 0; i < testBoardEasy.countRow; i++) {
            for (int j = 0; j < testBoardEasy.countColumn; j++) {
                Card current = testBoardEasy.getCardAtPos(i, j);
                assertFalse(current.equals(null));
            }
        }
    }

    @Test
    public void testRefreshBoard() {
        testBoardEasy.addCards();

        testBoardEasy.refreshBoard(1, 0, 0);

        assertEquals(2, testBoardEasy.countRow);
        assertEquals(4, testBoardEasy.countColumn);

        for (int i = 0; i < testBoardEasy.countRow; i++) {
            for (int j = 0; j < testBoardEasy.countColumn; j++) {
                Card current = testBoardEasy.getCardAtPos(i, j);
                assertNull(current);
            }
        }

        testBoardEasy.addCards();

        testBoardEasy.refreshBoard(3, 0, 0);

        assertEquals(6, testBoardEasy.countRow);
        assertEquals(12, testBoardEasy.countColumn);

        for (int i = 0; i < testBoardEasy.countRow; i++) {
            for (int j = 0; j < testBoardEasy.countColumn; j++) {
                Card current = testBoardEasy.getCardAtPos(i, j);
                assertNull(current);
            }
        }
    }
}
