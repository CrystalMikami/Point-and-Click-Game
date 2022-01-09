package Tests;

import Model.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTests {

    private Card testCardOne;
    private Card testCardTwo;

    @BeforeEach
    public void setup() {
        testCardOne = new Card(1, 1, 0, 0, null);
        testCardTwo = new Card(3, 4, 0, 0, null);
    }

    @Test
    public void testSetFlipped() {
        assertEquals(0, testCardOne.getFlipped());

        testCardOne.setFlipped(1);

        assertEquals(1, testCardOne.getFlipped());
    }

    @Test
    public void testGetValue() {
        assertEquals(1, testCardOne.getValue());
        assertEquals(3, testCardTwo.getValue());
    }

    @Test
    public void testGetSuit() {
        assertEquals(1, testCardOne.getSuit());
        assertEquals(4, testCardTwo.getSuit());
    }

    @Test
    public void testGetFlipped() {
        assertEquals(0, testCardOne.getFlipped());

        testCardTwo.setFlipped(1);

        assertEquals(1, testCardTwo.getFlipped());
    }
}
