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
        testCardOne = new Card(1 , 1);
        testCardTwo = new Card(3, 4);
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
}
